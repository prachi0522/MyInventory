package com.cg.inventorymanagementsystem.dao;

import java.util.List;

import com.cg.inventorymanagementsystem.exceptions.IMSException;
import com.cg.inventorymanagementsystem.model.Order;
import com.cg.inventorymanagementsystem.model.Suppliers;

public interface IOrderDao {

	public int addOrders(Order orderId) throws IMSException;

	public List<Order> getAllOrders() throws IMSException;

	public Order setProcessDate(int orderId) throws IMSException;

	public List<Suppliers> showSupplierDetails() throws IMSException;

}
