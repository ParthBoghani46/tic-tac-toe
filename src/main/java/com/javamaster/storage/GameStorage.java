package com.javamaster.storage;

import com.javamaster.model.Game;

import java.util.HashMap;
import java.util.Map;

public class GameStorage {

    private static Map<String, Game> games;
    private static GameStorage instance;

    private GameStorage() {
        games = new HashMap<>();
    }

    public static synchronized GameStorage getInstance() {
        if (instance == null) {
            instance = new GameStorage();
        }
        return instance;
    }

    public Map<String, Game> getGames() {
        return games;
    }

    public void setGame(Game game) {
        games.put(game.getGameId(), game);
    }

    public Game getGameById(String gameId) {
        for (Game game : games.values()) {
            if (game.getGameId().equals(gameId)) {
                return game;
            }
        }
        return null; // Return null if the game with the given ID is not found
    }

}