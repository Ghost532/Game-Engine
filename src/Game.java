import javax.swing.JFrame; // Responsável por criar interfaces gráficas //

public class Game {
	
	private final JFrame window = new JFrame();
	private final ScreenFactory screenFactory;
	private final GameThread gameThread;
	private final KeyBoardListener keyboardListener;
	private final MousepadListener mousepadListener;
	
	public Game (int windowX, int windowY, String title) { // Método onde é definido parâmetros da janela
		window.setSize(windowX, windowY);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fecha o programa
		window.setFocusable(true); // permite receber input do teclado e mouse
		window.setLocationRelativeTo(null); // faz com que a janela centralize no meio da tela
		window.setTitle(title);
		window.setVisible(true);
		screenFactory = new ScreenFactory(this);
		gameThread = new GameThread(this);
		keyboardListener = new KeyBoardListener();
		mousepadListener = new MousepadListener();
		
		window.add(gameThread);
		window.addKeyListener(keyboardListener);
		window.addMouseListener(mousepadListener);
		
		new Thread(gameThread).start(); // Da início ao "jogo"
	}
	
	// Métodos para puxar outras classes
	
	public MousepadListener getMousepadListener() {
		return mousepadListener;
	}
	
	public KeyBoardListener getKeyboardListener() {
		return keyboardListener;
	}
	
	public ScreenFactory getsScreenFactory() {
		return screenFactory;
	}
	
	public JFrame getWindow() {
		return window;
	}
}
