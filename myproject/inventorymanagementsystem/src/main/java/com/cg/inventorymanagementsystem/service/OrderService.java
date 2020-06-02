package com.cg.inventorymanagementsystem.service;

import java.util.List;
import java.util.regex.Pattern;

import com.cg.inventorymanagementsystem.dao.IOrderDao;
import com.cg.inventorymanagementsystem.dao.OrderDao;
import com.cg.inventorymanagementsystem.exceptions.IMSException;
import com.cg.inventorymanagementsystem.model.Order;
import com.cg.inventorymanagementsystem.model.Suppliers;

public class OrderService implements IOrderService {

	IOrderDao manufacturerDao = new OrderDao();

	@Override
	public boolean validateName(String name) throws IMSException {

		boolean nameFlag = false;
		String nameRegEx = "[A-Z]{1}[A-Za-z\\s]{4,19}";

		if (Pattern.matches(nameRegEx, name)) {
			nameFlag = true;
		} else {
			throw new IMSException("First letter should be capital and length must be in the range of 5 to 20");
		}
		return nameFlag;

	}

	@Override
	public boolean validateCost(double price) throws IMSException {

		boolean costFlag = false;

		if (price > 0) {
			costFlag = true;
		} else {
			throw new IMSException("cost should be greater than 0");
		}

		return costFlag;
	}

	@Override
	public boolean validateUnits(int units) throws IMSException {

		boolean unitsFlag = false;

		if (units > 2) {
			unitsFlag = true;
		} else {
			throw new IMSException("units should be greater than 2");
		}

		return unitsFlag;
	}

	@Override
	public boolean validateId(int id) throws IMSException {

		boolean idFlag = false;

		if (id > 0) {
			idFlag = true;
		} else {
			throw new IMSException("id should contain only digits");
		}

		return idFlag;
	}

	@Override
	public List<Order> getAllOrders() throws IMSException {

		return manufacturerDao.getAllOrders();
	}

	@Override
	public List<Suppliers> showSupplierDetails() throws IMSException {

		return manufacturerDao.showSupplierDetails();
	}

	@Override
	public int addOrders(Order orderId) throws IMSException {
		return manufacturerDao.addOrders(orderId);

	}

	@Override
	public Order setProcessDate(int orderId) throws IMSException {
		return manufacturerDao.setProcessDate(orderId);
	}

}
