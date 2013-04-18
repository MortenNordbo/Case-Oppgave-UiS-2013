package ourPanels;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Entities.PricePoint;

@SuppressWarnings("serial")
public class MenuPanel extends JPanel implements ActionListener{

	JButton firstBtn, scndBtn, thirdBtn, fourthBtn;
	ArrayList<ArrayList<PricePoint>> data;
	mainPanel mainPanel;
	
	public ArrayList<ArrayList<PricePoint>> getData() {
		return data;
	}

	public void setData(ArrayList<ArrayList<PricePoint>> data) {
		this.data = data;
	}

	public MenuPanel(mainPanel mainPanel){
		
		this.mainPanel = mainPanel;
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

		if (e.getSource() == firstBtn)
		{
			String aar = null;
			String maaned = null;
			String dato = null;
			aar = JOptionPane.showInputDialog("Skriv in år");
			maaned = JOptionPane.showInputDialog("Skriv in måned (f.Eks 03 for mars");
			dato = JOptionPane.showInputDialog("Skriv in dag");
			System.out.println(aar+maaned+dato);
			String datoen = aar+maaned+dato;
			double dato1 = 0;
			dato1 = Double.parseDouble(datoen);
			
			double[] values = new double[4];
			for (int i = 0; i < data.get(0).size(); i++)
			{
				if(data.get(0).get(i).getObservationDate() == dato1)
				{
					values[0] = data.get(0).get(i).getPrice();
				}
			}
			
			for (int i = 0; i < data.get(1).size(); i++)
			{
				if(data.get(1).get(i).getObservationDate() == dato1)
				{
					values[1] = data.get(1).get(i).getPrice();
				}
			}
			
			for (int i = 0; i < data.get(2).size(); i++)
			{
				if(data.get(2).get(i).getObservationDate() == dato1)
				{
					values[2] = data.get(2).get(i).getPrice();
				}
			}
			
			for (int i = 0; i < data.get(3).size(); i++)
			{
				if(data.get(3).get(i).getObservationDate() == dato1)
				{
					values[3] = data.get(3).get(i).getPrice();
				}
			}
			mainPanel.setValues(values);
			
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