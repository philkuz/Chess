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
	public King king;
	public Board(){
		init();
	}
	/*TODO make the board initialization process; made a test with pawns.*/
	public void init(){
		board = new Piece[8][8];
		/*loop for board set up. top loop handles the two sides*/
//		for(int i = 0; i < 2; i++){
//			int y = i*7;
//			/*TODO make movements for queen, king, bishop, rook, and knight*/
//			addPiece(new Queen(3,y, i, this));
//			addPiece(new King(4,y, i,this));
//			//loop to handle central symmetry
//			for(int j=0; j< 2; j++)
//			{
//				addPiece(new Knight(1+5*j,y,i, this));
//				addPiece(new Bishop(2+3*j,y,i, this));
//				addPiece(new Rook(j*7, y,i, this));
//			}
//			//pawn init
//			for(int k = 0; k<8; k++)
//			{
//				addPiece(new Pawn(k,1+5*i,i, this));
//			}
//		}
		king = new King(4,3,WHITE, this);
		Piece[] pieces = {king,new Bishop(2,2,WHITE, this), new Pawn(5,4,BLACK, this)};
		for (Piece piece : pieces){
			addPiece(piece);
			piece.moves();
		}
		System.out.println(king.inCheck());
//		ArrayList<Integer[]> moves = pieces[0].moves();
		
		
	}
//	checks if the move that is input is a move on the map
	
	public void displayBoard(){
		System.out.print(" ");
		for(int j = 0; j < 8; j++){
			System.out.print("  "+j);
		}
		for(int i = 0; i < 8; i++){	
			System.out.print("\n"+i+" ");
			for(int j = 0; j < 8; j++){
				Piece p = board[j][i];
				if(p == null)
				{
					System.out.print(" … ");
				}
				else{
					System.out.print(" "+ p.asci[p.color]+" ");
				}
			}			
		}
	}
	public void addPiece(Piece p){
		int[] loc = p.getLocation();
		board[loc[0]][loc[1]] = p;
	} 
	public static void main(String args[]){
		
		Board b = new Board();
		b.displayBoard();
		
	}
}
