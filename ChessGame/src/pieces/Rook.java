package pieces;

import java.util.ArrayList;

import chess.Board;
import chess.Piece;

public class Rook extends Piece {

	public Rook(int x, int y, int color, Board world) {
		super(x, y, color, world);
		asci[Board.WHITE]="♖";
		asci[Board.BLACK]="♜";
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "rook";
	}

	@Override
	public ArrayList<Integer[]> moves() {
		ArrayList<Integer[]> moves = new ArrayList<Integer[]>();
		int[] vect = {1,0};
		for(int i = 0; i < 4; i++){
			vect[0] = (int) (Math.pow(-1, i/2)*vect[1]);
			vect[1] = (int) (Math.pow(-1, i/2)*vect[0]);
		}
		return null;
	}

}
