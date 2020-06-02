package com.cg.inventorymanagementsystem.dao;

import java.util.List;

import com.cg.inventorymanagementsystem.exceptions.IMSException;
import com.cg.inventorymanagementsystem.model.Order;
import com.cg.inventorymanagementsystem.model.Product;

public interface ISupplierDao {

	public List<Product> getAllProducts(int productId) throws IMSException;

	public List<Order> viewMyOrders(int orderId) throws IMSException;

}
