import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Polygon{
	public int WIDTH;
	public int HEIGHT;
	
	public Rectangle(int xCoord, int yCoord, int w, int h, Color colorToPaint, Graphics g)
	{
		super(4, xCoord, yCoord, colorToPaint, g); //rectangles always have 4 vertices
		
		WIDTH = w;
		HEIGHT = h;
		
		//assuming that width and height always are even numbers
		//0= top left, 1= top right, 2= bottom right, 3= bottom left
		xCoordinates[0] = xCenter - WIDTH/2;   yCoordinates[0] = yCenter - HEIGHT/2;
		xCoordinates[1] = xCenter + WIDTH/2;   yCoordinates[1] = yCenter - HEIGHT/2;
		xCoordinates[2] = xCenter + WIDTH/2;   yCoordinates[2] = yCenter + HEIGHT/2;
		xCoordinates[3] = xCenter - WIDTH/2;   yCoordinates[3] = yCenter + HEIGHT/2;
				
		this.color();
	}
	
	public void updateDimensions(int width, int height)
	{
		WIDTH = width;
		HEIGHT = height;
	}
	
	public void update(int x, int y, int width, int height, Color newColor)
	{
		this.updateVertices(x, y);
		this.updateColor(newColor);
		this.updateDimensions(width, height);
	}
	
	public void updateVertices(int x, int y)
	{
		xCenter = x;
		yCenter = y;
		
		xCoordinates[0] = xCenter - WIDTH/2;   yCoordinates[0] = yCenter - HEIGHT/2;
		xCoordinates[1] = xCenter + WIDTH/2;   yCoordinates[1] = yCenter - HEIGHT/2;
		xCoordinates[2] = xCenter + WIDTH/2;   yCoordinates[2] = yCenter + HEIGHT/2;
		xCoordinates[3] = xCenter - WIDTH/2;   yCoordinates[3] = yCenter + HEIGHT/2;
	}
}
