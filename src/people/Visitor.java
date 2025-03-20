package people;

import helper.Format;

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
		System.out.println("\n"+name+" spent in total "+Format.formatIDR(totalPrice));
	}

	public String getName() {
		return name;
	}
	
}
