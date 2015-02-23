package pieces;

import java.util.ArrayList;

import chess.Board;
import chess.Piece;

public class Bishop extends Piece {

	public Bishop(int x, int y, int color) {
		super(x, y, color);
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
		// TODO Auto-generated method stub
		return null;
	}

}
