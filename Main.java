import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("遊ぶゲームを選択して下さい。");
            System.out.println("0: 戦争、1: ブラックジャック");
            String answer = scan.nextLine();

            if (answer.equals("0")) {
                System.out.println("");
                // 戦争ゲームの開始
                War war = new War();
                war.play();
                break;
            } else if (answer.equals("1")) {
                System.out.println("");
                // 「ブラックジャック」ゲームの開始
                Blackjack blackjack = new Blackjack();
                blackjack.play();
                break;
            }
        }

        scan.close();
    }
}
