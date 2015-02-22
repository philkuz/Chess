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
	public abstract ArrayList<Integer[]> moves();
	/*TODO Make some kind of move check that prevents King from getting into check*/
	public static void displayVars(int[] vars){
		for(int e : vars){
			System.out.print(Arrays.asList(vars).indexOf(e)+". "+e+",");
		}
		System.out.println("\n");
	}
}
