package com.example.CardGameServer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {

    @GetMapping("/war") // 「http://localhost:8080/test」で呼び出されるメソッドであることの指定
    public String war() {
        return "war"; // `/src/main/resources/templates/test.html`がブラウザに表示される。
    }

    @GetMapping("/blackjack") // 「http://localhost:8080/test」で呼び出されるメソッドであることの指定
    public String blackjack() {
        return "blackjack"; // `/src/main/resources/templates/test.html`がブラウザに表示される。
    }

    // TODO: 追加のルート

}
