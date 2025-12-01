package TicTacToe;

import TicTacToe.player.PlayerContext;

public class ConsoleGameEventListener implements GameEventListener {

    @Override
    public void onGameStateChanged(PlayerContext gameState) {
        System.out.println("Console Game state changed to: " + gameState.getPlayer().toString());
    }

    @Override
    public void onMoveMade(Move move, CellState cellState) {
        System.out.println("Console Game move made: " + move.toString() + " with cell state: " + cellState.toString());
    }
    
}
