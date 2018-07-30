package kaush.yog.chess;

import kaush.yog.chess.pieces.IPiece.Color;
import kaush.yog.chess.pieces.Bishop;
import kaush.yog.chess.pieces.Knight;
import kaush.yog.chess.pieces.Pawn;
import kaush.yog.chess.pieces.Rook;

public class Board {
	Slot[][] slots;
	
	public Board() {
		slots = new Slot[8][8];
		putMainPieces(0,Color.BLACK);
		for (int i=0; i<8; i++) {
			slots[1][i] = new Slot(new Pawn(Color.BLACK), i%2==0?Color.WHITE:Color.BLACK);
		}
		for (int i=2; i<6; i++) {
			for (int j=0;j<8;j++) {
			}
		}
		for (int i=0; i<8; i++) {
			slots[6][i] = new Slot(new Pawn(Color.BLACK), i%2==0?Color.BLACK:Color.WHITE);
		}
		putMainPieces(0,Color.WHITE);
	}

	private void putMainPieces(int i, Color col) {
		slots[i][0] = new Slot(new Rook(col), Color.BLACK);
		slots[i][7] = new Slot(new Rook(col), Color.WHITE);
		
		slots[i][1] = new Slot(new Knight(col), Color.WHITE);
		slots[i][6] = new Slot(new Knight(col), Color.BLACK);
		
		slots[i][2] = new Slot(new Bishop(col), Color.BLACK);
		slots[i][5] = new Slot(new Bishop(col), Color.WHITE);
		
		//slots[i][3] = king,white;
		//slots[i][4] = queen,black;
	}
}
