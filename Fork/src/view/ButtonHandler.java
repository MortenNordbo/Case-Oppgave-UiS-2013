package view;

import java.util.ArrayList;
import ourPanels.LoadingPanel;
import ourPanels.mainPanel;
import model.Entities.PricePoint;
import repository.PricePointRepository;

public class ButtonHandler {
	private final GaspriceView2 mainView;
	private final PricePointRepository repository;
	private final LoadingPanel loadingPanel;
	private ArrayList<ArrayList<PricePoint>> data = new ArrayList<ArrayList<PricePoint>>();
	
	/**
	 * @param mv
	 * @param m
	 * @param lS 
	 */
	public ButtonHandler(GaspriceView2 mv, PricePointRepository m, LoadingPanel lS, mainPanel mainPanel) {
		mainView = mv;
		repository = m;
		loadingPanel = lS;
		data.add(repository.getDataForMarked("TTF"));
		lS.setProgress();
		data.add(repository.getDataForMarked("Zeebrugge"));
		lS.setProgress();
		data.add(repository.getDataForMarked("Gaspool"));
		lS.setProgress();
		data.add(repository.getDataForMarked("NCG"));
		lS.setProgress();
		mainView.draw(data);
		mainPanel.loadingIsDone(data);
	}
}