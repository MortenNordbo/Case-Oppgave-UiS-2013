package ourPanels;

import java.util.ArrayList;

import javax.swing.JPanel;

import model.Entities.PricePoint;

import TriDTegning.SoyleGraf;

@SuppressWarnings("serial")
public class mainPanel extends JPanel{

	int frameWidth, frameHeight = 0;
	LoadingPanel loadingPanel;
	MenuPanel menuPanel;
	SoyleGraf maxMinGraph;

	

	public mainPanel(int frameWidth, int frameHeight, LoadingPanel loadingPanel){
		setLayout(null);
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		this.loadingPanel = loadingPanel;
		
		menuPanel = new MenuPanel();	

		menuPanel.setLocation(7*frameWidth/8, 0);
		menuPanel.setSize(frameWidth/8, frameHeight);
		menuPanel.setVisible(false);
		add(menuPanel);	

		
		//add other graph panels here using: "graphPanelSetup();
		
		loadingPanel.setLocation(0, 0);
		loadingPanel.setSize(frameWidth, frameHeight);
		add(loadingPanel);
	}	

	/**********************************************************************************
	 *	Class: 	Setup for the main feature program.
	 *			The loading panel is 'closed'. Graph and menu panels are 'loaded'.
	 **********************************************************************************/
	public void loadingIsDone(ArrayList<ArrayList<PricePoint>> data){

		try {Thread.sleep(1000);}	//to make sure the last progressbar in loadingPanel is shown.
		catch(InterruptedException ex) {Thread.currentThread().interrupt();}
		
		maxMinGraph = new SoyleGraf(data);
		graphPanelSetup(maxMinGraph);	
		loadingPanel.setVisible(false);
		menuPanel.setVisible(true);
		maxMinGraph.setVisible(true);
		
		//.setVisible(true);
	}
	
	private void graphPanelSetup(JPanel panel){
		panel.setLocation(0, 0);
		panel.setSize(7*frameWidth/8, frameHeight);
		panel.setVisible(false);
		add(panel);	
	}
}