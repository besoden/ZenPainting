import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.util.Random;

public class Canvas extends JPanel implements MouseListener{
 
	private int x,y;
	public Rectangle[] shapes; //keeps track of shapes
	private int shapesIndex; //keeps track of the newest polygon in shapes so that there are not more than 15 shapes on the board.
	private boolean eraseAndRecolor;
	private int maxShapesAllowed;
	protected int WIDTH = 900;
	protected int HEIGHT = 700;
	private int colorSpectrum;
	private boolean partyFlag;
	private int rectangleWidth;
	private int rectangleHeight;
 
	public Canvas() {
		this.addMouseListener(this);
		this.setBackground(Color.black);
		this.setSize(WIDTH,HEIGHT);	
		x = 0;
		y = 0;
		maxShapesAllowed = 30;
		shapes = new Rectangle[maxShapesAllowed];
		shapesIndex = 0;
		eraseAndRecolor = false;
		colorSpectrum = 1;
		partyFlag = false;
		rectangleWidth = 30;
		rectangleHeight = 20;
		}
	
	public int getX() { return x; }
	public int getY() { return y; }
 
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouse clicked.");

		if (eraseAndRecolor == true) { 
			shapes[shapesIndex % maxShapesAllowed].updateColor(Color.black); 
			}
			
		x = e.getX(); //get new coords
		y = e.getY(); //get new coords
		
		if(eraseAndRecolor == false)
		{
			Graphics myGraphics = getGraphics(); //int xCoord, int yCoord, int w, int h, Color colorToPaint, Graphics g
			shapes[shapesIndex % maxShapesAllowed] = new Rectangle(x, y, rectangleWidth, rectangleHeight, generateColor(), myGraphics);
		}
		else{
			shapes[shapesIndex % maxShapesAllowed].update(x, y, rectangleWidth, rectangleHeight, generateColor());
		}
		
		shapesIndex++;
		
		if(shapesIndex == maxShapesAllowed) { eraseAndRecolor = true; }		
		}

	public void mousePressed(MouseEvent e) {
		System.out.println("mouse clicked.");
		}

	public void mouseReleased(MouseEvent e) {
		System.out.println("mouse released.");
		}

	public void mouseEntered(MouseEvent e) {
		}

	public void mouseExited(MouseEvent e) {
		}
	
	public static int randInt(int min, int max) {
	    Random rand = new Random();

	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
		}
	
	public Color generateColor()
	{
		if(colorSpectrum == 1)
			{ return new Color(255, 255, randInt(0, 255)); }
		else if (colorSpectrum == 2)
			{ return new Color(255, randInt(0, 255), 255); }
		else if (colorSpectrum == 3)
			{ return new Color(randInt(0, 255), 255, 255); }
		else
			{ return new Color(randInt(0, 255), randInt(0, 255), randInt(0, 255)); }
	}
	
	public void changeColorSpectrum()
	{
		if(colorSpectrum == 1)
			{ colorSpectrum = 2; }
		else if (colorSpectrum == 2)
			{ colorSpectrum = 3; }
		else if (colorSpectrum == 3)
			{ colorSpectrum = 4; }
		else
			colorSpectrum = 1;
	}
	
	public void changePartyFlag()
	{
		partyFlag = !partyFlag;
	}
	
	public boolean isPartyFlag()
	{
		return partyFlag;
	}
	
	public void increaseRectangleSize()
	{
		rectangleWidth+=4;
		rectangleHeight+=4;
		for(Rectangle cur: shapes)
		{
			cur.WIDTH = rectangleWidth;
			cur.HEIGHT = rectangleHeight;
		}
	}
	
	public void decreaseRectangleSize()
	{
		rectangleWidth-=4;
		rectangleHeight-=4;
		for(Rectangle cur: shapes)
		{
			cur.WIDTH = rectangleWidth;
			cur.HEIGHT = rectangleHeight;
		}
	}
	
	public void resetBoard()
	{
		Graphics myGraphics = getGraphics();
		new Rectangle(WIDTH/2, HEIGHT/2, WIDTH, HEIGHT, Color.black, myGraphics);
	}
}