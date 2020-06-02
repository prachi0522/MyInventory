package com.cg.inventorymanagementsystem.model;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Suppliers")
public class Suppliers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "supplier_id")
	private Integer supplierId;
	@Column(name = "supplier_name")
	private String supplierName;
	@Column(name = "address")
	private String address;
	@Column(name = "phone_no")
	private Long phoneNo;

	@OneToOne(cascade=CascadeType.ALL,mappedBy="supplier")
//	@JoinColumn(name="supplier_id")
	private Order order;
//	
	public Suppliers() {

	}

	public Suppliers(Integer supplierId, String supplierName, String address, Long phoneNo) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.address = address;
		this.phoneNo = phoneNo;
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "Suppliers [supplierId=" + supplierId + ", supplierName=" + supplierName + ", address=" + address
				+ ", phoneNo=" + phoneNo + "]";
	}

}
