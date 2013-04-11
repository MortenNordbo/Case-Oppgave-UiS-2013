package ourPanels;

import javax.swing.JPanel;

import loadingScreen.LoadingScreen;

public class mainPanel extends JPanel{

	int width, height = 0;

	public mainPanel(int width, int height, LoadingScreen lS){

		this.width = width;
				this.height = height;

		setLayout(null);
		MaxMinGraphPanel maxMinGraph = new MaxMinGraphPanel();
		menuPanel menuPanel = new menuPanel();


		lS.setLocation(0, 0);
		lS.setSize(width, height);
		add(lS);
	}

}
