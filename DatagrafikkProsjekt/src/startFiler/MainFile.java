package startFiler;

import loadingScreen.LoadingScreen;
import view.GaspriceView2;

public class MainFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		LoadingScreen LS = new LoadingScreen();
		GaspriceView2 program = new GaspriceView2();
		program.start(LS);
	}

}
