package kaush.yog.chess.pieces;

import java.util.Set;

import kaush.yog.chess.Slot;

public interface IPiece {
	
	public enum Color {
		BLACK,WHITE;
	}
	
	public boolean isValidMove(Slot slot);
	
	public Set<Pair> validMoves();
	
	public Color getColor();
	
	public static class Pair {
		
		private int i;
		private int j;
		
		public Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + i;
			result = prime * result + j;
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (i != other.i)
				return false;
			if (j != other.j)
				return false;
			return true;
		}
	}
}
