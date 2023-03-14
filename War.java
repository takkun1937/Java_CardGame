import java.util.Scanner;

public class War extends CardGame {

    // プレイヤーのデッキ作成
    private Card[] playerDeck1 = new Card[26];
    private Card[] playerDeck2 = new Card[26];

    // コンストラクタ
    public War() {
        super(false);
        // System.arraycopy(コピー元の配列, コピー元の開始位置, コピー先の配列, コピー先の開始位置, コピーする数);
        System.arraycopy(deck, 0, playerDeck1, 0, 26);
        System.arraycopy(deck, 26, playerDeck2, 0, 26);
    }

    @Override
    public void play() {

        Scanner scan = new Scanner(System.in);

        // スコア
        int playerScore1 = 0;
        int playerScore2 = 0;
        int point = 2;

        System.out.println("「戦争」ゲームスタート!");

        // ゲーム開始
        for (int times = 0; times < playerDeck1.length; times++) {

            System.out.print("せーの!");
            scan.nextLine();
            System.out.println("あなた: " + playerDeck1[times] + ", 相手: " + playerDeck2[times]);

            // 勝敗判定
            if (playerDeck1[times].number > playerDeck2[times].number) {
                System.out.println("あなたの勝ち!");
                playerScore1 = playerScore1 + point;
                System.out.println("[現在のスコア] あなた: " + playerScore1 + ", 相手: " + playerScore2);
                point = 2;
            } else if (playerDeck1[times].number < playerDeck2[times].number) {
                System.out.println("あなたの負け...。");
                playerScore2 = playerScore2 + point;
                System.out.println("[現在のスコア] あなた: " + playerScore1 + ", 相手: " + playerScore2);
                point = 2;
            } else if (playerDeck1[times].number == playerDeck2[times].number) {
                System.out.println("引き分け");
                System.out.println("[現在のスコア] あなた: " + playerScore1 + ", 相手: " + playerScore2);
                point = point + 2;
            }

            // １行あける
            System.out.println("");
        }

        // 勝利者判定
        if (playerScore1 > playerScore2) {
            System.out.println("ゲームに勝ちました!");
        } else if (playerScore1 < playerScore2) {
            System.out.println("ゲームに負けました...。");
        } else if (playerScore1 == playerScore2) {
            System.out.println("ゲームは引き分けです。");
        }

        scan.close();

    }
}
