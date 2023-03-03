const btnMode = document.getElementById("btn-mode");
const btnWar = document.getElementById("btn-war");
const btnBlackjack = document.getElementById("btn-blackjack");

let playMode = true;

btnMode.addEventListener("click", function () {
  if (playMode) {
    btnMode.innerHTML = "Help";
  } else {
    btnMode.innerHTML = "Play";
  }
  // 変数の値を切り替える
  playMode = !playMode;
});

btnWar.addEventListener("click", function () {
  document.getElementById("select").style.display = "none";
  document.getElementById("help-text").style.display = "block";
  if (playMode) {
    btnWar.innerHTML = "戦争を開始";
  } else {
    helpGame("war");
  }
});

btnBlackjack.addEventListener("click", function () {
  document.getElementById("select").style.display = "none";
  document.getElementById("help-text").style.display = "block";
  if (playMode) {
    btnBlackjack.innerHTML = "ブラックジャックを開始";
  } else {
    helpGame("blackjack");
  }
});

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
