import java.awt.*;
import java.util.logging.Logger;

public class Frog
{
	public static final int RADIUS = 5;
	public static final Color COLOR = new Color(0,128,0);
	public static final int SPEED = 4;

	private int x,y;
	private Rectangle bounds;
	private static final Logger logger = Logger.getLogger(Frog.class.getName());


	public Frog(int x,int y, Rectangle bounds)
	{
		this.x = x;
		this.y = y;
		this.bounds = bounds;
		logger.severe("NEW FROG");

	}

	public Frog move(int dx, int dy)
	{
		Frog newFrog = new Frog(x+dx, y+dy, bounds);
		logger.severe("FROG MOVED");

		if(bounds.contains(newFrog.getBounds()))
			return newFrog;
		else
			return this;
	}

	public Frog moveTo(int x, int y)
	{
		return new Frog(x,y,bounds);
	}

	public Frog moveUp()
	{
		return move(0,-SPEED);
	}

	public Frog moveDown()
	{
		return move(0,SPEED);
	}

	public Frog moveLeft()
	{
		return move(-SPEED, 0);
	}

	public Frog moveRight()
	{
		return move(SPEED, 0);
	}

	public Rectangle getBounds()
	{
		return new Rectangle(x-RADIUS, y-RADIUS, RADIUS*2, RADIUS*2);
	}

	public void draw(Graphics graphics)
	{
		graphics.setColor(COLOR);
		graphics.fillOval(x-RADIUS, y-RADIUS, RADIUS*2, RADIUS*2);
	}

	public void drawLevel(Graphics graphics,int levelNumber)
	{
		logger.severe("LVL DRAWN");
		String level="LEVEL "+levelNumber;
		graphics.setColor(COLOR);
		graphics.drawString(level,300,400);
	}
}