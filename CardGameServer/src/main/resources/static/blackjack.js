class Blackjack extends CardGame {
  constructor() {
    super(true);
    this.dealerScoreArea = document.getElementById("blackjack-dealerScore");
    this.dealerCard = document.getElementById("blackjack-dealerCard");
    this.blackjackText = document.getElementById("blackjack-text");
    this.playerCard = document.getElementById("blackjack-playerCard");
    this.playerScoreArea = document.getElementById("blackjack-playerScore");
    this.btnHit = document.getElementById("btn-hit");
    this.btnStay = document.getElementById("btn-stay");
    this.btnHit.addEventListener("click", (event) => this.handlerBtnHit(event));
    this.btnStay.addEventListener("click", (event) =>
      this.handlerBtnStay(event)
    );
    this.playerDeck = new Array();
    this.dealerDeck = new Array();
    this.playerScore = 0;
    this.dealerScore = 0;
    this.aceTimes = 0; //1が出た回数
    this.hitClickTimes = 1;
    this.play();
  }

  //playメソッド
  play() {
    this.addCard("both");
    this.addCard("both");

    this.addScore(this.playerDeck[0].number, "player");
    this.addScore(this.playerDeck[1].number, "player");

    //最初に1が2回出た時
    if (this.aceTimes == 2) {
      this.playerScore -= 10;
      this.aceTimes -= 1;
    }

    //カードとスコア表示
    this.dealerCard.append(this.dealerDeck[0]);
    this.playerCard.append(this.playerDeck[0]);
    this.playerCard.append(this.playerDeck[1]);
    this.playerScoreArea.innerHTML = "Player : " + this.playerScore;
  }

  addCard(distributed) {
    // playerのみカード追加
    if (distributed === "player") {
      this.playerDeck.push(this.deck.shift());
    }
    // ディーラーのみ追加
    else if (distributed === "dealer") {
      this.dealerDeck.push(this.deck.shift());
    }
    // 両方のカード追加
    else if (distributed === "both") {
      this.playerDeck.push(this.deck.shift());
      this.dealerDeck.push(this.deck.shift());
    }
  }

  //得点計算方法
  addScore(num, player) {
    //カードの数字が1の時
    if (num == 1) {
      this.aceTimes += 1;
      if (player === "player") {
        this.playerScore += 11;
      } else if (player === "dealer") {
        this.dealerScore += 11;
      }
    }
    //カードの数字が2~9の時
    else if (num >= 2 && num <= 9) {
      if (player === "player") {
        this.playerScore += num;
      } else if (player === "dealer") {
        this.dealerScore += num;
      }
    }
    //カードの数字が10~13の時
    else if (num >= 10 && num <= 13) {
      if (player === "player") {
        this.playerScore += 10;
      } else if (player === "dealer") {
        this.dealerScore += 10;
      }
    }
  }

  //ヒットボタンが押された時
  handlerBtnHit(event) {
    this.hitClickTimes += 1;
    this.addCard("player");
    this.addScore(this.playerDeck[this.hitClickTimes].number, "player");
    this.checkAce("player");

    //バーストした時
    if (this.playerScore > 21) {
      document.getElementById("blackjack-btn").style.display = "none";
      this.blackjackText.innerHTML = "あなたの負けです。";
    }

    //カードとスコア表示
    this.playerCard.append(this.playerDeck[this.hitClickTimes]);
    this.playerScoreArea.innerHTML = "Player : " + this.playerScore;
  }

  //ステイボタンがクリックされた時
  handlerBtnStay(event) {
    //ボタン非表示
    document.getElementById("blackjack-btn").style.display = "none";

    //一度aceTimesをリセット
    this.aceTimes = 0;

    this.addScore(this.dealerDeck[0].number, "dealer");
    this.addScore(this.dealerDeck[1].number, "dealer");
    this.dealerCard.append(this.dealerDeck[1]);

    //最初に1が2回出た場合
    if (this.aceTimes == 2) {
      this.dealerScore -= 10;
      this.aceTimes -= 1;
    }

    //ディーラーのスコアを17以上にする
    if (this.dealerScore < 17) {
      for (let i = 2; i < this.deck.length; i++) {
        this.addCard("dealer");
        this.addScore(this.dealerDeck[i].number, "dealer");
        this.dealerCard.append(this.dealerDeck[i]);
        this.checkAce("dealer");
        if (this.dealerScore >= 17) {
          break;
        }
      }
    }

    //勝敗判定
    if (this.dealerScore > 21) {
      this.blackjackText.innerHTML = "あなたの勝ちです。";
    } else if (this.playerScore > this.dealerScore) {
      this.blackjackText.innerHTML = "あなたの勝ちです。";
    } else if (this.playerScore < this.dealerScore) {
      this.blackjackText.innerHTML = "あなたの負けです。";
    } else {
      this.blackjackText.innerHTML = "引き分けです。";
    }

    //スコア表示
    this.dealerScoreArea.innerHTML = "Dealer : " + this.dealerScore;
  }

  //デッキに1がある時の再計上処理
  checkAce(checkPlayer) {
    switch (checkPlayer) {
      case "player": {
        if (this.playerScore > 21 && this.aceTimes > 0) {
          while (this.playerScore > 21) {
            this.playerScore -= 10;
            this.aceTimes -= 1;
            if (this.aceTimes <= 0) {
              break;
            }
          }
        }
        break;
      }
      case "dealer": {
        if (this.dealerScore > 21 && this.aceTimes > 0) {
          while (this.dealerScore > 21) {
            this.dealerScore -= 10;
            this.aceTimes -= 1;
            if (this.aceTimes <= 0) {
              break;
            }
          }
        }
        break;
      }
      default: {
        break;
      }
    }
  }
}
