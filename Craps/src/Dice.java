import java.awt.*;

public class Dice
{
	public static final int WIDTH = 25;
	public static final int HEIGHT = 25;
	private int state;
	private int sides;

	public Dice(int sides, int state)
	{
		this.sides = sides;
		this.state = state;
	}

	public Dice(int sides)
	{
		this(sides, (int)(Math.random()*sides)+1);
	}

	public Dice()
	{
		this(6);
	}

	public Dice roll()
	{
		return new Dice(sides);
	}

	public void draw(Graphics graphics, int x, int y)
	{
		graphics.setColor(Color.WHITE);
		graphics.fillRect(x,y,WIDTH, HEIGHT);
		graphics.setColor(Color.BLACK);
		graphics.drawRect(x,y,WIDTH-1, HEIGHT-1);
		graphics.drawString(""+state, x+WIDTH/2-3, y+HEIGHT/2+5);
	}

	public int getState()
	{
		return state;
	}
}