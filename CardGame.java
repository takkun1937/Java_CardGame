import java.util.Random;

public abstract class CardGame {

    // デッキの枚数
    public boolean hasJoker = true;

    protected Card[] deck = new Card[53];

    protected CardGame(boolean hasJoker) {
        this.hasJoker = hasJoker;
        int num = hasJoker ? 53 : 52;
        this.deck = new Card[num];
        shuffle();
    }

    public abstract void play();

    protected void shuffle() {

        for (int i = 0; i < deck.length; i++) {
            deck[i] = new Card(i);
        }

        Random rnd = new Random();

        // デッキシャッフル
        for (int i = deck.length - 1; i >= 0; i--) {

            int index = rnd.nextInt(i + 1);

            // 要素の入れ替え
            Card tmp = deck[index];
            deck[index] = deck[i];
            deck[i] = tmp;

        }

    }

}