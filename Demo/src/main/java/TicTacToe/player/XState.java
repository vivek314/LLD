package TicTacToe.player;

import TicTacToe.CellState;

public class XPlayerState implements IPlayer {
    public void next(PlayerContext playerContext){
        playerContext.setPlayer(new OPlayerState());
    }

    @Override
    public boolean isWon() {
        return false;
    }
}
