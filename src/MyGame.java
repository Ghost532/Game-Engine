
public class MyGame {

	private Game game;
	
	public MyGame() {
		game = new Game(800, 600, "Meu joguinho");
		game.getsScreenFactory().showScreen(new MyScreen(game.getsScreenFactory()));
	}
	
	public static void main (String[] args) {
		new MyGame();
	}
}
