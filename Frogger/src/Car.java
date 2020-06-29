import java.awt.*;
import java.util.logging.Logger;

public class Car extends Rectangle
{
	public static final int WIDTH = 18;
	public static final int HEIGHT = 18;

	private int speed;
	private Color color;

	public static final Logger logger = Logger.getLogger(Car.class.getName());

	public Car(int x, int y, int speed, Color color)
	{
		super(x,y,WIDTH,HEIGHT);
		this.speed = speed;
		this.color = color;
	}

	public Car moveLeft()
	{
		logger.info("new car left");
		return new Car(x-speed,y,speed,color);
	}

	public Car moveRight()
	{
		logger.info("new car right");
		return new Car(x+speed,y,speed,color);
	}

	public boolean empty()
	{
		return color == null;
	}

	public void draw(Graphics graphics)
	{
		if(color != null)
		{
			logger.info("drawn from null");
			graphics.setColor(color);
			graphics.fillRect(x,y,WIDTH,HEIGHT);
		}
	}
}