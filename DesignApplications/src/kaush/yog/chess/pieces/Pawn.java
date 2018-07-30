package kaush.yog.chess.pieces;

import java.util.Set;

import kaush.yog.chess.Slot;

public class Pawn implements IPiece {

	Color color;
	
	public Pawn(Color col) {
		color = col;
	}
	
	@Override
	public boolean isValidMove(Slot slot) {
		return false;
	}

	@Override
	public Set<Pair> validMoves() {
		return null;
	}

	@Override
	public Color getColor() {
		return null;
	}

}
