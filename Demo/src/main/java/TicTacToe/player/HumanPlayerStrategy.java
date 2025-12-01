package TicTacToe.player;

import java.util.Scanner;

import TicTacToe.Board;
import TicTacToe.Move;

public class HumanPlayerStrategy implements PlayerStrategy {
    private Scanner scanner;
    private String name;

    public HumanPlayerStrategy(){
    }
    @Override
    public Move makeMove(Board board) {
        while(true){
            System.out.println(name + ", enter your move (row column):");
            int row = scanner.nextInt();
            int column = scanner.nextInt();
            Move move = new Move(row, column);
            if(board.isValidMove(move)) return move;
            System.out.println("Invalid move, please try again!");
        }
    }
}
