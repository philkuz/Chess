package chess;
import java.util.ArrayList;

import pieces.*;
public class Board 
{
	//CONSTANTS
	public final static int WHITE = 0;
	public final static int BLACK = 1;
	
	//CLASS VARIABLES
	/*The board is currently an array, but if you want AI, break it*/
	public Piece[][] board;
	
	public Board(){
		init();
	}
	/*TODO make the board initialization process*/
	public void init(){
		board = new Piece[8][8];
		Piece p = new Pawn(1,0,WHITE);
		addPiece(p);
		p.updateBoard(board);
		ArrayList<Integer[]> moves = p.moves();
		
		int[] loc = p.getLocation();
		System.out.println("("+loc[0]+","+loc[1]+")");
		System.out.print("Moves: ");
		for(Integer[] move : moves){
			System.out.println("("+move[0]+","+move[1]+")");
		}
	}
	public void addPiece(Piece p){
		int[] loc = p.getLocation();
		board[loc[0]][loc[1]] = p;
	}
	public static void main(String args[]){
		
		Board b = new Board();
		
	}
}
