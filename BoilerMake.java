import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;


public class BoilerMake extends JFrame implements ActionListener{
	static JButton  closeButton = null;
	static JPanel myPanel = null;
	static Graphics myGraphics = null;
	private Canvas myCanvas = null;
	static JButton changeColorButton = null;
	static JButton partyTimeButton = null;
	static JButton increaseRectangleSizeButton = null;
	static JButton decreaseRectangleSizeButton = null;
	static JButton resetBoardButton = null;
	int WIDTH = 900;
	int HEIGHT = 700;
 
	public static void main(String[] args) {
		BoilerMake demo = new BoilerMake();
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				System.out.println("Timer updated");
				for(Rectangle cur: demo.myCanvas.shapes)
				{
					if(cur != null && !demo.myCanvas.isPartyFlag()) { cur.fallDown(); }
					else if(cur != null && demo.myCanvas.isPartyFlag()) { cur.partyFallDown(); }
				}
				
				}
			}, 0,5);
		}
 
	public BoilerMake(){
		closeButton = new JButton("close");
		closeButton.addActionListener(this);
		myPanel = new JPanel();
		myPanel.add(closeButton);
		
		resetBoardButton = new JButton("Reset Board");
		resetBoardButton.addActionListener(this);
		myPanel.add(resetBoardButton);
		
		decreaseRectangleSizeButton = new JButton("Decrease Rectangle Size");
		decreaseRectangleSizeButton.addActionListener(this);
		myPanel.add(decreaseRectangleSizeButton);
		
		increaseRectangleSizeButton = new JButton("Increase Rectangle Size");
		increaseRectangleSizeButton.addActionListener(this);
		myPanel.add(increaseRectangleSizeButton);
		
		changeColorButton = new JButton("Change Color Range");
		changeColorButton.addActionListener(this);
		myPanel.add(changeColorButton);
		
		partyTimeButton = new JButton("PARTY");
		partyTimeButton.addActionListener(this);
		myPanel.add(partyTimeButton);
		
		myPanel.setBackground(Color.black);
		myPanel.setBounds(0, 0, WIDTH, HEIGHT);
		myPanel.setSize(WIDTH, HEIGHT);
		
		this.setTitle("Relax with this zen painting program!");
		this.setSize(WIDTH, HEIGHT);
		this.getContentPane().setBackground(Color.BLACK);
		this.add(myPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
  
		myCanvas = new Canvas();
		this.add(myCanvas);
		}
  
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand() == "close") { System.exit(0); }
		else if(e.getActionCommand() == "Change Color Range") { this.myCanvas.changeColorSpectrum();}
		else if(e.getActionCommand() == "PARTY") 
		{ 
			this.myCanvas.changePartyFlag(); 
			partyTimeButton.setText("Stop the party"); 
		}
		else if(e.getActionCommand() == "Stop the party")
		{
			this.myCanvas.changePartyFlag(); 
			partyTimeButton.setText("PARTY");
		}
		else if(e.getActionCommand() == "Decrease Rectangle Size")
		{
			this.myCanvas.decreaseRectangleSize();
		}
		else if(e.getActionCommand() == "Increase Rectangle Size")
		{
			this.myCanvas.increaseRectangleSize();
		}
		else if(e.getActionCommand() == "Reset Board")
		{
			this.myCanvas.resetBoard();
		}
	}
}