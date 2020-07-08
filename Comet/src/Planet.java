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
		logger.fatal("NEW PLANET");
	}

	public boolean contains(Planet other)
	{
		logger.info("contains");
		return Math.sqrt((other.x-x)*(other.x-x) + (other.y-y)*(other.y-y))<=Math.max(radius, other.radius);
	}

	public double getMass()
	{
		return (4.0/3.0)*radius*radius*radius*Math.PI;
	}

	public void draw(Graphics g)
	{
		logger.fatal("draw planet");
		g.setColor(Color.BLACK);
		g.fillOval((int)(x-radius+.5), (int)(y-radius+.5), (int)(radius*2+.5), (int)(radius*2+.5));
	}
}