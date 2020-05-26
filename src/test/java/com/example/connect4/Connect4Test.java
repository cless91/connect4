package com.example.connect4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Connect4Test {

    private Connect4 game;
    private Player firstPlayer;
    private Player secondPlayer;

    @BeforeEach
    void setUp() {
        game = Connect4.createStandardGame();
        firstPlayer = game.getFirstPlayer();
        secondPlayer = firstPlayer.equals(Player.RED) ? Player.YELLOW : Player.RED;
    }

    @Test
    void shouldCreateNewGame() {
        Connect4 game = Connect4.createStandardGame();
        assertThat(game.getHeight()).isEqualTo(6);
        assertThat(game.getWidth()).isEqualTo(7);
    }

    @Test
    void playOnEmptyGame() {
        // WHEN the first player plays
        game.play(firstPlayer, 2);

        // THEN the state of the game is consistent
        assertThat(game.getTokens()).hasSize(1);
        Token token = game.getTokens().get(0);
        assertThat(token.x).isEqualTo(0);
        assertThat(token.y).isEqualTo(2);

        // WHEN the first player plays
        game.play(secondPlayer, 2);

        // THEN the state of the game is consistent
        assertThat(game.getTokens()).hasSize(2);
        Token secondToken = game.getTokens().get(1);
        assertThat(secondToken.x).isEqualTo(1);
        assertThat(secondToken.y).isEqualTo(2);
    }

    @Test
    void cannotPlayOnFullColumn() {

    }
}