
public class ScreenFactory {
	
	private final Game game;
	private Screen screen;
	
	public ScreenFactory(Game game) {
		this.game = game;
	
	}
	
	public void showScreen(Screen screen) { //Método onde mostra o que está atualmente na tela
		this.screen = screen;
		this.screen.onCreate();
	}
	
	public Screen getCurrentScreen() { //Método getter pra puxar Screen
		return screen;
	}
	
	public Game getGame() {
		return game;
	}
}
