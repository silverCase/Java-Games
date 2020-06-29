import java.util.logging.Logger;
import java.awt.*;
import java.io.Serializable;

public class Planet implements Serializable
{
	public static final long serialVersionUID = -388170342876888144L;
	public static final Logger logger = Logger.getLogger(Planet.class.getName());

	double radius;
	double x, y;

	public Planet(double radius, double x, double y)
	{
		this.x = x;
		this.y = y;
		this.radius = radius;
		logger.severe("NEW PLANET");
	}

	public boolean contains(Planet other)
	{
		logger.info("contains");
		return Math.sqrt(Math.pow((other.x-x), 2) + Math.pow((other.y-y),2))<=Math.max(radius, other.radius);
	}

	public double getMass()
	{
		return (4.0/3.0)*Math.pow(radius, 3)*Math.PI;
	}

	public void draw(Graphics graphics)
	{
		logger.severe("draw planet");
		graphics.setColor(Color.BLACK);
		graphics.fillOval((int)(x-radius+.5), (int)(y-radius+.5), (int)(radius*2+.5), (int)(radius*2+.5));
	}
}