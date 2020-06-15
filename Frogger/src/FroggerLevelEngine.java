import java.util.logging.Logger;

import java.awt.*;

public class FroggerLevelEngine
{
	public static final int WIDTH = 250;
	public static final int HEIGHT = 250;

	private TrafficPattern[] traffic;
	private Frog frog;
	private FroggerState state = FroggerState.MOVING;
	private static final Logger logger = Logger.getLogger(FroggerLevelEngine.class.getName());

	public FroggerLevelEngine(int[] speeds, String[] patterns)
	{
		traffic = new TrafficPattern[patterns.length];
		for(int i = 0; i < patterns.length; i++)
		{
			traffic[i] = new TrafficPattern(speeds[i], patterns[i], (i%2==0), getBounds(), (i+1)*(Car.HEIGHT+2));
		}
		frog = new Frog(WIDTH/2, HEIGHT-Frog.RADIUS, getBounds());
		logger.severe("ENGINE STARTED");
	}

	public FroggerLevelEngine(FroggerLevel level)
	{
		this(level.getSpeeds(), level.getPatterns());
	}

	public Rectangle getBounds()
	{
		return new Rectangle(0,0,WIDTH,HEIGHT);
	}

	public void update()
	{
		for(int i = 0; i < traffic.length; i++)
		{
			traffic[i].update();
			if(traffic[i].intersects(frog))
				state = FroggerState.HIT;
		}
		if(getWinBounds().contains(frog.getBounds()))
			state = FroggerState.WON;
	}

	public Rectangle getWinBounds()
	{
		return new Rectangle(0,0,WIDTH, Car.HEIGHT);
	}

	public FroggerState getState()
	{
		return state;
	}

	public void moveUp()
	{
		if(state == FroggerState.MOVING)
			frog = frog.moveUp();
		logger.info("move up");

	}

	public void moveDown()
	{
		if(state == FroggerState.MOVING)
			frog = frog.moveDown();
		logger.info("move down");

	}

	public void moveLeft()
	{
		if(state == FroggerState.MOVING)
			frog = frog.moveLeft();
		logger.info("move left");

	}

	public void moveRight()
	{
		if(state == FroggerState.MOVING)
			frog = frog.moveRight();
		logger.info("move right");

	}

	public void draw(Graphics g)
	{
                frog.drawLevel(g,1);
		frog.draw(g);
		for(int i = 0; i < traffic.length; i++)
		{
			traffic[i].draw(g);
		}
		logger.info("draw");


//		if(state == FroggerState.HIT)
//		{
//			g.setColor(Color.BLACK);
//			g.drawString("YOU GOT HIT", WIDTH/2-50, HEIGHT/2);
//		}
	}
}