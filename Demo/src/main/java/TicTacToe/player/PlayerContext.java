package TicTacToe.player;

public class PlayerContext {
    private IPlayer player;
    public PlayerContext(){
        this.player = new XPlayerState();
    }
    public void nextPlayer(){
        player.next(this);
    }

    public IPlayer getPlayer(){
        return player;
    }
    public void setPlayer(IPlayer player){
        this.player = player;
    }

    public boolean isGameOver(){
        return player.isWon();
    }
}
