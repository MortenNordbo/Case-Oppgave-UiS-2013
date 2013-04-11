package startFiler;

import javax.swing.JFrame;

import loadingScreen.LoadingScreen;
//import loadingScreen.Panel;
import ourPanels.mainPanel;
import view.GaspriceView2;

public class MainFile {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Oppgave#2");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		LoadingScreen LS = new LoadingScreen();
		mainPanel panel = new mainPanel(1024, 640,LS);

		frame.getContentPane().add(panel);			
		frame.setSize(1024, 640); 
		frame.setVisible(true);

		GaspriceView2 program = new GaspriceView2();
		program.start(LS);
	}
}