package view;

import java.util.ArrayList;

import loadingScreen.LoadingScreen;
import model.Entities.PricePoint;
import repository.PricePointRepository;

public class GaspriceView2 {

	/**
	 * 
	 */
	public void start(LoadingScreen LS) {
		PricePointRepository model = new PricePointRepository();
		
		new ButtonHandler(this, model, LS);
	}

	/**
	 * @param data2
	 */
	public void draw(ArrayList<ArrayList<PricePoint>> data2) {
		// Test for å hente ut data
		System.out.println(data2.get(2).get(8).toString());
	}
}
