import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        if (args.length == 0) {
            while (true) {
                System.out.println("遊ぶゲームを選択して下さい。");
                System.out.println("0: 戦争、1: ブラックジャック");
                String gameAnswer = scan.nextLine();
                CardGame game = null;

                if (gameAnswer.equals("0")) {
                    System.out.println("");
                    // 戦争ゲームの開始
                    game = new War();

                } else if (gameAnswer.equals("1")) {
                    System.out.println("");
                    // 「ブラックジャック」ゲームの開始
                    game = new Blackjack();

                }
                if (game != null) {
                    game.play();
                    break;

                }

            }
        } else if (args[0].equals("--help")) {
            while (true) {
                System.out.println("ヘルプを表示するゲームを選択して下さい。");
                System.out.println("0: 戦争、1: ブラックジャック");
                String helpAnswer = scan.nextLine();

                if (helpAnswer.equals("0")) {
                    System.out.println("");
                    System.out.println("ゲームが始まったらEnterボタンで進めて下さい。");
                    System.out.println("表示されたカードの数字が大きい方に２点入ります。");
                    System.out.println("引き分けの場合はどちらにも点は入らず、次のターンの勝者に４点入ります。");
                    System.out.println("最後に合計点数の高い方が勝者です。");
                    break;
                } else if (helpAnswer.equals("1")) {
                    System.out.println("");
                    System.out.println("カードの数字の合計点数が21点に近い人が勝者です。");
                    System.out.println("しかし、21点を超えた瞬間負けとなります。");
                    System.out.println("最初に2枚のカードが表示されカードを追加するか選択します。");
                    System.out.println("yでカードを追加し、勝負できると判断したらnを押して下さい。");
                    System.out.println("21点以下かつ21点に近い方の勝利となります。");
                    break;
                }
            }
        }

        scan.close();
    }
}
