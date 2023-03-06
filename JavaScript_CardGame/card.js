class Card {
  constructor(cardNum) {
    if (cardNum >= 0 && cardNum < 13) {
      this.suit = "❤︎";
      this.number = cardNum + 1;
    } else if (cardNum >= 13 && cardNum < 26) {
      this.suit = "♠️";
      this.number = cardNum - 12;
    } else if (cardNum >= 26 && cardNum < 39) {
      this.suit = "♦︎";
      this.number = cardNum - 25;
    } else if (cardNum >= 39 && cardNum < 52) {
      this.suit = "♣️";
      this.number = cardNum - 38;
    } else if (cardNum == 52) {
      this.suit = "JOKER";
      this.number = cardNum;
    }
  }

  toString() {
    if (this.suit === "JOKER") {
      return this.suit;
    } else {
      return this.suit + this.number;
    }
  }
}
