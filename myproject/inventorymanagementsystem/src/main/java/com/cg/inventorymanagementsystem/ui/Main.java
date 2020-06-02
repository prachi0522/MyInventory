package com.cg.inventorymanagementsystem.ui;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.inventorymanagementsystem.exceptions.IMSException;
import com.cg.inventorymanagementsystem.model.Order;
import com.cg.inventorymanagementsystem.model.Suppliers;
import com.cg.inventorymanagementsystem.service.IOrderService;
import com.cg.inventorymanagementsystem.service.OrderService;

public class Main {

	public static void main(String args[]) throws IMSException {

		PropertyConfigurator.configure("src/main/resource/log4j.properties");
		Scanner scanner = null;
		String reChoice = "";
		Logger log = Logger.getLogger(Order.class);
		do {
			// scanner = new Scanner(System.in);
			System.out.println(" *** Welcome Order *** ");
			System.out.println("1.Add Order");
			System.out.println("2.Update Order");
			System.out.println("3.Show Order Details");
			System.out.println("4.Show Supplier Details");
			System.out.println("5.Exit");

			int choice = 0;
			boolean choiceFlag = false;
			IOrderService service = new OrderService();
			int orderId;

			do {
				scanner = new Scanner(System.in);
				System.out.println("select your choice:");

				try {
					choice = scanner.nextInt();
					choiceFlag = true;

					switch (choice) {

					case 1:
						Order order = OrderMain.addOrder();
						try {
							int orderId1= service.addOrders(order);
							System.out.println("order inserted with the given id: " + orderId1);
						} catch (IMSException e) {
							System.err.println(e.getMessage());
						}
						break;

					case 2:
						System.out.println("enter order id ");
						// log.info("Enter order id to set the process date");
						orderId = scanner.nextInt();
						Order setOrder;
						try {
							setOrder = service.setProcessDate(orderId);
							System.out.println("the process date has been set to orderId :" + orderId);
							// log.info("the process date has been set to orderId"+orderId);
							log.info("-------------------");
						} catch (IMSException e) {
							System.err.println(e.getMessage());
						}
						break;

					case 3:
						try {
							List<Order> orders = service.getAllOrders();

							for (Order data : orders) {
								System.out.println(data);
							}

						} catch (IMSException e) {
							System.out.println(e.getMessage());
						}
						break;

					case 4:

						try {
							List<Suppliers> suppliers = service.showSupplierDetails();

							for (Suppliers data : suppliers) {
								System.out.println(data);
							}

						} catch (IMSException e) {
							System.out.println(e.getMessage());
						}
						break;

					case 5:
						System.out.println("thank you");
						System.exit(0);

					default:
						choiceFlag = false;
						System.out.println("Input should be in the range of 1-6");
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
