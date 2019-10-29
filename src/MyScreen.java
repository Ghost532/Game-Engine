import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class MyScreen extends Screen {
	
	private int x = 0, y = 0;
	
	public MyScreen(ScreenFactory screenFactory) {
		super(screenFactory);
	}
	
	@Override
	public void onCreate() {
	}

	@Override
	public void onUpdate() {
		if (getsScreenFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_A))
			x -= 2;
		if (getsScreenFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_D))
			x += 2;
		if (getsScreenFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_W))
			y -= 2;
		if (getsScreenFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_S))
			y += 2;
		
		if (y >= 570 -64)
			y = 570 - 64;
		if (y <= 0)
			y = 0;
		if (x >= 800 - 64)
			x = 800 - 64;
		if (x <= 0)
			x = 0;
	}

	@Override
	public void onDraw(Graphics2D g2d) {
		g2d.setColor(Color.green);
		g2d.fillRect(x, y, 64, 64);
	}

	
}
