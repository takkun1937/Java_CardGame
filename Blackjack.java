import java.util.Scanner;

public class Blackjack extends CardGame {

    // フィールド定義
    private Card[] player = new Card[26];
    private Card[] dealer = new Card[26];

    private int[] cardScore = new int[53];

    private int playerScore = 0;
    private int dealerScore = 0;
    private int addCardTime = 1;

    // コンストラクタ
    public Blackjack() {
        super(true);

        for (int i = 0; i < deck.length; i++) {
            if (deck[i].number >= 2 && deck[i].number <= 9) {
                cardScore[i] = deck[i].number;
            } else if (deck[i].number >= 10 && deck[i].suit != Suit.JOKER) {
                cardScore[i] = 10;
            } else if (deck[i].number == 1) {
                cardScore[i] = 11;
            } else if (deck[i].suit == Suit.JOKER) {
                cardScore[i] = 0;
            }
        }

        // System.arraycopy(コピー元の配列, コピー元の開始位置, コピー先の配列, コピー先の開始位置, コピーする数);
        System.arraycopy(deck, 0, player, 0, 26);
        System.arraycopy(deck, 26, dealer, 0, 26);
    }

    // playメソッド
    public void play() {
        Scanner scan = new Scanner(System.in);

        System.out.println("ゲームスタート!");
        System.out.println("ディーラーのオープンカードは " + dealer[0] + " です。");
        System.out.println("");

        // playerのカード追加
        LOOP: while (playerScore <= 21) {

            System.out.println("あなたのカードは");
            if (cardScore[0] == 11) {
                System.out.println(player[0] + " : " + cardScore[0] + "点(1点)");
            } else {
                System.out.println(player[0] + " : " + cardScore[0] + "点");
            }

            if (cardScore[1] == 11) {
                System.out.println(player[1] + " : " + cardScore[1] + "点(1点)");
            } else {
                System.out.println(player[1] + " : " + cardScore[1] + "点");
            }

            playerScore = cardScore[0] + cardScore[1];

            // 最初の二枚とも１が出た場合
            if (playerScore > 21) {
                playerScore -= 10;
            }

            // カード追加
            for (int j = 2; j <= addCardTime; j++) {
                if (cardScore[j] == 11) {
                    System.out.println(player[j] + " : " + cardScore[j] + "点(1点)");
                } else {
                    System.out.println(player[j] + " : " + cardScore[j] + "点");
                }

                playerScore += cardScore[j];

                // １が出たときの計上
                if (player[j].number == 1 && playerScore > 21) {
                    playerScore -= 10;
                }
            }

            addCardTime += 1;

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

            // playerのカード追加の選択
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

        }

        scan.close();
    }

    // ディーラーのカードオープン
    private void match() {
        System.out.println("");
        System.out.println("ディーラーのカードは");

        if (cardScore[26] == 11) {
            System.out.println(dealer[0] + " : " + cardScore[26] + "点(1点)");
        } else {
            System.out.println(dealer[0] + " : " + cardScore[26] + "点");
        }

        if (cardScore[27] == 11) {
            System.out.println(dealer[1] + " : " + cardScore[27] + "点(1点)");
        } else {
            System.out.println(dealer[1] + " : " + cardScore[27] + "点");
        }

        dealerScore = cardScore[26] + cardScore[27];

        // 最初の二枚とも１が出た場合
        if (dealerScore > 21) {
            dealerScore -= 10;
        }

        // ディーラーのスコアが17点未満の場合
        if (dealerScore < 17) {
            for (int k = 2; k < dealer.length; k++) {
                if (cardScore[k + 26] == 11) {
                    System.out.println(dealer[k] + " : " + cardScore[k + 26] + "点(1点)");
                } else {
                    System.out.println(dealer[k] + " : " + cardScore[k + 26] + "点");
                }

                dealerScore += cardScore[k + 26];

                // １が出たときの計上
                if (dealer[k].number == 1 && dealerScore > 21) {
                    dealerScore -= 10;
                }

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
