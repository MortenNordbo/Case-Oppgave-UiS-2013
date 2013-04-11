package startFiler;

import javax.swing.JFrame;

import loadingScreen.LoadingScreen;
//import loadingScreen.Panel;
import ourPanels.mainPanel;
import view.GaspriceView2;

public class MainFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
			JFrame frame = new JFrame("Oppgave#2");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			ourPanels panels = new ourPanels();
			
			frame.getContentPane().add(panel);			
			frame.setSize(1024, 640); 
			frame.setVisible(true);
		}	
		
		LoadingScreen LS = new LoadingScreen();
		GaspriceView2 program = new GaspriceView2();
		program.start(LS);
	}

}
