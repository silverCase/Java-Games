import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.awt.*;

public class Ball
{
	public static final int RADIUS = 10;
	public static final int SPEED = 10;
	private int x, y;
	private double dx, dy;

	public Ball(int x, int y)
	{
		this(x,y,0,0);
	}
	private static final Logger logger = LogManager.getLogger(Ball.class);

	public Ball(int x, int y, double dx, double dy)
	{
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		logger.debug("ball created");

	}

	public Ball moveLeft()
	{
		logger.debug("move left");
		return new Ball(x-SPEED, y, dx, dy);
	}

	public Ball moveRight()
	{
		logger.debug("move right");
		return new Ball(x+SPEED, y, dx, dy);
	}

	public Ball accelerate(double ax, double ay)
	{
		logger.debug("accelerate");
		return new Ball(x, y, dx+ax, dy+ay);
	}

	public Ball setVelocity(double dx, double dy)
	{
		logger.debug("velocity set");
		return new Ball(x, y, dx, dy);
	}

	public Ball setPosition(int x, int y)
	{
		logger.debug("posix set");
		return new Ball(x, y, 0, 0);
	}

	public Ball move(int dx, int dy)
	{
		logger.debug("moved");
		return new Ball(x+dx, y+dy, 0, 0);
	}

	public Ball move()
	{
		logger.debug("move");
		return new Ball(x+(int)dx, y+(int)dy, dx, dy);
	}

	public Rectangle getBounds()
	{
		logger.debug("bounds");
		return new Rectangle(x-RADIUS, y-RADIUS, RADIUS*2, RADIUS*2);
	}

	public Point getLocation()
	{
		logger.debug("locale");
		return new Point(x,y);
	}

	public void draw(Graphics g)
	{
		logger.debug("graphix done");
		g.setColor(Color.BLACK);
		g.fillOval(x-RADIUS, y-RADIUS, RADIUS*2, RADIUS*2);
	}
}