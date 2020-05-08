package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;


public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter cliente data:");
		System.out.println("Name: " );
		String name = sc.nextLine();
		System.out.println("Email: " );
		String email = sc.nextLine();
		System.out.println("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next()); // captura a data
		
		//instanciar o objeto client
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data: ");
		System.out.println("Status: ");
		
		//instanciar o objeto ENUMS status , ultiliza o método valueOf 
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		//intanciar o objeto order POIS JA TENHO O DATE O STATUS E OS ATRIBUTOS DO OBJETO CLIENT
		Order order = new Order(new Date(), status, client);
		
		System.out.println("How many items to this order? ");
								
		int n = sc.nextInt();
		
		for (int i = 1 ; i <= n; i++) {
		System.out.println("Enter #" + i + " item data:");
		sc.nextLine();
		
		System.out.println("Product NAME: ");
		String productName = sc.nextLine();
				
		System.out.println("Product PRICE: ");
		double productPrice = sc.nextDouble();
		
		Product product = new Product(productName, productPrice);
		
		System.out.println("QUANTITY: ");
		int quantity = sc.nextInt();
		
		OrderItem orderItem = new OrderItem(quantity, productPrice, product);
		
		//ADICIONA O ITEM
		order.addItem(orderItem);
		
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		 
		
		
		
		sc.close();
	}

}
