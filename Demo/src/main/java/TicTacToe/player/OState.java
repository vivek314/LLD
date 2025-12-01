package TicTacToe.player;

import TicTacToe.CellState;

public class OPlayerState implements IPlayer {
    public void next(PlayerContext playerContext){
        playerContext.setPlayer(new XPlayerState());
    }

    @Override
    public boolean isWon() {
        return false;
    }
}
