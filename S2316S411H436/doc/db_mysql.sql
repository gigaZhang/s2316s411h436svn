DROP TABLE IF EXISTS  tb_customer;
DROP TABLE IF EXISTS  tb_order;
DROP TABLE IF EXISTS  tb_emp;

CREATE TABLE tb_customer
(
	id	 INT(11),
	name VARCHAR(50),
	PRIMARY KEY(id)
);

CREATE TABLE tb_order
(
	id 			INT(11),
	ordernumber VARCHAR(50),
	customer_id INT(11),
	PRIMARY KEY(id),
	FOREIGN KEY (customer_id) REFERENCES tb_customer(id)
);

CREATE TABLE tb_emp
(
  empno    INT(11),
  ename    VARCHAR(50),
  job      VARCHAR(50),
  mgr      INT(11),
  hiredate DATE,
  sal      DOUBLE,
  comm     DOUBLE,
  deptno   INT(11),
  PRIMARY KEY(empno)
);


--添加测试数据;
INSERT INTO tb_customer (id, name) VALUES (1, 'Tom');
INSERT INTO tb_customer (id, name) VALUES (2, 'Jerry');
INSERT INTO tb_customer (id, name) VALUES (3, 'Kingkong');
INSERT INTO tb_customer (id, name) VALUES (4, 'Simpleit');

INSERT INTO tb_order (id, ordernumber, customer_id) VALUES (1,  'Tom_Order_1', 1);
INSERT INTO tb_order (id, ordernumber, customer_id) VALUES (2, 'Tom_Order_2', 1);
INSERT INTO tb_order (id, ordernumber, customer_id) VALUES (3, 'Jerry_Order_1', 2);
INSERT INTO tb_order (id, ordernumber, customer_id) VALUES (4, 'Kingkong_Order_1', 3);
INSERT INTO tb_order (id, ordernumber, customer_id) VALUES (5, 'Simpleit_Order_1', 4);
INSERT INTO tb_order (id, ordernumber, customer_id) VALUES (6, 'Unkonwn_Order', NULL);

INSERT INTO tb_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
VALUES (1001, '员工1001', '美工设计师', 1003, str_to_date('10-12-1990', '%d-%m-%Y'), 4800.00, NULL, 20);

INSERT INTO tb_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
VALUES (1002, '员工1002', '开始工程师', 1003, str_to_date('05-12-1988', '%d-%m-%Y'), 5800.00, 100.00, 10);

INSERT INTO tb_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
VALUES (1003, '员工1003', '系统架构师', 1004, str_to_date('17-02-1985', '%d-%m-%Y'), 6800.00, 200.00, 10);

INSERT INTO tb_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
VALUES (1004, '员工1004', '项目经理', NULL, str_to_date('07-02-1980', '%d-%m-%Y'), 10800.00, 1000.00, 10);

INSERT INTO tb_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
VALUES (7369, 'SMITH', 'CLERK', 7902, str_to_date('17-12-1980', '%d-%m-%Y'), 800.00, NULL, 20);

INSERT INTO tb_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
VALUES (7499, 'ALLEN', 'SALESMAN', 7698, str_to_date('20-02-1981', '%d-%m-%Y'), 1600.00, 300.00, 30);

INSERT INTO tb_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
VALUES (7521, 'WARD', 'SALESMAN', 7698, str_to_date('22-02-1981', '%d-%m-%Y'), 1250.00, 500.00, 30);

INSERT INTO tb_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
VALUES (7566, 'JONES', 'MANAGER', 7839, str_to_date('02-04-1981', '%d-%m-%Y'), 2975.00, NULL, 20);

INSERT INTO tb_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
VALUES (7654, 'MARTIN', 'SALESMAN', 7698, str_to_date('28-09-1981', '%d-%m-%Y'), 1250.00, 1400.00, 30);

INSERT INTO tb_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
VALUES (7698, 'BLAKE', 'MANAGER', 7839, str_to_date('01-05-1981', '%d-%m-%Y'), 2850.00, NULL, 30);

INSERT INTO tb_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
VALUES (7782, 'CLARK', 'MANAGER', 7839, str_to_date('09-06-1981', '%d-%m-%Y'), 2450.00, NULL, 10);

INSERT INTO tb_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
VALUES (7788, 'SCOTT', 'ANALYST', 7566, str_to_date('19-04-1987', '%d-%m-%Y'), 3000.00, NULL, 20);

INSERT INTO tb_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
VALUES (7839, 'KING', 'PRESIDENT', NULL, str_to_date('17-11-1981', '%d-%m-%Y'), 5000.00, NULL, 10);

INSERT INTO tb_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
VALUES (7844, 'TURNER', 'SALESMAN', 7698, str_to_date('08-09-1981', '%d-%m-%Y'), 1500.00, 0.00, 30);

INSERT INTO tb_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
VALUES (7876, 'ADAMS', 'CLERK', 7788, str_to_date('23-05-1987', '%d-%m-%Y'), 1100.00, NULL, 20);

INSERT INTO tb_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
VALUES (7900, 'JAMES', 'CLERK', 7698, str_to_date('03-12-1981', '%d-%m-%Y'), 950.00, NULL, 30);

INSERT INTO tb_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
VALUES (7902, 'FORD', 'ANALYST', 7566, str_to_date('03-12-1981', '%d-%m-%Y'), 3000.00, NULL, 20);

INSERT INTO tb_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
VALUES (7934, 'MILLER', 'CLERK', 7782, str_to_date('23-01-1982', '%d-%m-%Y'), 1300.00, NULL, 10);



