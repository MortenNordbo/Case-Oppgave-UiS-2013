package loadingScreen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoadingScreen{
	
	JFrame frame;
	Panel panel;
	public LoadingScreen(){
		JFrame frame = new JFrame("Oppgave#2");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new Panel();
		frame.getContentPane().add(panel);
		frame.setSize(1024, 640); 
		frame.setVisible(true);
	}	
	
	public void setProgress() {
		panel.setProgress();
	}
}

@SuppressWarnings("serial")
class Panel extends JPanel{
	
	int progressionBar = 0;
	JLabel label;
	Color backgroundColor = new Color(83, 198, 241);	//Color: 'a shade of blue'.
	URL URLloadingAnimation;
	Icon imageLoadingAnimation;
	
	Panel(){
		setLayout(null);
		setPreferredSize(new Dimension(1024, 640));
		setBackground(backgroundColor);
		
		URLloadingAnimation = getClass().getResource("/media/loadingAnimation.gif");
		imageLoadingAnimation = new ImageIcon(URLloadingAnimation);
		
		label = new JLabel(imageLoadingAnimation);
		label.setSize(new Dimension(170, 40));
		label.setVisible(true);
		add(label);
	}
	
	public void setProgress(){
		progressionBar += getWidth()/4;
		repaint();
	}
	
	/******************************************************************************************
	 * Paints the progress bar.
	 * Note that Paint Component is compatible with different width and height for the frame.
	 ******************************************************************************************/
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		label.setLocation((getWidth()/2)-85, getHeight()/2);	//label.setLocation() is here to work properly with getWidth/Height.
		
		g2.setColor(Color.LIGHT_GRAY);
		g2.fillRect( 0, (getHeight()/2)+50, getWidth(), 100);	//potential progress bar.
		g2.setColor(Color.gray);
		g2.fillRect(0, (getHeight()/2)+50, progressionBar, 100);		//progress bar.
	}
}