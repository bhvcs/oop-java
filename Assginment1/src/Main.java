import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int currentMoney = 0;
        int N, M;

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.print("Input your money and number of lottery tickets:\n<<");
            N = sc.nextInt();
            M = sc.nextInt();

            if(N == 0 || M == 0) {
                System.out.println(">>End of program");
                break;
            }
            if(currentMoney + N < 10 * M) continue;

            currentMoney += N - 10 * M;

            LotteryGenerator LG = new LotteryGenerator(M);
            LG.setWinningNumbers();

            System.out.print(">>Round Winning number : ");
            for(int i=0; i < 7; i++){
                if(i == 6){//보너스 넘버
                    System.out.println("+ " + LG.getWinningNumbers()[i]);
                }else{
                    System.out.print(LG.getWinningNumbers()[i] + " ");
                }
            }

            LotteryChecker LC = new LotteryChecker();
            for(int i=0; i < M; i++){
                LG.setLotteryNumbers();
                LC.setLotNums(LG.getTotalLotteryTickets()[i]);
                LC.checkRanks(LG.getWinningNumbers());
                LC.printCurrentResult();
            }
            System.out.println(">>Remaining money : " + currentMoney );
            LC.printTotalResult();
        }
    }
}