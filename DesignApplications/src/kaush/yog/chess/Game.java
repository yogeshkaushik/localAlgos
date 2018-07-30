package kaush.yog.chess;

import kaush.yog.chess.pieces.Player;

public class Game {
	Board board;
	Player player1;
	Player player2;
	
	public Game() {
		board = new Board();
		player1 = new Player("Yogesh");
		player2 = new Player("Vishakha");
	}
	
	public static void main(String[] args) throws InterruptedException {
		Game game = new Game();
		while (true) {
			Thread.sleep(10000);
			game.player1.makeMove();
			Thread.sleep(10000);
			game.player2.makeMove();
		}
	}
}
