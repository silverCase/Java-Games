import java.awt.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Car extends Rectangle
{
	public static final int WIDTH = 18;
	public static final int HEIGHT = 18;

	private int speed;
	private Color color;

	public static final Logger logger = LogManager.getLogger(Car.class);

	public Car(int x, int y, int speed, Color color)
	{
		super(x,y,WIDTH,HEIGHT);
		this.speed = speed;
		this.color = color;
	}

	public Car moveLeft()
	{
		logger.debug("new car left");
		return new Car(x-speed,y,speed,color);
	}

	public Car moveRight()
	{
		logger.debug("new car right");
		return new Car(x+speed,y,speed,color);
	}

	public boolean empty()
	{
		return color == null;
	}

	public void draw(Graphics g)
	{
		if(color != null)
		{
			logger.debug("drawn from null");
			g.setColor(color);
			g.fillRect(x,y,WIDTH,HEIGHT);
		}
	}
}