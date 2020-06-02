
package com.cg.inventorymanagementsystem.service;

import java.util.List;

import com.cg.inventorymanagementsystem.exceptions.IMSException;
import com.cg.inventorymanagementsystem.model.Order;
import com.cg.inventorymanagementsystem.model.Product;

public interface ISupplierService {

	public boolean validateName(String name) throws IMSException;

	public boolean validateCost(double salary) throws IMSException;

	public boolean validateUnits(int units) throws IMSException;

	public List<Product> getAllProducts(int productId) throws IMSException;

	public List<Order> getMyOrders(int orderId) throws IMSException;

}
