package main;

import restaurant.Restaurant;
import restaurant.Food;
import restaurant.Menu;
import people.Chef;
import people.Visitor;
import java.text.NumberFormat;
import java.util.Locale;

public class Main {

	public static void main(String[] args) {	
		Restaurant restaurant = new Restaurant("Rumah Sambal");
		
		Chef chef1 = new Chef("Bintang");
		Chef chef2 = new Chef("Sawitri");
		
		restaurant.addChef(chef1);
		restaurant.addChef(chef2);
		
		// hanya supaya output lebih rapi
		System.out.println();
		Visitor visitor1 = new Visitor("Ebednezer");
		Visitor visitor2 = new Visitor("Granite");
		
		Menu mainCourse = new Menu("Main Course");
		
		mainCourse.add(new Food("Nasi Bakar", 30000));
		mainCourse.add(new Food("Nasi Goreng", 230000));
		mainCourse.add(new Food("Mie Goreng", 20000));
		mainCourse.add(new Food("Udang Emas", 999000));
		
		restaurant.addMenu(mainCourse);
		
		Menu dessert = new Menu("Dessert");
		
		dessert.add(new Food("Ice Cream", 1000));
		dessert.add(new Food("Es Pisang Ijo", 23000));
		dessert.add(new Food("Jus Emas", 999000));
		
		restaurant.addMenu(dessert);
		
		restaurant.showMenu();
		restaurant.showChef();
		
		restaurant.order(chef1, visitor1, "Nasi Bakar", 2);
		restaurant.order(chef1, visitor1, "Jus Emas", 2);
		
		restaurant.order(chef2, visitor2, "Udang Emas", 9);
		restaurant.order(chef2, visitor2, "Ice Cream", 90);
		
		// hanya supaya output lebih rapi
		System.out.println();
		visitor1.showTotalPrice();
		visitor2.showTotalPrice();
		
		// hanya supaya output lebih rapi
		System.out.println();
		chef1.showCookHistory();
		chef2.showCookHistory();
		
		restaurant.showTotalIncome();
	}
	
	// Helper method to format currency in IDR 

    @SuppressWarnings("deprecation")
	public static String formatIDR(int amount) { 
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("id", "ID")); 
        return formatter.format(amount); 
    } 
}
