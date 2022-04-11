package gen;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.Dimension;
import javax.swing.JPanel;

public class randomgenerator implements ActionListener{
	
	ImageIcon icon = new ImageIcon("pixelbg.png");
	
	// Timer
	Timer timer;
	int second;
	
	
	//upgrades
	int lvlcost = 5;
	int autocost = 100;
	
	
	  // Initialize the counter
	  private int multi = 1;
	  private int i = 1;
	  private int starttime = 3000;

	  // label to display the counter value
	  private JLabel label;
	  private JLabel multiply;
	  private JLabel empty;
	  private JLabel empty2;
	  private JLabel empty3;
	  private JLabel empty4;
	  private JLabel empty5;
	  private JLabel empty6;
	  
	  // Increment button
	  private JButton plus;
	  // Level button
	  private JButton level;
	  // Auto Clicker
	  private JButton autoclick;
	  
	  public JPanel getPanel() {
		  

		  
	    // Create the panel
	    JPanel panel = new JPanel();
	    panel.setLayout(new GridLayout(3, 3, 20, 25)); 
	    panel.setBackground(Color.white);
	    
	    // Background
	    JLabel background = new JLabel();
	    background.setText("Hello");
	    
	    
	    
	    
	    
	    
	    // Adds Label
	    label = new JLabel("Troll Clicker");
	    panel.add(label);	
	    label.setFont(new Font("Calibri", Font.PLAIN, 30));
	    
	    // Add multiplier button to JPanel
	    multiply = new JLabel(" x" + multi);
	    panel.add(multiply);	
	    multiply.setFont(new Font("Calibri", Font.PLAIN, 50));
	    
	    // Add multiplier button to JPanel
	    empty = new JLabel(icon);
	    panel.add(empty);	
	    empty.setFont(new Font("Calibri", Font.PLAIN, 50));
	    empty.setBackground(Color.black);
	    empty.setIcon(icon);
	    
	    // Add the counter to JPanel
	    label = new JLabel("Points " + i);
	    panel.add(label);
	    label.setFont(new Font("Calibri", Font.PLAIN, 50));
	    
	    // Add multiplier button to JPanel
	    empty2 = new JLabel(" ");
	    panel.add(empty2);	
	    empty2.setFont(new Font("Calibri", Font.PLAIN, 50));
	    empty2.setBackground(Color.cyan);

	    
	    // Add multiplier button to JPanel
	    empty3 = new JLabel(" ");
	    panel.add(empty3);	
	    empty3.setFont(new Font("Calibri", Font.PLAIN, 50));
	    empty3.setBackground(Color.cyan);

	    
	    // Add multiplier button to JPanel
	    empty4 = new JLabel(" ");
	    panel.add(empty4);	
	    empty4.setFont(new Font("Calibri", Font.PLAIN, 50));
	    empty4.setBackground(Color.cyan);

	    
	    // Add multiplier button to JPanel
	    empty5 = new JLabel(" ");
	    panel.add(empty5);	
	    empty5.setFont(new Font("Calibri", Font.PLAIN, 50));
	    empty5.setBackground(Color.cyan);

	    
	    // Add multiplier button to JPanel
	    empty6 = new JLabel(" ");
	    panel.add(empty6);	
	    empty6.setFont(new Font("Calibri", Font.PLAIN, 50));
	    empty6.setBackground(Color.cyan);

	    
	    // Add increment button to JPanel
	    plus = new JButton("+");
	    plus.addActionListener(this);
	    panel.add(plus);
	    plus.setPreferredSize(new Dimension(200, 50));
	    plus.setBackground(Color.cyan);
	    
	    // Add level button to JPanel
	    level = new JButton("Level Up!   " + lvlcost);
	    level.addActionListener(this);
	    panel.add(level);
	    level.setPreferredSize(new Dimension(200, 50));
	    level.setBackground(Color.white);
	    
	 // Add auto clicker button to JPanel
	    autoclick = new JButton("Auto Clicker!   " + autocost);
	    autoclick.addActionListener(this);
	    panel.add(autoclick);
	    autoclick.setPreferredSize(new Dimension(200, 50));
	    autoclick.setBackground(Color.green);
	    
	    return panel;
	     
	  }
	  
	
		@Override
		public void actionPerformed(ActionEvent e) {
			 if (e.getSource() == plus) {
			      i = multi + i;
			      label.setText("Points " + i);
			    }
			 else if (e.getSource() == autoclick) { 
				 
				 if (autocost <= i) { 
					 
					 	int autotimes = 0;
						i = i - autocost;
						autocost = autocost * 2;
						label.setText("Points " + i);
						autoclick.setText("Auto Clicker x" + autotimes + "     " + autocost);
				
					 // Timer
					 setTimer();
					 timer.start();
					 starttime = starttime - 300; 
					 }
					}
			 
			 
			 
			 else if (e.getSource() == level) { 
				 
				 if (lvlcost <= i) {
				multi++;
				multiply.setText("x " + multi);
				i = i - lvlcost;
				lvlcost = lvlcost * 2;
				label.setText("Points " + i);
				level.setText("Level Up! " + lvlcost);
				}

			 }
			 
		}
	
	
		

		  public void setTimer()	{
			  timer = new Timer(starttime, new ActionListener() {
				  
				  @Override
				  public void actionPerformed(ActionEvent e) {
					  i++;
					  label.setText("Points " + i);
				  }
			  });
		
		  }
		
		

		
		
		
		
		
		
		
		
		
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
	    frame.setTitle("Click Counter");
	    frame.setSize(new Dimension(1080,800));
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    // Create the panel
	    randomgenerator counter = new randomgenerator();
	    JPanel counterPanel = counter.getPanel(); 
	      
	    // Add the panel to the center of the window
	    Container content = frame.getContentPane();
	    content.add(counterPanel, BorderLayout.CENTER);
	    
	    // Show the window
	    frame.setVisible(true);
	    
		
		
	}
}
