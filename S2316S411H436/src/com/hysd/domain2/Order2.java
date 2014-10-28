package com.hysd.domain2;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 订单（注解实体类）
 */
@Entity
@Table(name = "tb_order2")
public class Order2 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id; // 订单ID（主键）
	private String orderNumber; // 订单号
	private Integer customerId; // 所属客户ID

	// Constructors

	/** default constructor */
	public Order2() {
	}

	/** full constructor */
	public Order2(String orderNumber, Integer customerId) {
		this.orderNumber = orderNumber;
		this.customerId = customerId;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "ordernumber", length = 50)
	public String getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	@Column(name = "customer_id")
	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

}