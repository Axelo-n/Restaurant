package restaurant;

import java.util.ArrayList;

import helper.Format;
import people.Chef;
import people.Visitor;

public class Restaurant {
	private String name;
	private int totalIncome = 0;
	private ArrayList<Menu> menuList = new ArrayList<>();
	private ArrayList<Chef> chefList = new ArrayList<>();
	
	public Restaurant(String name) {
		this.name = name;
		System.out.println(name+" is now open!\n");
	}

	public void addChef(Chef chef) {
		chefList.add(chef);
		System.out.println("Chef "+chef.getName()+" is hired at "+name+"\n");
	}

	public void addMenu(Menu menu) {
		menuList.add(menu);
		System.out.println("a "+menu.getName()+" section is now on the menu.\n");
	}

	public void showMenu() {
		System.out.println("Available Menus:");
		for(Menu menu : menuList) {
			System.out.println("  - "+menu.getName());
			menu.showFoods();
		}
		System.out.println();
	}

	public void showChef() {
		System.out.println("Available Chefs:");
		for(Chef chef: chefList) {
			System.out.println("  - Chef "+chef.getName());
		}
		System.out.println();
	}
	
	public Food getFood(String name) {
		Food search = null;
		for(Menu menu: menuList) {
			search = menu.find(name);
			if(search != null) break;
		}
		return search;
	}

	public void order(Chef chef, Visitor visitor, String dish, int amount) {
		chef.addCookHistory("Cooked "+amount+" portions of "+dish+" for "+visitor.getName()+".");
		Food food = getFood(dish);
		visitor.addTotalPrice(food.getPrice()*amount);
		totalIncome += food.getPrice()*amount;
		System.out.println("Chef "+chef.getName()+" cooked "+amount+" portions of "+dish+" for "+visitor.getName()+".");
	}

	public void showTotalIncome() {
		System.out.println();
		System.out.println(name+" gained in total "+Format.formatIDR(totalIncome));
	}

	
	
}
