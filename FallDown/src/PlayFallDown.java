import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;

public class PlayFallDown extends JFrame
{
	private static final Logger logger = Logger.getLogger(PlayFallDown.class.getName());

	public PlayFallDown()
	{
		getContentPane().setLayout(new FlowLayout());
		add(new FallDownComponent());
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		new PlayFallDown();
		logger.severe("GAME STARTED");
	}
}