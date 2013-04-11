package view;

import hooks.ConvertIntoUnit;
import hooks.GetHighLow;

import java.util.ArrayList;

import loadingScreen.LoadingScreen;
import model.Entities.PricePoint;
import repository.PricePointRepository;

public class GaspriceView2 {

	/**
	 * 
	 */
	ArrayList<ArrayList<PricePoint>> data3 = new ArrayList<ArrayList<PricePoint>>();
	PricePoint highest;
	PricePoint laveste;
	
	public void start(LoadingScreen LS) {
		PricePointRepository model = new PricePointRepository();
		
		new ButtonHandler(this, model, LS);
	}
	/**
	 * @param data2
	 */
	public void draw(ArrayList<ArrayList<PricePoint>> data2) {
		this.data3 = data2;
		// Test for � hente ut data
		ConvertIntoUnit Converter = new ConvertIntoUnit();
		data3.add(Converter.ConvertThis(data3.get(1)));
		data3.remove(1);
		System.out.println(data3.get(0).get(8).toString());
		System.out.println(data3.get(1).get(9).toString());

		System.out.println(data3.get(2).get(9).toString());
		System.out.println(data3.get(3).get(9).toString());
		
		GetHighLow getHighLow = new GetHighLow();
		highest = getHighLow.getHighest(data3);
		laveste = getHighLow.getLavest(data3);
		
		//Kj�r paneler:
		//kj�r hovedpanel
		//kj�r menypanel
		//kj�r grafPanel
		
		System.out.println("H�yeste pris er " + highest.getPrice());
		System.out.println("Laveste pris er " + laveste.getPrice());
	}
}
