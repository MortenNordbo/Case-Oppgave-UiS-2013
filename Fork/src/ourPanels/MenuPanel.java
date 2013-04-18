package ourPanels;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MenuPanel extends JPanel implements ActionListener{

	JButton firstBtn, scndBtn, thirdBtn, fourthBtn;

	public MenuPanel(){
		setLayout(new GridLayout(0, 1));
		setBackground(Color.green);

		firstBtn = new JButton("First");
		firstBtn.addActionListener(this);
		
		scndBtn = new JButton("Second");
		scndBtn.addActionListener(this);
		
		thirdBtn = new JButton("Third");
		thirdBtn.addActionListener(this);
		
		fourthBtn = new JButton("Fourth");
		fourthBtn.addActionListener(this);
		
		//TDOD: Load btns with pictures(?)
//		URL url = getClass().getResource("/media/picture.jpg");
//		ImageIcon image = new ImageIcon(url);
		
		add(firstBtn);
		add(scndBtn);
		add(thirdBtn);
		add(fourthBtn);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == firstBtn){
			System.out.println("you have pressed: "+firstBtn);
		}
		else if (e.getSource() == scndBtn){
			System.out.println("you have pressed: "+scndBtn);
		}
		else if (e.getSource() == thirdBtn){
			System.out.println("you have pressed: "+thirdBtn);
		}
		else if (e.getSource() == fourthBtn){
			System.out.println("you have pressed: "+fourthBtn);
		}
	}
}