package pieces;

import java.util.ArrayList;

import chess.Piece;

public class Knight extends Piece {

	public Knight(int x, int y, int color) {
		super(x, y, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "knight";
	}

//	Generates the maximum eight possible moves, then eliminates the one that are not legal.
	public ArrayList<Integer[]> moves() {
		ArrayList<Integer[]> tempMoves = new ArrayList<Integer[]>();
		int[] vect = {2,1};
		for(int i = 0; i< 8; i++){
			
			int x =(int) (coord[0]+Math.pow(-1, i)*vect[i%2]);
			int y =(int) (coord[1]+Math.pow(-1, i)*vect[(i+1)%2]);
			
			Integer[] outputV = {x,y};
			displayVars(new int[]{(int)Math.pow(-1, i)*vect[i%2],(int)Math.pow(-1, i)*vect[(i+1)%2]});
			tempMoves.add(outputV);
			System.out.println("Move "+i+". ("+x+", "+y+");");
		}
//		Legal moves are defined both by existing on the board, not putting own king into check,
//		and not occupied by a piece of it's own color.
		
		
		return null;
	}

}