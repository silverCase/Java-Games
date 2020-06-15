import java.util.logging.Logger;
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
	private static final Logger logger = Logger.getLogger(Ball.class.getName());

	public Ball(int x, int y, double dx, double dy)
	{
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		logger.info("ball created");

	}

	public Ball moveLeft()
	{
		logger.info("move left");
		return new Ball(x-SPEED, y, dx, dy);
	}

	public Ball moveRight()
	{
		logger.info("move right");
		return new Ball(x+SPEED, y, dx, dy);
	}

	public Ball accelerate(double ax, double ay)
	{
		logger.info("accelerate");
		return new Ball(x, y, dx+ax, dy+ay);
	}

	public Ball setVelocity(double dx, double dy)
	{
		logger.info("velocity set");
		return new Ball(x, y, dx, dy);
	}

	public Ball setPosition(int x, int y)
	{
		logger.info("posix set");
		return new Ball(x, y, 0, 0);
	}

	public Ball move(int dx, int dy)
	{
		logger.info("moved");
		return new Ball(x+dx, y+dy, 0, 0);
	}

	public Ball move()
	{
		logger.info("move");
		return new Ball(x+(int)dx, y+(int)dy, dx, dy);
	}

	public Rectangle getBounds()
	{
		logger.info("bounds");
		return new Rectangle(x-RADIUS, y-RADIUS, RADIUS*2, RADIUS*2);
	}

	public Point getLocation()
	{
		logger.info("locale");
		return new Point(x,y);
	}

	public void draw(Graphics g)
	{
		logger.info("graphix done");
		g.setColor(Color.BLACK);
		g.fillOval(x-RADIUS, y-RADIUS, RADIUS*2, RADIUS*2);
	}
}