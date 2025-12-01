package TicTacToe;

import TicTacToe.player.PlayerContext;

public interface GameEventListener {
    void onGameStateChanged(PlayerContext gameState);
    void onMoveMade(Move move, CellState cellState);
}
