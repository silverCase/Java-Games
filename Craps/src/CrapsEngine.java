import java.util.logging.Logger;
import java.awt.*;

public class CrapsEngine
{
	private CrapsGame game;
	private int money = 100;
	private int bet = 10;
	public static final Logger logger = Logger.getLogger(CrapsEngine.class.getName());

	public CrapsEngine()
	{
		logger.severe("STARTED ENGINE");
		game = new CrapsGame();
	}

	public void upBet()
	{
		if(game.getState() == CrapsState.START)
			bet++;

		if(bet > money)
			bet = money;

		logger.info(String.valueOf(bet));

	}

	public void downBet()
	{
		if(game.getState() == CrapsState.START)
			bet--;

		if(bet < 0)
			bet = 0;

		logger.info(String.valueOf(bet));
	}

	public void roll()
	{
		if(game.getState() == CrapsState.WON)
		{
			money+=bet;
			game = new CrapsGame();
		}
		else if(game.getState() == CrapsState.LOST)
		{
			money-=bet;
			if(money == 0)
				money = 10;

			if(bet > money)
				bet = money;
			game = new CrapsGame();
		}
		else
			game.roll();
	}

	public int getWidth()
	{
		return game.getWidth();
	}

	public int getHeight()
	{
		return game.getHeight()+40;
	}

	public void draw(Graphics g)
	{
		game.draw(g);
		g.setColor(Color.BLACK);
		g.drawString("Money: " + money, 10, game.getHeight()+20);
		g.drawString("Bet: " + bet, 10, game.getHeight()+32);
		logger.info("draw");

	}
}