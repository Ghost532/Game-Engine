
public class ScreenFactory {
	
	private final Game game;
	private Screen screen;
	
	public ScreenFactory(Game game) {
		this.game = game;
	
	}
	
	public void showScreen(Screen screen) { //M�todo onde mostra o que est� atualmente na tela
		this.screen = screen;
		this.screen.onCreate();
	}
	
	public Screen getCurrentScreen() { //M�todo getter pra puxar Screen
		return screen;
	}
	
	public Game getGame() {
		return game;
	}
}
