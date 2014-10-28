package com.hysd.domain2;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 客户（注解实体类）
 */
@Entity
@Table(name = "tb_customer2")
public class Customer2 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id; // 客户ID（主键）
	private String name; // 客户姓名

	// Constructors

	/** default constructor */
	public Customer2() {
	}

	/** full constructor */
	public Customer2(String name) {
		this.name = name;
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

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}