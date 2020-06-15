import javax.swing.*;
import java.awt.*;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.apache.log4j.BasicConfigurator;

public class PlayFallDown extends JFrame
{
	private static final Logger logger = LogManager.getLogger(PlayFallDown.class);

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
		org.apache.log4j.BasicConfigurator.configure();
		new PlayFallDown();
		logger.fatal("GAME STARTED");
	}
}