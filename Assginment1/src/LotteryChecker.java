public class LotteryChecker {
    private int[] ranks = new int[4];
    private String currentRank;
    private int count;
    private int[] lotteryNumbers;
    private String state;

    public void setLotNums(int[] lotNums) {
        lotteryNumbers = lotNums;
    }
    private void setCurrentRank(){
        switch(count) {
            case 6:
                currentRank = " (1st place)";
                state = "Winner";
                break;
            case 5:
                currentRank = " (2nd place)";
                state = "Winner";
                break;
            case 4:
                currentRank = " (3rd place)";
                state = "Winner";
                break;
            case 3:
                currentRank = " (4th place)";
                state = "Winner";
                break;
            default:
                currentRank = "";
                state = "Lose";
        }
        if(count >= 3){
            ranks[6-count] += 1;
        }
    }


    public void checkRanks(int[] winningNumbers){//TODO: bonus number는 4부터 안셈, count가 3이상이 되면 보너스도 비교한다
        count = 0;
        for(int i = 0; i < lotteryNumbers.length; i++){
            for(int j=0; j < winningNumbers.length-1; j++){//보너스를 제외한 비교
                if ( lotteryNumbers[i] == winningNumbers[j]){
                    count++;
                }
            }
        }if(count >= 4){
            for(int i = 0; i < lotteryNumbers.length; i++){
                if(lotteryNumbers[i] == winningNumbers[winningNumbers.length-1]){//보너스와 비교
                    count++;
                }
            }
        }
        setCurrentRank();
    }

    public void printCurrentResult(){
        System.out.print(">>Lottery number :");
        for(int i=0; i < lotteryNumbers.length; i++){
            System.out.print(" " + lotteryNumbers[i]);
        }
        System.out.println(" " + state + currentRank);
    }

    public void printTotalResult(){
        System.out.println(">>1st place: " + ranks[0]);
        System.out.println(">>2nd place: " + ranks[1]);
        System.out.println(">>3rd place: " + ranks[2]);
        System.out.println(">>4th place: " + ranks[3]);
    }
}
