package pieces;
import java.util.ArrayList;

import chess.*;

public class Pawn extends Piece{
	
	//should only be 1 or -1, if it is 0, it means it hasn't been initialized. 
	public int direction = 0;
	public Pawn(int x, int y, int color) {
		super(x, y, color);
		if (color == Board.WHITE)
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
		//quick refresh of captures and tempCap
		captures = tempCap;
		tempCap = new ArrayList<Integer[]>();
		//check to see if there is a piece on the move
		for(Integer[] coord: captures){
			Piece target = board[coord[0]][coord[1]];
			if(target != null){
				System.out.println("target is not null");
				if(target.color != this.color)
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
			System.out.println("D:"+direction+" C:"+coord[1]);
			if(direction > 0 && coord[1] == 1 || direction < 0 && coord[1] == 7){
				if(board[coord[0]][coord[1]+direction] == null)
				{
					Integer[] temp2 ={move[0],move[1]+direction};
					moves.add(temp2);
				}
			}
		}		
		return moves;
	}

}
