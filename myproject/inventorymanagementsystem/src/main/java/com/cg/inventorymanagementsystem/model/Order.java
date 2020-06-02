package com.cg.inventorymanagementsystem.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Integer orderId;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "order_date")
	private String orderDate;
	@Column(name = "units")
	private Integer units;
	@Column(name = "price_per_units")
	private Double pricePerUnit;
	@Column(name = "expected_date_of_delivery")
	private String expectedDateOfDelivery;
	//@Column(name = "supplier_id")
	//private Integer supplierId;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="supplier_id")
	private Suppliers supplier; 

	public Order() {

	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getUnits() {
		return units;
	}

	public void setUnits(Integer units) {
		this.units = units;
	}

	public Double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(Double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public String getExpectedDateOfDelivery() {
		return expectedDateOfDelivery;
	}

	public void setExpectedDateOfDelivery(String expectedDateOfDelivery) {
		this.expectedDateOfDelivery = expectedDateOfDelivery;
	}

	public Suppliers getSupplier() {
		return supplier;
	}

	public void setSupplier(Suppliers supplier) {
		this.supplier = supplier;
	}

	public Order(Integer orderId, String productName, String orderDate, Integer units, Double pricePerUnit,
			String expectedDateOfDelivery) {
		super();
		this.orderId = orderId;
		this.productName = productName;
		this.orderDate = orderDate;
		this.units = units;
		this.pricePerUnit = pricePerUnit;
		this.expectedDateOfDelivery = expectedDateOfDelivery;
		//this.supplier = supplier;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productName=" + productName + ", orderDate=" + orderDate + ", units="
				+ units + ", pricePerUnit=" + pricePerUnit + ", expectedDateOfDelivery=" + expectedDateOfDelivery
				+  "]";
	}

}