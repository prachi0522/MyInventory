package com.cg.inventorymanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.cg.inventorymanagementsystem.exceptions.IMSException;
import com.cg.inventorymanagementsystem.model.Order;
import com.cg.inventorymanagementsystem.model.Product;
import com.cg.inventorymanagementsystem.utility.JPAUtility;

public class SupplierDao implements ISupplierDao {

	EntityManagerFactory factory = null;
	EntityManager manager = null;
	EntityTransaction transaction = null;

	private Logger logger = Logger.getLogger(SupplierDao.class);

	@Override
	public List<Product> getAllProducts(int productId) throws IMSException {
		logger.info("product id is: " + productId);
		factory = JPAUtility.getEntityManagerFactory();
		logger.info("factory created");
		manager = factory.createEntityManager();
		logger.info("manager created");
		Query query = manager.createQuery(QueryConstants.GET_PRODUCTS);
		return query.getResultList();
	}

	@Override
	public List<Order> viewMyOrders(int orderId) throws IMSException {

		logger.info("order id is: " + orderId);
		factory = JPAUtility.getEntityManagerFactory();
		manager = factory.createEntityManager();

		Query query = manager.createQuery(QueryConstants.GET_ORDERS);
		return query.getResultList();

	}

}