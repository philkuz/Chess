package pieces;

import java.util.ArrayList;

import chess.Board;
import chess.Piece;

public class Bishop extends Piece {

	public Bishop(int x, int y, int color, Board world) {
		super(x, y, color, world);
		asci[Board.WHITE]= "♗";
		asci[Board.BLACK]= "♝";
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "bishop";
	}

	@Override
	public ArrayList<Integer[]> moves() {
		ArrayList<Integer[]> moves = new ArrayList<Integer[]>();
		int[] vect = {1,1};
		for(int i = 0; i < 4; i++){
			System.out.println(vect[0]+ " "+ vect[1]);
			Integer[] cur = {coord[0]+vect[0], coord[1]+vect[1]};
			while(legalMove(cur)){
				moves.add(cur);
				cur[0]+=vect[0];
				cur[1]+=vect[1];
			}
			vect[0] *= Math.pow(-1, i);
			vect[1] *= Math.pow(-1, i+1);			
		}
		return moves;
	}

}
