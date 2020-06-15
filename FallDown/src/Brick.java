import java.util.logging.Logger;
import java.awt.*;

public class Brick
{
	public static final int WIDTH = 50;
	public static final int HEIGHT = 25;

	private int x, y;
	private static final Logger logger = Logger.getLogger(Brick.class.getName());

	public Brick(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public Brick move(int dx, int dy)
	{
		return new Brick(x+dx, y+dy);
	}

	public Rectangle getBounds()
	{
		return new Rectangle(x-WIDTH/2, y-HEIGHT/2, WIDTH, HEIGHT);
	}

	public boolean intersects(Ball b)
	{
		return b.getBounds().intersects(getBounds());
	}

	public Ball affect(Ball b)
	{
		Ball ret = b;
		while(intersects(ret))
			ret = ret.move(0, -1);
			logger.fine("intersection");
		return ret;
	}

	public Point getLocation()
	{
		return new Point(x,y);
	}

	public void draw(Graphics g)
	{
		logger.info("graphix done");
		g.setColor(Color.RED);
		g.fillRect(x-WIDTH/2, y-HEIGHT/2, WIDTH-1, HEIGHT-1);
	}
}