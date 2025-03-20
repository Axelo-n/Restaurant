package restaurant;

import java.util.HashMap;

public class Menu {
	private String name;
	private HashMap<String, Food> foodList = new HashMap<>();

	public Menu(String name) {
		this.name = name;
	}

	public void add(Food food) {
		foodList.put(food.getName(), food);
		System.out.println(food.getName()+" is added to the "+name+" section.");
	}

	public String getName() {
		return name;
	}

	public Food find(String name) {
		for(Food food: foodList.values()) {
			if(food.getName().equals(name)) return food;
		}
		return null;
	}
	
	
}
