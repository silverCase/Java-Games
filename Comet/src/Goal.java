import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.awt.*;
import java.io.Serializable;

public class Goal implements Serializable
{
	double radius;
	double x, y;
	boolean reached = false;
	public static final Logger logger = LogManager.getLogger(Goal.class);

	public Goal(double radius, double x, double y)
	{
		this.x = x;
		this.y = y;
		this.radius = radius;
		logger.debug("goal");
	}

	public void testReached(Comet c)
	{
		if(Math.pow(Math.pow(c.x-x,2) + Math.pow(c.y-y,2), .5) <= radius) {
			reached = true;
			logger.debug("reached");

		}
	}

	public void reset()
	{
		reached = false;
		logger.debug("reset");

	}

	public void draw(Graphics g)
	{
		if(reached)
			g.setColor(Color.GREEN);
		else
			g.setColor(Color.RED);
		g.drawOval((int)(x-radius+.5), (int)(y-radius+.5), (int)(radius*2+.5), (int)(radius*2+.5));
		logger.debug("drawn");

	}
}