package com.example.gamestrore.repository;

import com.example.gamestrore.entity.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface GameRepository extends MongoRepository<Game, BigInteger> {
    Optional<Game> findGameByName(String name);
}