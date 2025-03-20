package people;

import main.Main;

public class Visitor {
	private String name;
	private int totalPrice = 0;

	public Visitor(String name) {
		this.name = name;
	}

	public void addTotalPrice(int amount) {
		totalPrice += amount;
	}
	
	public void showTotalPrice() {
		System.out.println(name+" spent in total "+Main.formatIDR(totalPrice));
	}

	public String getName() {
		return name;
	}
	
}
