package TicTacToe;

import java.util.List;

import TicTacToe.player.IPlayer;
import TicTacToe.player.OWonState;
import TicTacToe.player.PlayerContext;
import TicTacToe.player.XWonState;

public class Board {
    private final int rows;
    private final int columns;
    private CellState[][] board;
    private List<GameEventListener> eventListeners;
    //Add or remove event listeners
    public void addGameEventListener(GameEventListener eventListener){
        eventListeners.add(eventListener);
    }
    public void removeGameEventListener(GameEventListener eventListener){
        eventListeners.remove(eventListener);
    }

    public Board(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.board = new CellState[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                board[i][j] = CellState.EMPTY;
            }
        }
    }
    public void printBoard(){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void setCellState(int row, int column, CellState cellState){
        board[row][column] = cellState;
    }
    public CellState getCellState(int row, int column){
        return board[row][column];
    }

    public boolean isValidMove(Move move){
        return move.row >= 0 && move.row < rows && move.column >= 0 && move.column < columns && board[move.row][move.column] == CellState.EMPTY;
    }
    public void makeMove(Move move, CellState cellState){
        board[move.row][move.column] = cellState;
    }
    public void undoMove(Move move){
        board[move.row][move.column] = CellState.EMPTY;
    }
    public void checkGameState(PlayerContext context){
        for(int i = 0; i < rows; i++){
            if(board[i][0] != CellState.EMPTY && isWinningLine(board[i])){
                IPlayer newState = board[i][0] == CellState.X ? new XWonState() : new OWonState();
                context.setPlayer(newState);
                notifyGameStateChanged(context);
                return;
            }
    }
    for(int j = 0; j < columns; j++){
        CellState[] column = new CellState[rows];
        for(int i = 0; i < rows; i++){
            column[i] = board[i][j];
        }
        if(isWinningLine(column)){
            IPlayer newState = column[0] == CellState.X ? new XWonState() : new OWonState();
            context.setPlayer(newState);
            notifyGameStateChanged(context);
            return;
        }
    }
    //Diagonal checks
    CellState[] diagonal1 = new CellState[rows];
    CellState[] diagonal2 = new CellState[rows];
    for(int i = 0; i < rows; i++){
        diagonal1[i] = board[i][i];
        diagonal2[i] = board[i][rows - i - 1];
    }
    if(isWinningLine(diagonal1)){
        IPlayer newState = diagonal1[0] == CellState.X ? new XWonState() : new OWonState();
        context.setPlayer(newState);
        notifyGameStateChanged(context);
        return;
    }
    if(isWinningLine(diagonal2)){
        IPlayer newState = diagonal2[0] == CellState.X ? new XWonState() : new OWonState();
        context.setPlayer(newState);
        notifyGameStateChanged(context);
        return;
    }
}
    private boolean isWinningLine(CellState[] cellStates) {
        CellState first = cellStates[0];
        for(int i = 1; i < cellStates.length; i++){
            if(cellStates[i] != first){
                return false;
            }
        }
        return true;
    }
    private void notifyGameStateChanged(PlayerContext context){
        for(GameEventListener eventListener : eventListeners){
            eventListener.onGameStateChanged(context);
        }
    }
    private void notifyMoveMade(Move move, CellState cellState){
        for(GameEventListener eventListener : eventListeners){
            eventListener.onMoveMade(move, cellState);
        }
    }
}