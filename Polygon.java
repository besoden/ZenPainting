import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class Polygon extends JPanel {
	protected int numVertices; //number of vertices in the polygon
	public int[] xCoordinates; //coordinates of polygon: top left, top right, bottom right, bottom left
	public int[] yCoordinates; //coordinates of polygon: top left, top right, bottom right, bottom left
	protected int xCenter; //x coordinate of center of polygon
	protected int yCenter; //y coordinate of center of polygon
	protected Color fillColor; //color of polygon
	protected Graphics graphics; //graphics for drawing
	public boolean isCollision;
	
	public Polygon(int vertexNum, int xCoord, int yCoord, Color colorToPaint, Graphics g)
	{	
		numVertices = vertexNum;
		
		xCoordinates = new int[vertexNum];
		yCoordinates = new int[vertexNum];
		
		//in the demo version of Canvas the mouse's x and y coords are the center of the rectangle
		xCenter = xCoord;
		yCenter = yCoord;
		
		fillColor = colorToPaint;
		graphics = g;
		isCollision = false;
	}
	
	public void incrementAllY()
	{
		for(int i = 0; i < yCoordinates.length; i++){
			yCoordinates[i]++;
		}
	}
	
	public void color()
	{
		graphics.setColor(fillColor);
		graphics.fillPolygon(xCoordinates, yCoordinates, numVertices); //fills from top left, top right, bottom right, bottom left
	}
	
	public void updateColor(Color newColor)
	{
		fillColor = newColor;
		graphics.setColor(fillColor);
		graphics.fillPolygon(xCoordinates, yCoordinates, numVertices);
	}
	
	public void fallDown()
	{
		this.updateColor(fillColor);
		this.incrementAllY();
		this.updateColor(fillColor);
	}
	
	public void partyFallDown()
	{
		this.updateColor(new Color(randInt(0, 255), randInt(0, 255), randInt(0, 255)));
		this.incrementAllY();
		this.updateColor(new Color(randInt(0, 255), randInt(0, 255), randInt(0, 255)));
	}
	
	public static int randInt(int min, int max) {
	    Random rand = new Random();

	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
}
