package repository;

import java.util.ArrayList;

import model.Entities.PricePoint;
import us.monoid.json.JSONArray;
import us.monoid.json.JSONObject;
import us.monoid.web.JSONResource;
import us.monoid.web.Resty;

public class PricePointRepository {

	/**
	 * @param market
	 * @return
	 */
	public ArrayList<PricePoint> getDataForMarked(String market) {
		ArrayList<PricePoint> pricePoints = new ArrayList<PricePoint>();
		Resty r = new Resty();
		try {
			JSONResource s = r
					.json("http://bid110.azurewebsites.net/" + market);
			JSONArray objectArray = s.array();
			for (int i = 0; i < objectArray.length(); i++) {
				JSONObject jObject = objectArray.getJSONObject(i);
				PricePoint p = new PricePoint();
				p.setId(jObject.getInt("Id"));
				p.setEsid(jObject.getString("Esid"));
				p.setObservationDate(jObject.getInt("Observationdate"));
				p.setObservationTime(jObject.getInt("ObservationTime"));
				p.setPrice(jObject.getDouble("Price"));
				p.setUnit(jObject.getString("Unit"));
				pricePoints.add(p);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pricePoints;
	}
}
