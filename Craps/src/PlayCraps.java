import org.apache.log4j.BasicConfigurator;

import javax.swing.*;
import java.awt.*;

public class PlayCraps extends JFrame
{
	public PlayCraps()
	{
		getContentPane().setLayout(new FlowLayout());
		add(new CrapsComponent());
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		BasicConfigurator.configure();
		new PlayCraps();
	}
}