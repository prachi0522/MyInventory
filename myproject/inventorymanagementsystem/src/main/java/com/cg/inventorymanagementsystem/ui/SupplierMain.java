package com.cg.inventorymanagementsystem.ui;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.PropertyConfigurator;

import com.cg.inventorymanagementsystem.exceptions.IMSException;
import com.cg.inventorymanagementsystem.model.Order;
import com.cg.inventorymanagementsystem.model.Product;
import com.cg.inventorymanagementsystem.service.ISupplierService;
import com.cg.inventorymanagementsystem.service.SupplierService;

public class SupplierMain {

	public static void main(String args[]) {

		PropertyConfigurator.configure("src/main/resource/log4j.properties");
		Scanner scanner = null;
		String reChoice = "";

		do {
			// scanner = new Scanner(System.in);
			System.out.println(" *** Welcome Supplier *** ");
			System.out.println("1.View My Orders");
			System.out.println("2.Show All Products");
			System.out.println("3.Exit");

			int choice = 0;
			boolean choiceFlag = false;

			ISupplierService service = new SupplierService();

			do {
				scanner = new Scanner(System.in);
				System.out.println("select your choice:");

				try {
					choice = scanner.nextInt();
					choiceFlag = true;

					switch (choice) {

					case 1:

						System.out.println("Enter any of the supplier id present in order table");
						scanner = new Scanner(System.in);
						int myOrder = scanner.nextInt();
						try {
							List<Order> order = service.getMyOrders(myOrder);
							for (Order data : order) {
								System.out.println(data);
							}

						} catch (IMSException e1) {
							System.err.println(e1.getMessage());
						}
						break;

					case 2:
						System.out.println("Enter any of the product id present in product table");
						scanner = new Scanner(System.in);
						int myProduct = scanner.nextInt();
						try {
							List<Product> orders = service.getAllProducts(myProduct);

							for (Product data : orders) {
								System.out.println(data);
							}

						} catch (IMSException e) {
							System.out.println(e.getMessage());
						}
						break;

					case 3:
						System.out.println("Thank you");
						System.exit(0);

					default:
						choiceFlag = false;
						System.out.println("Input should be in the range of 1-3");
						break;

					}

				} catch (InputMismatchException e) {
					choiceFlag = false;
					System.err.println("Input should contain only digits");

				}

			} while (!choiceFlag);

			System.out.println("do you want to continue? (yes/no)");
			reChoice = scanner.next();

		} while (reChoice.equalsIgnoreCase("yes"));

		scanner.close();
	}
}