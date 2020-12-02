package simulator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Customer {

	private String name;
	private List<Product> purchasedProducts;


	public Customer(String name, List<Product> purchasedProducts) {
		super();
		this.name = name;
		this.purchasedProducts = purchasedProducts;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Product> getPurchasedProducts() {
		return purchasedProducts;
	}
	public void setPurchasedProducts(List<Product> purchasedProducts) {
		this.purchasedProducts = purchasedProducts;
	}



}


class Product {

	private String name;
	private double price;
	private int quantity;



	public Product(String name, double price, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


}


public class Simulator {

	
	public static void main(String[] args) {
		System.out.println("Welcome to cobis convenience !!");
		
		List<Product> products = new ArrayList<>();
		
		products.add(new Product("Red-Hot Spicy Doritos", 2.99, 0));
		products.add(new Product("Cool Ranch Doritos", 2.99, 0));
		products.add(new Product("Coke", 0.99, 0));
		products.add(new Product("Diet Coke", 0.99, 0));
		products.add(new Product("Pepsi", 0.99, 0));
		products.add(new Product("Five Hour Energy", 0.99, 0));
		products.add(new Product("Sunflower Seeds", 3.99, 0));
		products.add(new Product("Peanuts", 0.99, 0));
		products.add(new Product("Mac Book Chargers", 120, 0));
		products.add(new Product("Dell Chargers", 50, 0));
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Products in store: ");
		printMenu(products);
		
		int option=-100;

		while(option!=0) {
			   
			   System.out.println("Enter a customer name\n");
			   scanner.next();
			   String customerName= scanner.nextLine();
			   Customer customer = new Customer(customerName, new ArrayList<>());

			   while(option!=100) {
				   
				System.out.println("Select a product: ");
				   printMenu(products);
				   option= scanner.nextInt();
				   
				   if(option>0 && option<=products.size()) {
					   customer.getPurchasedProducts().add(products.get(option-1));
					   products.get(option-1).setQuantity(products.get(option-1).getQuantity()+1);
				   }else {
					   System.out.println("Invalid item entered");
				   }
				
			   }
			   
			   System.out.println("\n\n");
			   System.out.println(customer.getName());
			   double total = 0.0;
			   for(Product product:customer.getPurchasedProducts()) {
				   System.out.println(product.getName());
				   total=total+product.getPrice();
			   }
			   System.out.println(total+"\n\n");   
			   
			   System.out.println("Want to close press 0 to close 200 to continue");
			   option = scanner.nextInt();
			   
		}
		
		System.out.println("\n\nInventory sold");
		double grandTotal=0.0;
		for(Product product:products) {
			System.out.println(product.getName()+ " ("+ product.getQuantity()+ ")");
			grandTotal=grandTotal+product.getPrice()*product.getQuantity();
		}
		System.out.println("Grand Total "+grandTotal);
		scanner.close();
	 
	}
	
	
	public static void  printMenu(List<Product> products) {
		
	
		for(int i=0;i<products.size();i++) {
			System.out.println(i+1+ ") "+ products.get(i).getName()+ " "+ products.get(i).getPrice());
		}
		
		System.out.println("Enter 100 to do total");
		
	}
}
