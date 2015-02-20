package pieces;
import java.util.ArrayList;

import chess.*;

public class Pawn extends Piece{
	
	//should only be 1 or -1, if it is 0, it means it hasn't been initialized. 
	public int direction = 0;
	public Pawn(int x, int y, int type) {
		super(x, y, type);
		if (type == Board.WHITE)
			direction = 1;
		else
			direction = -1;
	}

	public String getType() {
		return "pawn";
	}
	public ArrayList<Integer[]> captures(){
		ArrayList<Integer[]> captures = new ArrayList<Integer[]>();
		int[] loc = getLocation();
		for(int i = 0; i < 2; i++){
			Integer[] coord = {loc[0]+(int)Math.pow(-1,i), loc[1]+direction};
			captures.add(coord);
		}
		ArrayList<Integer[]> tempCap = new ArrayList<Integer[]>();
		tempCap.addAll(captures);
		//checks to make sure the move is on the board
		for(Integer[] coord : captures){
			for(int i = 0; i < 2; i++){
				if(coord[i] < 0 || coord[i]>=8){
					tempCap.remove(coord);
				}
			}
			
		}
		//quick change of origins
		captures = tempCap;
		tempCap = new ArrayList<Integer[]>();
		//check to see if there is a piece on the move
		for(Integer[] coord: captures){
			if(board[coord[0]][coord[1]]!= null){
				tempCap.add(coord);
			}
		}
		captures = tempCap;
		return captures;
	}
	public ArrayList<Integer[]> moves(){
		int[] loc = getLocation();
		ArrayList<Integer[]> moves = captures();
		Integer[] move = {loc[0], loc[1]+direction};
		if(board[move[0]][move[1]] == null){
			moves.add(move);
			if(direction > 0 && loc[1] == 1 || direction <0 && loc[1] == 7){
				if(board[move[0]][move[1]+direction] == null)
				{
					move[1]+=direction;
					moves.add(move);
				}
			}
		}		
		return moves;
	}

}
