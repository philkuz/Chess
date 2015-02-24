package pieces;

import java.util.ArrayList;

import chess.Board;
import chess.Piece;

public class Queen extends Piece {

	public Queen(int x, int y, int color, Board world) {
		super(x, y, color, world);
		asci[Board.WHITE]="♕";
		asci[Board.BLACK]="♛";
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "queen";
	}

	@Override
	public ArrayList<Integer[]> moves() {
		// TODO Auto-generated method stub
		return null;
	}

}
