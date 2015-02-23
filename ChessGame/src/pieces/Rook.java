package pieces;

import java.util.ArrayList;

import chess.Board;
import chess.Piece;

public class Rook extends Piece {

	public Rook(int x, int y, int color) {
		super(x, y, color);
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
		// TODO Auto-generated method stub
		return null;
	}

}
