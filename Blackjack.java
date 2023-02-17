import java.util.Scanner;
import java.util.ArrayList;

public class Blackjack extends CardGame {

    // フィールド定義
    private ArrayList<Card> playerDeck = new ArrayList<Card>();
    private ArrayList<Card> dealerDeck = new ArrayList<Card>();
    private int addCardTimes = 0;
    private int addScore = 0;
    private int turn = 0;
    private boolean playerTurn = true;
    private int playerScore = 0;
    private int dealerScore = 0;

    // コンストラクタ
    public Blackjack() {
        super(true);
    }

    // playメソッド
    public void play() {
        Scanner scan = new Scanner(System.in);

        addCard("both");
        addCard("both");

        System.out.println("ゲームスタート!");
        System.out.println("ディーラーのオープンカードは " + dealerDeck.get(0) + " です。");
        System.out.println("");

        LOOP: while (playerScore <= 21) {
            System.out.println("あなたのカードは");
            System.out.println(playerDeck.get(0) + " : " + cardScore(playerDeck.get(0).number));
            playerScore += addScore;
            System.out.println(playerDeck.get(1) + " : " + cardScore(playerDeck.get(1).number));
            playerScore += addScore;

            // 追加したカードの文字列表示
            if (turn >= 1) {
                addCard("player");
                for (int i = 2; i <= turn + 1; i++) {
                    System.out.println(playerDeck.get(i) + " : " + cardScore(playerDeck.get(i).number));
                    playerScore += addScore;
                }
            }

            System.out.println("(合計: " + playerScore + "点)");
            System.out.println("です。");
            System.out.println("");

            // playerが21点を超えた場合
            if (playerScore > 21) {
                System.out.println("21点を越えたので失格（バスト）です。");
                System.out.println("");
                System.out.println("ゲームに負けました...。");
                break;
            }

            // カード追加の選択
            while (true) {
                System.out.print("カードを追加（ヒット）しますか?(y|n) ");
                String answer = scan.nextLine();
                if (answer.equals("y")) {
                    break;
                } else if (answer.equals("n")) {
                    match();
                    break LOOP;
                }
            }

            System.out.println("");
            turn += 1;
            playerScore = 0;
        }

        scan.close();

    }

    // カード追加
    private void addCard(String distributed) {
        // playerのみカード追加
        if (distributed.equals("player")) {
            playerDeck.add(deck[addCardTimes]);
            addCardTimes += 1;
        } else if (distributed.equals("dealer")) {
            // ディーラーのみ追加
            dealerDeck.add(deck[addCardTimes]);
            addCardTimes += 1;
        } else if (distributed.equals("both")) {
            // 両方のカード追加
            playerDeck.add(deck[addCardTimes]);
            addCardTimes += 1;
            dealerDeck.add(deck[addCardTimes]);
            addCardTimes += 1;
        }
    }

    // カードの得点定義
    private String cardScore(int number) {
        if (number >= 2 && number <= 9) {
            addScore = number;
            return number + "点";
        } else if (number >= 10 && number <= 13) {
            addScore = 10;
            return "10点";
        } else if (number == 1) {
            if (playerScore <= 10 && playerTurn) {
                addScore = 11;
            } else if (playerScore > 10 && playerTurn) {
                addScore = 1;
            } else if (dealerScore <= 10 && playerTurn == false) {
                addScore = 11;
            } else if (dealerScore > 10 && playerTurn == false) {
                addScore = 1;
            }
            return "11点(1点)";
        } else {
            addScore = 0;
            return "0点";
        }
    }

    // ディーラーのカードオープン
    private void match() {
        playerTurn = false;
        System.out.println("");
        System.out.println("ディーラーのカードは");
        System.out.println(dealerDeck.get(0) + " : " + cardScore(dealerDeck.get(0).number));
        dealerScore += addScore;
        System.out.println(dealerDeck.get(1) + " : " + cardScore(dealerDeck.get(1).number));
        dealerScore += addScore;

        // ディーラーの得点が17点を越えるまでカード追加
        if (dealerScore < 17) {
            for (int i = 2; i < deck.length; i++) {
                addCard("dealer");
                System.out.println(dealerDeck.get(i) + " : " + cardScore(dealerDeck.get(i).number));
                dealerScore += addScore;

                if (dealerScore >= 17) {
                    break;
                }
            }
        }

        System.out.println("(合計: " + dealerScore + "点)");
        System.out.println("です。");
        System.out.println("");

        // 勝敗判定
        if (dealerScore > 21) {
            System.out.println("21点を越えたので失格（バスト）です。");
            System.out.println("");
            System.out.println("ゲームに勝ちました!");
        } else if (playerScore > dealerScore) {
            System.out.println("ゲームに勝ちました!");
        } else if (playerScore < dealerScore) {
            System.out.println("ゲームに負けました...。");
        } else {
            System.out.println("ゲームは引き分けです。");
        }
    }
}
