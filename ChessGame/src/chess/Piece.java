package chess;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Piece 
{
//	0 is x, 1 is y
	public int coord[]=new int[2];
//	Intended for move finding
	public Piece[][] board;
//	Black or white
	public int color;
	public String asci[] = {"?","?"};
	public Piece(int x, int y, int color){
		coord[0] = x; coord[1] = y; this.color = color;
	}
	
	public void updateBoard(Piece[][] newboard){
		board = newboard;
	}
	//returns the type of piece this piece is
	public abstract String getType();
	public int[] getLocation() {
		return coord;
	}
	//this should only be used if the move is guaranteed legal.
	public void makeMove(int[] dest){
		coord[0] = dest[0];
		coord[1] = dest[1];
	}
	public int getColor(){
		return color;
	}
	public abstract ArrayList<Integer[]> moves();
	public ArrayList<Integer[]> captures(){
		ArrayList<Integer[]> captureMoves = new ArrayList<Integer[]>();
		for(Integer[] move : moves()){
			if (getPiece(move) != null)
				captureMoves.add(move);	
		}
		return captureMoves;
	}
	
	public static void displayVars(int[] vars){
		for(int e : vars){
			System.out.print(Arrays.asList(vars).indexOf(e)+". "+e+",");
		}
		System.out.println("\n");
	}
	//returns true or false whether a move is acceptable
	/*TODO Make some kind of move check that prevents King from getting into check*/
	public boolean legalMove(Integer[] space){
		for(int coord : space)
		{
			if(coord < 0 || coord >= Board.BOARDLEN)
				return false;
		}
		if(occupied(space, color))
			return false;
		return true;
	}
	/*Gets the piece on the board*/
	public Piece getPiece(Integer[] space){
		return board[space[0]][space[1]];
	}
	//checks to see if a space is currently occupied by a friendly piece
	public boolean occupied(Integer[] space, int color){
		Piece p = board[space[0]][space[1]];
		if(p == null)
			return false;
		if(p.getColor() == color)
			return true;
		else
			return false;
	}
}
