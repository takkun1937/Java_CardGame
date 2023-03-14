class CardGame {
  constructor(hasJoker) {
    let num = hasJoker ? 53 : 52;
    this.deck = new Array(num);
    this.shuffle();
  }

  //シャッフルメソッド
  shuffle() {
    for (let i = 0; i < this.deck.length; i++) {
      this.deck[i] = new Card(i);
    }

    for (let i = this.deck.length - 1; i > 0; i--) {
      const j = Math.floor(Math.random() * (i + 1));
      [this.deck[i], this.deck[j]] = [this.deck[j], this.deck[i]];
    }
  }
}
