package com.example.gamestrore.service;

import com.example.gamestrore.entity.Game;
import com.example.gamestrore.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public Game createGame(String name, int price) {
        Game game = new Game();
        game.setName(name);
        game.setPrice(price);
        return gameRepository.save(game);
    }

    public Game findByName(String name) {
        Optional<Game> optional = gameRepository.findGameByName(name);
        return optional.orElseGet(() -> new Game(BigInteger.ZERO, "null", 0));
    }

    public void gameDelete(String name) {
        Game game = gameRepository.findGameByName(name).orElseThrow();
        gameRepository.delete(game);
    }

    public void gamePriceEdit(String name, int price) {
        Game game = gameRepository.findGameByName(name).orElseThrow();
        game.setPrice(price);
        gameRepository.save(game);
    }
}