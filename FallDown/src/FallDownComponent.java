import java.util.logging.Logger;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FallDownComponent extends JComponent implements KeyListener, Runnable
{
	private FallDownEngine engine;
	private boolean leftPressed, rightPressed;
	private static final Logger logger = Logger.getLogger(FallDownComponent.class.getName());

	public FallDownComponent()
	{
		super();
		engine = new FallDownEngine();
 		setPreferredSize(new Dimension(engine.WIDTH, engine.HEIGHT));

 		addKeyListener(this);
 		Thread run = new Thread(this);
 		run.start();
		logger.severe("Started Fall down engine");
	}

	public void run()
	{
		while(true)
		{
			try
			{
				Thread.sleep(20);
			}
			catch(Exception ex)
			{
				logger.severe(String.valueOf(ex));
			}
			requestFocus();
			update();
			repaint();
			logger.info("frame");
		}
	}

	public void paint(Graphics graphics)
	{
		synchronized(graphics)
		{
			engine.draw(graphics);
		}
	}

	public void update()
	{
		if(leftPressed)
			engine.moveLeft();
		if(rightPressed)
			engine.moveRight();
		engine.update();
	}

	public void keyPressed(KeyEvent ke)
	{
		if(ke.getKeyCode() == KeyEvent.VK_LEFT)
		{
			leftPressed = true;
			logger.info("left pressed");
		}
		else if(ke.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			rightPressed = true;
			logger.info("right pressed");
		}
	}

	public void keyReleased(KeyEvent ke)
	{
		if(ke.getKeyCode() == KeyEvent.VK_LEFT)
			leftPressed = false;
		else if(ke.getKeyCode() == KeyEvent.VK_RIGHT)
			rightPressed = false;
	}

	public void keyTyped(KeyEvent ke)
	{
	}
}