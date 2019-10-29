import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class GameThread extends JPanel implements Runnable{

	
	private final Game game;
	
	public GameThread(Game game) {
		this.game = game;
		setFocusable(true);
		
	}
	
	public void run() {
		while (true) {
			try {
				if (game.getsScreenFactory().getCurrentScreen() != null)  // checa se a tela é nula, e caso não, joga pro OnUpdate que irá estar atualizando a tela
					game.getsScreenFactory().getCurrentScreen().onUpdate();
				Thread.sleep(10);
			} catch (Exception e) { // para casos de erro
				e.printStackTrace(); 
			}
		}
	}

	public void paint (Graphics g) {
		super.paint(g); // é herdado a classe Jpanel
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Renderização para suavizar a imagem
		if (game.getsScreenFactory().getCurrentScreen() != null) // aqui é feito o "desenho"
			game.getsScreenFactory().getCurrentScreen().onDraw(g2d);
		repaint();
	}
	
}
