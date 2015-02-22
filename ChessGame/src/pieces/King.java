package pieces;

import java.util.ArrayList;

import chess.Piece;

public class King extends Piece {

	public King(int x, int y, int color) {
		super(x, y, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "king";
	}

	@Override
	public ArrayList<Integer[]> moves() {
		// TODO Auto-generated method stub
		return null;
	}

}
