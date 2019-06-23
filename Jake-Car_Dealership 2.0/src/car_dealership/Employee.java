package car_dealership;

public class Employee extends Dealership {

	public void handleCustomer(Customer cust, boolean finance, Vehicle vehicle) {
		if(finance == true) {
			double loanAmount = vehicle.getPrice() - cust.getCashOnHand();
			runCreditHistory(cust, loanAmount);
		}else if(vehicle.getPrice() <= cust.getCashOnHand()){
			// customer pays in cash
			processTransaction(cust, vehicle);
		}else {
			System.out.println(" Customer will need more money to purchase vehicle: " + vehicle);
		}
	}
	
	public boolean searchInventory(Vehicle car) {
		for (Vehicle d : theVehicleList)
		{
			if(car.getMake().equals(d.getMake()) && car.getModel().equals(d.getModel()) && car.getYear()== d.getYear())  {
				car.setPrice(d.getPrice());
				//System.out.println("Gottem");
				return true;
			}
		}
		return false;
	}
	
	public void runCreditHistory(Customer cust, double loanAmount) {
		System.out.println("Ran credit history for Customer...");
		System.out.println("Customer has been approved to purchase the vehicle");
	}
	public void processTransaction(Customer cust, Vehicle vehicle) {
		System.out.println("Customer has purchased the vehicle: " 
	+ vehicle + " for the price " + vehicle.getPrice());
		theVehicleList.remove(vehicle);
	}
}
