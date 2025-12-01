package TicTacToe;

import TicTacToe.player.HumanPlayerStrategy;
import TicTacToe.player.Player;
import TicTacToe.player.PlayerContext;

public class TicTacToeGame {
    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currPlayer;
    private PlayerContext context;

    public TicTacToeGame(){
        playerX = new Player(CellState.X, new HumanPlayerStrategy());
        playerO = new Player(CellState.O, new HumanPlayerStrategy());
        currPlayer = playerX;
        context = new PlayerContext();
    }

    public void play(){
        do {
            board = new Board(3, 3);
            Move move = currPlayer.getPlayerStrategy().makeMove(board);
            board.makeMove(move, currPlayer.getSymbol());
            board.checkGameState(context);
            switchPlayer();
        } while(!context.isGameOver());
        
        
    }

    private void switchPlayer() {
        if(currPlayer == playerX) currPlayer = playerO;
        else currPlayer = playerX;
    }
}
