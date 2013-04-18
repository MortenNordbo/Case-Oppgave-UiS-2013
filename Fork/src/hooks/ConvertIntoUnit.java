package hooks;

import java.util.ArrayList;

import model.Entities.PricePoint;

public class ConvertIntoUnit {

	public ConvertIntoUnit()
	{
		
	}

	/**
	 * @param arrayList
	 * @return
	 */
	public ArrayList<PricePoint> ConvertThis(ArrayList<PricePoint> arrayList) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arrayList.size(); i++)
		{
			arrayList.get(i).setUnit("€/MWh");
			arrayList.get(i).setPrice(arrayList.get(i).getPrice()*0.4d);
		}
		return arrayList;
	}

}
