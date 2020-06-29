import java.util.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.event.*;

public abstract class ListeningGameComponent extends GameComponent implements MouseListener, MouseMotionListener, KeyListener
{
	private boolean mousePressed1 = false, mousePressed2 = false, mousePressed3 = false;
	private ArrayList<String> keysPressed = new ArrayList();
	public int mouseX = 0, mouseY = 0;

	public ListeningGameComponent(int w, int h)
	{
		super(w,h);
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
	}

	public abstract void draw(Graphics graphics);

	public abstract void update();

	public void mouseClicked(MouseEvent mouseEvent){}
	public void mouseEntered(MouseEvent mouseEvent){}
	public void mouseExited(MouseEvent mouseEvent){}

	public void mousePressed(MouseEvent mouseEvent)
	{
		if(mouseEvent.getButton() == mouseEvent.BUTTON1)
			mousePressed1 = true;
		if(mouseEvent.getButton() == mouseEvent.BUTTON2)
			mousePressed2 = true;
		if(mouseEvent.getButton() == mouseEvent.BUTTON3)
			mousePressed3 = true;
	}

	public void mouseReleased(MouseEvent mouseEvent)
	{
		if(mouseEvent.getButton() == mouseEvent.BUTTON1)
			mousePressed1 = false;
		if(mouseEvent.getButton() == mouseEvent.BUTTON2)
			mousePressed2 = false;
		if(mouseEvent.getButton() == mouseEvent.BUTTON3)
			mousePressed3 = false;
	}

	public void mouseDragged(MouseEvent mouseEvent)
	{
		if(mouseEvent.getButton() == mouseEvent.BUTTON1)
			mousePressed1 = !mousePressed1;
		if(mouseEvent.getButton() == mouseEvent.BUTTON2)
			mousePressed2 = !mousePressed2;
		if(mouseEvent.getButton() == mouseEvent.BUTTON3)
			mousePressed3 = !mousePressed3;
		mouseX = mouseEvent.getX();
		mouseY = mouseEvent.getY();
	}

	public void mouseMoved(MouseEvent mouseEvent)
	{
		mousePressed1 = false;
		mousePressed2 = false;
		mousePressed3 = false;

		mouseX = mouseEvent.getX();
		mouseY = mouseEvent.getY();
	}

	public void keyPressed(KeyEvent keyEvent)
	{
		//System.out.println(keyEvent.getKeyText(keyEvent.getKeyCode()));
		keysPressed.add(keyEvent.getKeyText(keyEvent.getKeyCode()));
	}

	public void keyReleased(KeyEvent keyEvent)
	{
		for(int i = 0; i < keysPressed.size(); i++)
		{
			if(keysPressed.get(i).equals(keyEvent.getKeyText(keyEvent.getKeyCode())))
			{
				keysPressed.remove(i);
				i--;
			}
		}
	}

	public void keyTyped(KeyEvent keyEvent){}


	public boolean isMousePressed(int b)
	{
		if(b == 1)
			return mousePressed1;
		else if(b == 2)
			return mousePressed2;
		else if(b == 3)
			return mousePressed3;

		return false;
	}

	public boolean isMousePressed()
	{
		if(mousePressed1)
			return mousePressed1;
		else if(mousePressed2)
			return mousePressed2;
		else if(mousePressed3)
			return mousePressed3;

		return false;
	}

	public boolean isKeyPressed(String k)
	{
		for(int i = 0; i < keysPressed.size(); i++)
		{
			if(keysPressed.get(i).equalsIgnoreCase(k))
			{
				return true;
			}
		}
		return false;
	}
}