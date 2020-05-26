package com.example.connect4;

import com.speedment.common.mapstream.MapStream;

import java.util.*;
import java.util.stream.Collectors;

public class Connect4 {

    private int height;
    private int width;
    private Player firstPlayer;
    private Map<Integer, List<Token>> tokens = new HashMap<>();

    private Connect4(int width, int height) {
        this.height = height;
        this.width = width;
    }

    public static Connect4 createStandardGame() {
        Connect4 game = new Connect4(7, 6);
        game.firstPlayer = new Random().nextDouble() < 0.5 ? Player.RED : Player.YELLOW;
        return game;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Player getFirstPlayer() {
        return firstPlayer;
    }

    public void play(Player firstPlayer, int columnIdx) {
        tokens.putIfAbsent(columnIdx, new ArrayList<>());
        List<Token> column = this.tokens.get(columnIdx);
        column.add(new Token(column.size(), columnIdx));
    }

    public List<Token> getTokens() {
        return MapStream.of(tokens)
                .flatMapValue(Collection::stream)
                .values()
                .collect(Collectors.toList());
    }
}
