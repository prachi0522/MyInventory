package com.cg.inventorymanagementsystem.service;

import java.util.List;

import com.cg.inventorymanagementsystem.exceptions.IMSException;
import com.cg.inventorymanagementsystem.model.Order;
import com.cg.inventorymanagementsystem.model.Suppliers;

public interface IOrderService {

	public boolean validateName(String name) throws IMSException;

	public boolean validateCost(double salary) throws IMSException;

	public int addOrders(Order orderId) throws IMSException;

	public boolean validateUnits(int units) throws IMSException;

	public List<Order> getAllOrders() throws IMSException;

	public List<Suppliers> showSupplierDetails() throws IMSException;

	public boolean validateId(int id) throws IMSException;

	public Order setProcessDate(int orderId) throws IMSException;

}
