package com.example.gamestrore.controller;

import com.example.gamestrore.entity.Game;
import com.example.gamestrore.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/games/{name}")
    public Game getGameByName(@PathVariable String name) {
        return gameService.findByName(name);
    }

    @GetMapping("/games/{name}/{price}")
    public void createGame(@PathVariable String name, @PathVariable int price) {
    gameService.createGame(name, price);
    }

    @PostMapping("/games/delete/{name}")
    public String deleteGame(@PathVariable String name) {
        gameService.gameDelete(name);
        return "game " + name + "was deleted";
    }

    @PostMapping("/games/edit/{name}/{price}")
    public String changePrice(@PathVariable String name, @RequestParam int price) {
        gameService.gamePriceEdit(name, price);
        return "price was changed";
    }
}