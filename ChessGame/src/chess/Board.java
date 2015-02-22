package chess;
import java.util.ArrayList;

import pieces.*;
public class Board 
{
	//CONSTANTS
	public final static int WHITE = 0;
	public final static int BLACK = 1;
	public final static int BOARDLEN = 8;
	
	//CLASS VARIABLES
	/*The board is currently an array, but if you want AI, break it*/
	public Piece[][] board;
	
	public Board(){
		init();
	}
	/*TODO make the board initialization process; made a test with pawns.*/
	public void init(){
		board = new Piece[8][8];
//		loop for board set up. top loop handles the two sides
//		for(int i = 0; i < 2; i++)
//		{
//			int y = i*7;
//			/*TODO make movements for queen, king, bishop, rook, and knight*/
//			addPiece(new Queen(3,y, i));
//			addPiece(new King(4,y, i));
//			//loop to handle central symmetry
//			for(int j=0; j< 2; j++)
//			{
//				addPiece(new Knight(1+4*j,y,i));
//				addPiece(new Bishop(2+3*j,y,i));
//				addPiece(new Rook(j*7, y,i));
//			}
//			//pawn init
//			for(int k = 0; k<8; k++)
//			{
//				addPiece(new Pawn(k,1,i));
//			}
//		}
		Piece[] pieces = {new Knight(4,3,WHITE),new Pawn(2,2,WHITE), new Pawn(3,1,BLACK)};
		for (Piece piece : pieces){
			addPiece(piece);
			
		}
		for (Piece piece : pieces){
			piece.updateBoard(board);
		}
		
		ArrayList<Integer[]> moves = pieces[0].moves();
		
		
	}
//	checks if the move that is input is a move on the map
	public static boolean legalMove(Integer[] space)
	{
		for(int coord : space)
		{
			if(coord < 0 || coord >= BOARDLEN){
				return false;
			}
		}
		return true;
	}
	
	public void addPiece(Piece p){
		int[] loc = p.getLocation();
		board[loc[0]][loc[1]] = p;
		p.updateBoard(board);
	}
	public static void main(String args[]){
		
		Board b = new Board();
		
	}
}
