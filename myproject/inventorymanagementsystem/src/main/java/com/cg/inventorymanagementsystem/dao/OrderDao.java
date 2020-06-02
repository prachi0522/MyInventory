package com.cg.inventorymanagementsystem.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.swing.text.DateFormatter;

import org.apache.log4j.Logger;

import com.cg.inventorymanagementsystem.exceptions.IMSException;
import com.cg.inventorymanagementsystem.model.Order;
import com.cg.inventorymanagementsystem.model.Suppliers;
import com.cg.inventorymanagementsystem.ui.OrderMain;
import com.cg.inventorymanagementsystem.utility.JPAUtility;

public class OrderDao implements IOrderDao {

	private Logger logger = Logger.getLogger(OrderDao.class);
	Scanner sc = new Scanner(System.in);
	EntityManagerFactory factory = null;
	EntityManager manager = null;
	EntityTransaction transaction = null;

	@Override
	public int addOrders(Order orderId) {
     // Order order1=null;
		int orderId1 = 0;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			
			try {
				transaction.begin();
				manager.persist(orderId);
				System.out.println("Record Inserted Successfully......");
				transaction.commit();
				orderId1 = orderId.getOrderId();
				logger.info("id generated " + orderId1);

			} catch (PersistenceException e) {
				System.out.println("order id already present in the list.......");
			}
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		return orderId1;
	}

	@Override
	public List<Order> getAllOrders() throws IMSException {
		logger.info("in get all orders method");
		factory = JPAUtility.getEntityManagerFactory();
		logger.info("factory created");
		manager = factory.createEntityManager();
		logger.info("manager created");
		Query query = manager.createQuery(QueryConstants.GET_ORDERS);
		return query.getResultList();
	}

	@Override
	public Order setProcessDate(int orderId) throws IMSException {
		Order order = null;
		try {
			factory = JPAUtility.getEntityManagerFactory();
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			order = manager.find(Order.class, orderId);

			String date = null;
			boolean dateFlag = false;
			LocalDate localDate = null;
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter process date(yyyy-MM-dd)for perticular id");

			logger.info("Enter process date(yyyy-MM-dd)for perticular id");

			date = scanner.next();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			try {
				localDate = LocalDate.parse(date, formatter);
				dateFlag = true;
			} catch (DateTimeParseException e) {
				dateFlag = false;
				logger.error("date should be in the format of yyyy-MM-dd");
			}
			if (order == null) {
				logger.error("no product present");
				throw new IMSException("no order present with the given id");

			}
			order.setExpectedDateOfDelivery(date);
			logger.info("process date has been set");
			transaction.commit();

		} catch (IMSException e1) {
			e1.getMessage();
			transaction.rollback();
		}
		return order;

	}

	@Override

	public List<Suppliers> showSupplierDetails() throws IMSException {
		logger.info("in get all orders method");
		factory = JPAUtility.getEntityManagerFactory();
		logger.info("factory created");
		manager = factory.createEntityManager();
		logger.info("manager created");
		Query query = manager.createQuery(QueryConstants.GET_SUPPLIERS);
		return query.getResultList();
	}

}
