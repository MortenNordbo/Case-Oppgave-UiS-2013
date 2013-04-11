package model;

public class PricePointModel {

	public static double next(double old_price) {
		double volatility = 0.05;
		double rnd = Math.random();
		double change_percent = 2 * volatility * rnd;
		if (change_percent > volatility)
			change_percent -= (2 * volatility);
		double change_amount = old_price * change_percent;
		double new_price = old_price + change_amount;
		old_price = new_price;
		return new_price;
	}

	public static void main(String[] args) {
		double start = 4;
		for (int i = 0; i < 200; i++) {
			double newV = next(start);
			System.out.println(newV);
			start = newV;
		}
	}
}
