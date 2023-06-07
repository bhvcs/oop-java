package Week14.Practice2;

import java.util.ArrayList;

public class PriorityQueue <T>{
    ArrayList<T> items;
    ArrayList<Integer> priorities;

    public PriorityQueue() {
        this.items = new ArrayList<>();
        this.priorities = new ArrayList<>();
    }
    public void add(T item, int priority){
        int p = findPosByPriority(priority);
        items.add(p, item);
        priorities.add(p, priority);
    }
    public T remove(){
        if(items.isEmpty()) return null;
        T str = items.get(0);
        items.remove(0);
        priorities.remove(0);
        return str;
    }
    public int findPosByPriority(int priority){
        int i = 0;
        for(int el : priorities){//아무것도 없을 땐, 안 돌아 갈 것이다
            if(priority > el){
                break;
            }
            i++;
        }
        return i;
    }
}
