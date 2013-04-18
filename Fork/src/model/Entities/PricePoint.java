package model.Entities;

public class PricePoint {
	private int Id;
	private String Esid;
	private int ObservationDate;
	private int ObservationTime;
	private String Unit;
	private double Price;

	/**
	 * 
	 */
	public PricePoint() {

	}

	/**
	 * @param id
	 * @param esid
	 * @param observationDate
	 * @param observationTime
	 * @param unit
	 * @param price
	 */
	public PricePoint(int id, String esid, int observationDate,
			int observationTime, String unit, double price) {
		Id = id;
		Esid = esid;
		ObservationDate = observationDate;
		ObservationTime = observationTime;
		Unit = unit;
		Price = price;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getEsid() {
		return Esid;
	}

	public void setEsid(String esid) {
		Esid = esid;
	}

	public int getObservationDate() {
		return ObservationDate;
	}

	public void setObservationDate(int observationDate) {
		ObservationDate = observationDate;
	}

	public int getObservationTime() {
		return ObservationTime;
	}

	public void setObservationTime(int observationTime) {
		ObservationTime = observationTime;
	}

	public String getUnit() {
		return Unit;
	}

	public void setUnit(String unit) {
		Unit = unit;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	@Override
	public String toString() {
		return "PricePoint [Id=" + Id + ", Esid=" + Esid + ", ObservationDate="
				+ ObservationDate + ", ObservationTime=" + ObservationTime
				+ ", Unit=" + Unit + ", Price=" + Price + "]";
	}

}
