package hooks;

import java.util.ArrayList;

import model.Entities.PricePoint;

/**
 * @author 215686
 *
 */
public class GetHighLow {
	
	/**
	 * @param data4
	 * @return
	 */
	public PricePoint getHighest(ArrayList<ArrayList<PricePoint>> data4) 
	{
		PricePoint highestTemp = new PricePoint();
		for(int i = 0; i < data4.size();i++)
		{
			for (int j = 0; j < data4.get(i).size(); j++)
			{
				if(data4.get(i).get(j).getPrice() > highestTemp.getPrice())
				{
					highestTemp = data4.get(i).get(j);
				}
			}
		}
		return highestTemp;
	}
	
	/**
	 * @param data5
	 * @return
	 */
	public PricePoint getLavest(ArrayList<ArrayList<PricePoint>> data5) 
	{
		PricePoint lowestTemp = new PricePoint();
		lowestTemp.setPrice(100);
		for(int i = 0; i < data5.size();i++)
		{
			for (int j = 0; j < data5.get(i).size(); j++)
			{
				if(data5.get(i).get(j).getPrice() < lowestTemp.getPrice())
				{
					lowestTemp = data5.get(i).get(j);
				}
			}
		}
		return lowestTemp;
	}
}
