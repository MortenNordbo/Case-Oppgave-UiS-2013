package view;

import hooks.ConvertIntoUnit;
import hooks.GetHighLow;

import java.util.ArrayList;

import ourPanels.LoadingPanel;
import ourPanels.mainPanel;

import model.Entities.PricePoint;
import repository.PricePointRepository;

public class GaspriceView2 {

	/**
	 * 
	 */
	ArrayList<ArrayList<PricePoint>> data3 = new ArrayList<ArrayList<PricePoint>>();
	PricePoint highest;
	PricePoint laveste;
	
	public void start(LoadingPanel LS, mainPanel panel) {
		PricePointRepository model = new PricePointRepository();
		
		new ButtonHandler(this, model, LS, panel);
	}
	/**
	 * @param data2
	 */
	public void draw(ArrayList<ArrayList<PricePoint>> data2) {
		this.data3 = data2;
		// Test for å hente ut data
		ConvertIntoUnit Converter = new ConvertIntoUnit();
		data3.add(Converter.ConvertThis(data3.get(1)));
		data3.remove(1);
		
		GetHighLow getHighLow = new GetHighLow();
		highest = getHighLow.getHighest(data3);
		laveste = getHighLow.getLavest(data3);
		
		//Kjør paneler:
		//kjør hovedpanel
		//kjør menypanel
		//kjør grafPanel
		
		System.out.println("Høyeste pris er " + highest.getPrice());
		System.out.println("Laveste pris er " + laveste.getPrice());
	}
}
