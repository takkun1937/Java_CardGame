import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
            Path path = null;
            while (true) {
                System.out.println("ヘルプを表示するゲームを選択して下さい。");
                System.out.println("0: 戦争、1: ブラックジャック");
                String helpAnswer = scan.nextLine();

                if (helpAnswer.equals("0")) {
                    path = Paths.get("War.txt");
                } else if (helpAnswer.equals("1")) {
                    path = Paths.get("Blackjack.txt");
                }
                if (path != null) {
                    System.out.println("");
                    try {
                        String content = Files.readString(path);
                        System.out.println(content);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    break;
                }
            }
        }
        scan.close();
    }
}
