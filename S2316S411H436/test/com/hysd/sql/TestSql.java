package com.hysd.sql;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.junit.Test;

import com.hysd.domain.Emp;
import com.hysd.util.HibernateUtils;

/**
 * 测试SQL查询
 */
public class TestSql {

	/** 查询全部 */
	@Test
	public void test_sql1() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		String sql = "select * from tb_emp";// 这里的tb_emp是数据库的表名
		SQLQuery query = session.createSQLQuery(sql);
		List<Object[]> list = query.list();
		for (Object[] arr : list) {
			System.out.println(arr[0] + "\t" + arr[1] + "\t" + arr[2] + "\t"
					+ arr[3] + "\t" + arr[4] + "\t" + arr[5] + "\t" + arr[6]
					+ "\t" + arr[7]);
		}
		session.close();
	}

	/** 查询全部 */
	@Test
	public void test_sql2() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		String sql = "select * from tb_emp";// 这里的tb_emp是数据库的表名
		SQLQuery query = session.createSQLQuery(sql);
		query.addScalar("empno", StandardBasicTypes.INTEGER);
		query.addScalar("ename", StandardBasicTypes.STRING);
		query.addScalar("job", StandardBasicTypes.STRING);
		query.addScalar("mgr", StandardBasicTypes.INTEGER);
		query.addScalar("hiredate", StandardBasicTypes.DATE);
		query.addScalar("sal", StandardBasicTypes.DOUBLE);
		query.addScalar("comm", StandardBasicTypes.DOUBLE);
		query.addScalar("deptno", StandardBasicTypes.INTEGER);
		List<Object[]> list = query.list();
		for (Object[] arr : list) {
			System.out.println(arr[0] + "\t" + arr[1] + "\t" + arr[2] + "\t"
					+ arr[3] + "\t" + arr[4] + "\t" + arr[5] + "\t" + arr[6]
					+ "\t" + arr[7]);
		}
		session.close();
	}

	/** 查询全部 */
	@Test
	public void test_sql3() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		String sql = "select * from tb_emp";// 这里的tb_emp是数据库的表名
		SQLQuery query = session.createSQLQuery(sql);
		query.addScalar("empno", StandardBasicTypes.INTEGER);
		query.addScalar("ename", StandardBasicTypes.STRING);
		query.addScalar("job", StandardBasicTypes.STRING);
		query.addScalar("mgr", StandardBasicTypes.INTEGER);
		query.addScalar("hiredate", StandardBasicTypes.DATE);
		query.addScalar("sal", StandardBasicTypes.DOUBLE);
		query.addScalar("comm", StandardBasicTypes.DOUBLE);
		query.addScalar("deptno", StandardBasicTypes.INTEGER);
		query.setResultTransformer(Transformers.aliasToBean(Emp.class));
		List<Emp> list = query.list();
		show(list);
		session.close();
	}

	/** 查询全部 (推荐) */
	@Test
	public void test_sql4() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();

		// 方法一：不用别名
		String sql = "select * from tb_emp";// 这里的tb_emp是数据库的表名
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Emp.class);

		// // 方法二：使用别名
		// String sql = "select {e.*} from tb_emp e";//这里的tb_emp是数据库的表名
		// SQLQuery query = session.createSQLQuery(sql);
		// query.addEntity("e", Emp.class);
		
		query.setCacheable(true); // 设置缓存
		List<Emp> list = query.list();
		show(list);
		session.close();
	}

	/** 条件查询 */
	@Test
	public void test_where() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();

		// 方法一：占位参数
		String sql = "select * from tb_emp where ename like ?";// 这里的tb_emp是数据库的表名
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Emp.class);
		query.setString(0, "J%");

		// // 方法二：命名参数
		// String sql = "select * from tb_emp where ename like :ename";//这里的tb_emp是数据库的表名
		// SQLQuery query = session.createSQLQuery(sql);
		// query.addEntity(Emp.class);
		// query.setString("ename", "J%");

		List<Emp> list = query.list();
		show(list);
		session.close();
	}

	// 遍历集合
	private void show(List<Emp> list) {
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}

}
