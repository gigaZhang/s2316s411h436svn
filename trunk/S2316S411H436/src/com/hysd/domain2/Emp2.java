package com.hysd.domain2;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 雇员或员工（注解实体类）
 */
@Entity
@Table(name = "tb_emp2")
public class Emp2 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer empno; // 雇员编号（主键）
	private String ename; // 雇员姓名
	private String job; // 工作
	private Integer mgr; // 上级雇员的编号
	private Date hiredate; // 入职日期
	private Double sal; // 薪水
	private Double comm; // 奖金
	private Integer deptno; // 部门编号

	// Constructors

	/** default constructor */
	public Emp2() {
	}

	/** minimal constructor */
	public Emp2(Integer empno) {
		this.empno = empno;
	}

	/** full constructor */
	public Emp2(Integer empno, String ename, String job, Integer mgr,
			Date hiredate, Double sal, Double comm, Integer deptno) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}

	// Property accessors
	@Id
	@Column(name = "empno", unique = true, nullable = false)
	public Integer getEmpno() {
		return this.empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	@Column(name = "ename", length = 50)
	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	@Column(name = "job", length = 50)
	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Column(name = "mgr")
	public Integer getMgr() {
		return this.mgr;
	}

	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "hiredate", length = 0)
	public Date getHiredate() {
		return this.hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	@Column(name = "sal", precision = 22, scale = 0)
	public Double getSal() {
		return this.sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	@Column(name = "comm", precision = 22, scale = 0)
	public Double getComm() {
		return this.comm;
	}

	public void setComm(Double comm) {
		this.comm = comm;
	}

	@Column(name = "deptno")
	public Integer getDeptno() {
		return this.deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

}