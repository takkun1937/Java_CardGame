(function () {
  const btnReload = document.getElementById("reload");
  const btnMode = document.getElementById("btn-mode");
  const btnWar = document.getElementById("btn-war");
  const btnBlackjack = document.getElementById("btn-blackjack");

  //playとhelpモード選択フィールド
  let playMode = true;

  //リロード
  btnReload.addEventListener("click", function () {
    location.reload();
  });

  //モード選択
  btnMode.addEventListener("click", function () {
    if (playMode) {
      btnMode.innerHTML = "<span>Help</span>";
    } else {
      btnMode.innerHTML = "Play";
    }
    playMode = !playMode;
  });

  //戦争ボタンクリック
  btnWar.addEventListener("click", function () {
    document.getElementById("select").style.display = "none";
    //playモード
    if (playMode) {
      document.getElementById("war-container").style.display = "flex";
      const war = new War();
    }
    //ヘルプ表示
    else {
      document.getElementById("help-text").style.display = "flex";
      helpGame("war");
    }
  });

  //ブラックジャックボタンクリック
  btnBlackjack.addEventListener("click", function () {
    document.getElementById("select").style.display = "none";
    //playモード
    if (playMode) {
      document.getElementById("blackjack-container").style.display = "flex";
      const blackjack = new Blackjack();
    }
    //ヘルプ表示
    else {
      document.getElementById("help-text").style.display = "flex";
      helpGame("blackjack");
    }
  });

  //helpテキスト表示
  function helpGame(gameName) {
    switch (gameName) {
      case "war": {
        fetch("war.txt")
          .then((response) => response.text())
          .then((data) => {
            document.getElementById("help-text").innerHTML = data;
          })
          .catch((error) => {
            console.error("Error:", error);
          });
        break;
      }
      case "blackjack": {
        fetch("blackjack.txt")
          .then((response) => response.text())
          .then((data) => {
            document.getElementById("help-text").innerHTML = data;
          })
          .catch((error) => {
            console.error("Error:", error);
          });
        break;
      }
      default: {
        break;
      }
    }
  }
})();
