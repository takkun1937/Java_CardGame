public class Card {
    // フィールド
    public int number = 0;
    public Suit suit;

    // コンストラクタ
    public Card(int cardNum) {
        if (cardNum >= 0 && cardNum < 13) {
            this.suit = Suit.HEART;
            this.number = cardNum + 1;
        } else if (cardNum >= 13 && cardNum < 26) {
            this.suit = Suit.SPADE;
            this.number = cardNum - 12;
        } else if (cardNum >= 26 && cardNum < 39) {
            this.suit = Suit.DIAMOND;
            this.number = cardNum - 25;
        } else if (cardNum >= 39 && cardNum < 52) {
            this.suit = Suit.CLUB;
            this.number = cardNum - 38;
        } else if (cardNum == 52) {
            this.suit = Suit.JOKER;
            this.number = cardNum;
        }
    }

    public Card(Suit suit, int number) {
        this.suit = suit;
        this.number = number;
    }

    // マークとの対応
    public String getSuitStr() {

        switch (this.suit) {
            case HEART: {
                return "ハートの";
            }
            case SPADE: {
                return "スペードの";
            }
            case DIAMOND: {
                return "ダイヤの";
            }
            case CLUB: {
                return "クローバーの";
            }
            case JOKER: {
                return "JOKER";
            }
            default: {
                return "";
            }

        }
    }

    // オーバーライド
    @Override
    public String toString() {
        if (this.suit == Suit.JOKER) {
            return getSuitStr();
        } else {
            return getSuitStr() + this.number;
        }
    }

}