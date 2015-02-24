package pieces;

import java.util.ArrayList;

import chess.*;

public class King extends Piece {

	public King(int x, int y, int color, Board world) {
		super(x, y, color, world);
		asci[Board.WHITE]= "♔";
		asci[Board.BLACK]= "♚";
		
		// TODO Auto-generated constructor stub
	}
	
	public String getType() {
		return "king";
	}
	
	public ArrayList<Integer[]> moves() {
		ArrayList<Integer[]> moves = new ArrayList<Integer[]>();
//		The vector of the first move
		int[] delV = {0,1};
		Integer[] prev = {-1,-1};
//		generate the possible moves, then decide whether they are legal.
		for(int i = 0; i < 8; i++){
			Integer[] move = {coord[0]+prev[0],coord[1]+prev[1]};
			int[] del = {(int)Math.pow(-1, i/4)*delV[i/2%2],(int)Math.pow(-1, i/4)*delV[(i/2+1)%2]};
			prev[0]+=del[0];
			prev[1]+=del[1];
			if(legalMove(move))
				moves.add(move);
		}
		return moves;
	}
	public boolean inCheck(){
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				Piece p = board[i][j];
				if( p != null){
					System.out.println(p.asci[0]);
					for(Integer[] capture : p.captures()){
						//Is the capture valid
						
						boolean cap = true;
						for(int k = 0; k < capture.length;  k++){
							if(capture[k] != coord[k]){
								cap = false;
								break;
							}
						}
						if(cap){
							return true;
						}
					}
				}
			}
		}
		return false;
	}

}
