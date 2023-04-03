class War extends CardGame {
  constructor() {
    super(false);
    this.enemyScoreArea = document.getElementById("war-enemyScore");
    this.enemyCard = document.getElementById("war-enemyCard");
    this.warText = document.getElementById("war-text");
    this.playerCard = document.getElementById("war-playerCard");
    this.playerScoreArea = document.getElementById("war-playerScore");
    this.btnAdd = document.getElementById("btn-add");
    this.btnAdd.addEventListener("click", (event) => this.handlerBtnAdd(event));
    this.playerDeck = new Array();
    this.enemyDeck = new Array();
    this.playerScore = 0;
    this.enemyScore = 0;
    this.point = 2;
    this.addClickTimes = 0;
    this.play();
  }

  //playメソッド
  play() {
    //カードの分配
    const middle = Math.ceil(this.deck.length / 2);
    this.playerDeck = this.deck.slice(0, middle);
    this.enemyDeck = this.deck.slice(middle);
  }

  //ボタンクリックされた時の処理
  handlerBtnAdd(event) {
    //カード表示
    this.playerCard.innerHTML = this.playerDeck[this.addClickTimes];
    this.enemyCard.innerHTML = this.enemyDeck[this.addClickTimes];

    //ターンごとの勝敗判定
    if (
      this.playerDeck[this.addClickTimes].number >
      this.enemyDeck[this.addClickTimes].number
    ) {
      this.warText.innerHTML = "あなたの勝ち";
      this.playerScore += this.point;
      this.point = 2;
    } else if (
      this.playerDeck[this.addClickTimes].number <
      this.enemyDeck[this.addClickTimes].number
    ) {
      this.warText.innerHTML = "相手の勝ち";
      this.enemyScore += this.point;
      this.point = 2;
    } else {
      this.warText.innerHTML = "引き分け";
      this.point += 2;
    }

    //スコア表示
    this.playerScoreArea.innerHTML = "あなた : " + this.playerScore;
    this.enemyScoreArea.innerHTML = "相手 : " + this.enemyScore;
    this.addClickTimes += 1;

    //ゲームの勝者判定
    if (this.addClickTimes >= this.playerDeck.length) {
      //ボタン非表示
      this.btnAdd.style.display = "none";

      if (this.playerScore > this.enemyScore) {
        this.warText.innerHTML = "あなたはゲームに勝利しました。";
      } else if (this.playerScore < this.enemyScore) {
        this.warText.innerHTML = "あなたはゲームに負けました。";
      } else {
        this.warText.innerHTML = "このゲームは引き分けです。";
      }
    }
  }
}
