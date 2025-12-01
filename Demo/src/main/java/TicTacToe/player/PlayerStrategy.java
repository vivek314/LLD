package TicTacToe.player;

import TicTacToe.Board;
import TicTacToe.Move;

public interface PlayerStrategy {
    Move makeMove(Board board);
}
