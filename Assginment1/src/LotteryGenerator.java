import java.util.Random;

public class LotteryGenerator {
    private int cnt = 0;
    private int winningNumbers[];

    private int[][] totalLotteryTickets;
    public int[][] getTotalLotteryTickets() {
        return totalLotteryTickets;
    }

    public LotteryGenerator(int M){
        this.setWinningNumbers();
        this.totalLotteryTickets = new int[M][];
    }
    public int[] getWinningNumbers() {
        return winningNumbers;
    }
    public int[] createNums(int num){
        Random rnd = new Random();
        int arr[] = new int[num];
        for(int i = 0; i < num; i++){
            arr[i] = rnd.nextInt(20) + 1;
            for(int j = 0; j < i; j++){
                if(arr[i] == arr[j]){
                    i--;
                }
            }
        }
        return arr;
    }

    public void setWinningNumbers(){
        this.winningNumbers = createNums(7);//보너스도 한번에 넣겠다
    }
    public void setLotteryNumbers(){
        int[] lotteryNumbers = createNums(6);
        this.totalLotteryTickets[cnt++] = lotteryNumbers;
    }
}
