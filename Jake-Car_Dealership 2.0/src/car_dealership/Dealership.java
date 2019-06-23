package car_dealership;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dealership {
	
	public static ArrayList<Vehicle> theVehicleList;

	public static void main(String[] args) throws FileNotFoundException {
		String import_make = null;
		String import_model = null;
		Double import_price = 0.0;
		int import_year = 0;
		
		theVehicleList = new ArrayList<Vehicle>(); 
		
		Customer cust1 = new Customer();
		cust1.setName("Tom");
		cust1.setAddress("123 blank street");
		cust1.setCashOnHand(250000);
		
		//Car List Scanner
		int line_count = 0;
		File file = new File("Car_Inventory.txt");
		Scanner input;
		input = new Scanner(file);
		while(input.hasNextLine()) {
			String line = input.nextLine();
			line_count += 1;
			if(line_count != 5) {
				if(line_count == 1) {import_make = line;}
				if(line_count == 2) {import_model = line;}
				if(line_count == 3) {import_price = Double.parseDouble(line);}
				if(line_count == 4) {import_year = Integer.parseInt(line);}
			}else{
				theVehicleList.add(new Vehicle(import_make,import_model, import_price,import_year));
				line_count=0;
			}	
		}
		input.close();
		
		Employee emp = new Employee();
		
		Vehicle desired_car = new Vehicle("BMW", "M3", 0, 2017);
		dealerCheck(desired_car, emp, cust1);
		dealerCheck(desired_car, emp, cust1);
		for (Vehicle d : theVehicleList)
		{
			System.out.println(d.getMake());
		}
		
	}
	public static void  dealerCheck(Vehicle car, Employee emp, Customer customer) {
		boolean instock = emp.searchInventory(car);
		if(instock == true) {
			customer.purchaseCar(car, emp, false);
		}
		if(instock == false) {
			System.out.println("Sorry we dont have that one");
		}
	}
}
