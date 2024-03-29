package com.hysd.crud;

import java.io.Serializable;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hysd.domain.Customer;
import com.hysd.util.HibernateUtils;

/**
 * 测试最基本的增删改查
 */
public class TestCRUD {

	// 添加（如果测试没通过，请检查一下主键生成策略）
	@Test
	public void test_save() {

		Customer customer = new Customer();
		customer.setName("monday#test_save");

		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Serializable id = session.save(customer); // 返回OID
		tx.commit();
		session.close();
		System.out.println("id=" + id);
	}

	// 添加（如果测试没通过，请检查一下主键生成策略）
	@Test
	public void test_persist() {
		Customer customer = new Customer();
		customer.setName("monday#test_persist");

		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(customer); // 无返回值
		tx.commit();
		session.close();
	}

	// 添加（如果测试没通过，请检查一下主键生成策略）
	@Test
	public void test_saveOrUpdate1() {
		Customer customer = new Customer();
		customer.setName("monday#test_saveOrUpdate1");

		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(customer); // OID 为空 执行save操作
		tx.commit();
		session.close();
	}

	// 修改（如果测试没通过，请检查一下主键生成策略，同时检查数据库是否已经存在这条记录）
	// 因为与其他测试方法存在冲突，需要独立测试（请先注释其他测试方法），测试才会通过
	@Test
	public void test_saveOrUpdate2() {
		Customer customer = new Customer();
		customer.setName("monday#test_saveOrUpdate2");
		customer.setId(5);

		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(customer); // OID 为不空 执行update操作
		tx.commit();
		session.close();
	}

	// 修改（如果测试没通过，请检查数据库是否已经存在这条记录）
	// 因为与其他测试方法存在冲突，需要独立测试（请先注释其他测试方法），测试才会通过
	@Test
	public void test_update() {
		Customer customer = new Customer();
		customer.setName("monday#test_update");
		customer.setId(5);

		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(customer);
		tx.commit();
		session.close();
	}

	// 修改（如果测试没通过，请检查数据库是否已经存在这条记录）
	// 因为与其他测试方法存在冲突，需要独立测试（请先注释其他测试方法），测试才会通过
	@Test
	public void test_update_hql() {
		String hql = "update Customer set name=? where id=?";
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter(0, "monday#test_update_hql");
		query.setParameter(1, 5);
		query.executeUpdate();
		tx.commit();
		session.close();
	}

	// 删除（如果测试没通过，请检查数据库是否已经存在这条记录）
	// 因为与其他测试方法存在冲突，需要独立测试（请先注释其他测试方法），测试才会通过
	@Test
	public void test_delete() {
		Customer customer = new Customer();
		customer.setId(5);

		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(customer);
		tx.commit();
		session.close();
	}

	// 删除（如果测试没通过，请检查数据库是否已经存在这条记录）
	@Test
	public void test_delete_hql() {
		String hql = "delete from Customer where id=?";
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter(0, 6);
		query.executeUpdate();
		tx.commit();
		session.close();
	}

	// 查询（如果测试没通过，请检查数据库是否已经存在这条记录）
	@Test
	public void test_get() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		// Transaction tx = session.beginTransaction();
		Customer customer = (Customer) session.get(Customer.class, 1);
		// tx.commit();
		session.close();
		System.out.println(customer);
	}

	// 查询（如果测试没通过，请检查数据库是否已经存在这条记录）
	// 需要为<class name="Customer" lazy="false">...</class>添加lazy="false"，测试才通过
	@Test
	public void test_load() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		// Transaction tx = session.getTransaction();
		// tx.begin();
		Customer customer = (Customer) session.load(Customer.class, 1);
		// tx.commit();

		Hibernate.initialize(customer);
		session.close();
		System.out.println(customer);

		// 或者
		// System.out.println(customer);
		// session.close();
	}
	
}
