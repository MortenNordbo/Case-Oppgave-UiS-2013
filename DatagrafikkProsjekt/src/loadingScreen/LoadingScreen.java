package loadingScreen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JApplet;
import javax.swing.JFrame;
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
		for (int i = 0; i < 10; i++)
			{panel.setProgress();
			try {
				this.wait(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
	}
}

class Panel extends JPanel{
	
	int variable = 0;
	
	Panel(){
		setPreferredSize(new Dimension(1024, 640));
	}
	
	public void setProgress(){
		variable += 5;
		repaint();
	}
	
	public void paintComponent(Graphics g){
		System.out.println("LOL");
		Graphics2D g2 = (Graphics2D) g;
		g2.setBackground(Color.black);
		g2.fillRect(0, 50, variable, 100);
	}
}