package pieces;

import java.util.ArrayList;
import chess.*;

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
		ArrayList<Integer[]> moves = new ArrayList<Integer[]>();
		int[] vect = {2,1};
		//currently outputs all moves that are legal
		for(int i = 0; i< 4; i++){
			int[] curVect = {(int)Math.pow(-1, i/2)*vect[i%2], vect[(i+1)%2]};
			int x = coord[0];
			int y = coord[1];
			ArrayList<Integer[]> tempMoves = new ArrayList<Integer[]>();
			Integer[] outputV = {x+curVect[0],y+curVect[1]};
			tempMoves.add(outputV);
			Integer[] outputV2 = {x+curVect[0],y-curVect[1]};
			tempMoves.add(outputV2);
//			displayVars(new int[]{(int)Math.pow(-1, i)*vect[i%2],(int)Math.pow(-1, i)*vect[(i+1)%2]});
			for(Integer[] output: tempMoves){
				if(Board.legalMove(output)&&!occupied(output, color)){
					moves.add(output);
					System.out.println("Move "+(2*i)+". ("+output[0]+", "+output[1]+");");
				}
				
			}
			
			
		}
//		Legal moves are defined both by existing on the board, not putting own king into check,
//		and not occupied by a piece of it's own color.
		
		
		return null;
	}
	//this method allows you to check whether the 
	

}
