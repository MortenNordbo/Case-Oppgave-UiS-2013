package startFiler;

import javax.swing.JFrame;
import ourPanels.LoadingPanel;
import ourPanels.mainPanel;
import view.GaspriceView2;

public class MainFile {
	static int frameWidth, frameHeight;
	static JFrame frame;
	static LoadingPanel loadingPanel;
	static mainPanel panel;
	static GaspriceView2 program;
	//
	//Vi bruker axis klassen fra chapter7 i boka
	public static void main(String[] args) {
		frameWidth = 1024;
		frameHeight = 640;
		
		frame = new JFrame("BID110 Datagrafikk VÅR 2013: CASE");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		loadingPanel = new LoadingPanel();
		panel = new mainPanel(frameWidth, frameHeight, loadingPanel);

		frame.getContentPane().add(panel);			
		frame.setSize(1024, 640); 
		frame.setVisible(true);

		program = new GaspriceView2();
		program.start(loadingPanel, panel);
	}
}