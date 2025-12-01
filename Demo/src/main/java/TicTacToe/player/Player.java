package TicTacToe.player;

import TicTacToe.CellState;

public class Player {
    private CellState cellState;
    private String name;
    private PlayerStrategy strategy;
    public Player(CellState cellState, PlayerStrategy strategy){
        this.cellState = cellState;
        this.strategy = strategy;
    }
    public void setName(String name){
        this.name = name;
    }
    public PlayerStrategy getPlayerStrategy(){
        return strategy;
    }
    public CellState getSymbol() {
        return cellState;
    }
}
