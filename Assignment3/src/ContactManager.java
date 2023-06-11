import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ContactManager {
    MyStorage<ContactInfo> contactStorage;
    CommandLineInterface cli;

    public ContactManager(CommandLineInterface cli) {
        this.cli = cli;
        this.contactStorage = new MyStorage<ContactInfo>();
    }
    public void setStorageSize() throws Exception{
        int sizeInput = cli.getSetSizeMenu(contactStorage.size);
        contactStorage.setSize(sizeInput);
    }
    public void saveToFile() throws FileNotFoundException {
        String[] allInfo = new String[contactStorage.storage.size()];
        int i = 0;
        for(ContactInfo el : contactStorage.storage){
            allInfo[i++] = el.getInfo();
        }
        cli.printToFile(allInfo);
    }
    public void loadFromFile() throws IOException {
        ArrayList<String> allInfo = cli.scanInFile();
        contactStorage.storage.clear();//빈공간으로 초기화 해주고
        StringTokenizer st;
        String type;
        for(int i = 0; i < allInfo.size(); i++){
            st = new StringTokenizer(allInfo.get(i));
            type = st.nextToken();
            if(type.equals("NormalContact")) contactStorage.storage.add(new NormalContact(st.nextToken(), st.nextToken(), st.nextToken()));
            else if(type.equals("ClubContact")) contactStorage.storage.add(new ClubContact(st.nextToken(), st.nextToken(), st.nextToken()));
            if(type.equals("DepartmentContact")) contactStorage.storage.add(new DepartmentContact(st.nextToken(), st.nextToken(), st.nextToken()));
        }
        contactStorage.size = contactStorage.storage.size();//다시 새로 넣은 만큼 size 초기화
    }
    public void createContact() throws Exception{
        if(contactStorage.size == 0) throw new Exception("please set contact size first");
        if(contactStorage.size > -1 && contactStorage.storage.size() >= contactStorage.size) throw new Exception("storage is full");
        String[] contactInput = cli.getCreateContactMenu();
        ContactInfo contact = null;
        switch(Integer.parseInt(contactInput[0])){
            case 1:{//normal contact을 create하고자 하는 경우
                contact = new NormalContact(contactInput[1], contactInput[2], contactInput[3]);
                break;
            }case 2:{//club contact을 create하고자 하는 경우
                contact = new ClubContact(contactInput[1], contactInput[2], contactInput[3]);
                break;
            }case 3:{//department contact을 create하고자 하는 경우
                contact = new DepartmentContact(contactInput[1], contactInput[2], contactInput[3]);
                break;
            }
        }//새로운 contact를 생성하고 저장까지함;
        contactStorage.storage.add(contact);
        cli.printContact(contact.toString());
    }
    public void searchContact() throws Exception{
        if(contactStorage.size == 0) throw new Exception("please set contact size first");
        String[] info = cli.getSearchContactMenu();
        int i = findContactPos(Integer.parseInt(info[0]), info[1]);//contactStorage.storage.get(i)
        if(i == -1) throw new Exception("that contact does not exist");
        else cli.printContact(contactStorage.storage.get(i).toString());
    }
    public void deleteContact() throws Exception{
        if(contactStorage.size == 0) throw new Exception("please set contact size first");
        String[] info = cli.getDeleteContactMenu();//찾은 놈을 가져왔다
        int i = findContactPos(Integer.parseInt(info[0]), info[1]);//중복
        if(i == -1) throw new Exception("that contact does not exist");
        cli.printContact(contactStorage.storage.get(i).toString());
        contactStorage.storage.remove(i);//삭제 완료
    }
    public void editContact() throws Exception{
        if(contactStorage.size == 0) throw new Exception("please set contact size first");
        String[] info = cli.getEditContactMenu();//길이 4짜리 배열
        int i = findContactPos(Integer.parseInt(info[0]), info[1]);//찾은 놈을 가져왔다
        if(i == -1) throw new Exception("that contact does not exist");
        switch(Integer.parseInt(info[2])) {
            case 1: {
                contactStorage.storage.get(i).setName(info[3]);
                break;
            }
            case 2: {
                contactStorage.storage.get(i).setPhone_number(info[3]);
                break;
            }
            case 3: {
                if(!(contactStorage.storage.get(i) instanceof NormalContact)) throw new Exception("that contact doesn't have relation");
                ((NormalContact) contactStorage.storage.get(i)).setRelation(info[3]);
                break;
            }
            case 4: {
                if(!(contactStorage.storage.get(i) instanceof ClubContact)) throw new Exception("that contact doesn't have club");
                ((ClubContact) contactStorage.storage.get(i)).setClub(info[3]);
                break;
            }
            case 5: {
                if(!(contactStorage.storage.get(i) instanceof DepartmentContact)) throw new Exception("that contact doesn't have department");
                ((DepartmentContact) contactStorage.storage.get(i)).setDepartment(info[3]);
                break;
            }
        }//편집을 마침
        cli.printContact(contactStorage.storage.get(i).toString());
    }
    public int findContactPos(int varType, String variable){
        int i;
        switch(varType){
            case 1:{
                for(i = 0; i < contactStorage.storage.size(); i++){
                    if(contactStorage.storage.get(i).getName().equals(variable)) break;
                }
                break;
            } case 2:{
                for(i = 0; i < contactStorage.storage.size(); i++){
                    if(contactStorage.storage.get(i).getPhone_number().equals(variable)) break;
                }
                break;
            } case 3:{
                for(i = 0; i < contactStorage.storage.size(); i++){
                    if(contactStorage.storage.get(i) instanceof NormalContact && ((NormalContact) contactStorage.storage.get(i)).getRelation().equals(variable)){
                        break;
                    }
                }
                break;
            }case 4:{
                for(i = 0; i < contactStorage.storage.size(); i++){
                    if(contactStorage.storage.get(i) instanceof ClubContact && ((ClubContact) contactStorage.storage.get(i)).getClub().equals(variable)){
                        break;
                    }
                }
                break;
            }case 5:{
                for(i = 0; i < contactStorage.storage.size(); i++){
                    if(contactStorage.storage.get(i) instanceof DepartmentContact && ((DepartmentContact) contactStorage.storage.get(i)).getDepartment().equals(variable)){
                        break;
                    }
                }
                break;
            } default: return -1;//오류관리
        }//해당하는 contact의 index를 storage에서 찾았다
        if(i == contactStorage.storage.size()) return -1;
        return i;
    }
    public ArrayList<String>[] provideAllContact(){//arraylist가 담긴 배열
        ArrayList<String>[] contactList = new ArrayList[3];
        for(int i = 0; i < 3; i++){
            contactList[i] = new ArrayList<String>();
        }
        ContactInfo tmp;
        for(int i = 0; i < contactStorage.storage.size(); i++){//contactStorage.size로 돌릴 땐 null인 부분이 있을 수 있으니 조심해야함
            tmp = contactStorage.storage.get(i);
            if(tmp instanceof NormalContact){
                contactList[0].add(tmp.getName());
                contactList[0].add(tmp.getPhone_number());
                contactList[0].add(((NormalContact)tmp).getRelation());
            }else if(tmp instanceof ClubContact){
                contactList[1].add(tmp.getName());
                contactList[1].add(tmp.getPhone_number());
                contactList[1].add(((ClubContact)tmp).getClub());
            }else if(tmp instanceof DepartmentContact){
                contactList[2].add(tmp.getName());
                contactList[2].add(tmp.getPhone_number());
                contactList[2].add(((DepartmentContact)tmp).getDepartment());
            }
        }
        return contactList;
    }
    private class MyStorage<T>{
        private int size;
        private ArrayList<T> storage;

        public void setSize(int size) {
            this.size = size;
        }

        public MyStorage() {
            this.size = 0;
            this.storage = new ArrayList<T>();
        }
    }
}
