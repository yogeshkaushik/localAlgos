package kaush.yog.chess;

import kaush.yog.chess.pieces.IPiece;
import kaush.yog.chess.pieces.IPiece.Color;

public class Slot {
	
	IPiece piece;
	Color slotColor;
	
	public Slot(IPiece p, Color c) {
		piece = p;
		slotColor = c;
	}
	
	@Override
	public String toString() {
		return slotColor.toString().toUpperCase() + " : { "+piece.toString()+" }";
	}
}
