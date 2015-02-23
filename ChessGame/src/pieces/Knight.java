package pieces;

import java.util.ArrayList;
import chess.*;

public class Knight extends Piece {

	public Knight(int x, int y, int color) {
		super(x, y, color);
		asci[0]="♘";
		asci[1]="♞";
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
				if(legalMove(output)){
					moves.add(output);
				}
			}
			
			
		}		
		return moves;
	} 
	public ArrayList<Integer[]> captures(){
		ArrayList<Integer[]> captureMoves = new ArrayList<Integer[]>();
		for(Integer[] move : moves()){
			if (getPiece(move) != null)
				captureMoves.add(move);
				
		}
		return captureMoves;
	}
}
