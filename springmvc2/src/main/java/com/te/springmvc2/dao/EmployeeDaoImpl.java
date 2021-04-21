package com.te.springmvc2.dao;

import java.util.Date;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transaction;

import org.springframework.stereotype.Repository;

import com.te.springmvc2.beans.EmployeeBean;
import com.te.springmvc2.customexception.EmployeeExp;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public EmployeeBean authenticate(int id, String pwd) {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");

		EntityManager manager = factory.createEntityManager();

		try {
			EmployeeBean bean = manager.find(EmployeeBean.class, id);

			if (bean != null) {
				if (bean.getPassword().equals(pwd)) {
					System.out.println("login successful");
					return bean;
				} else {
					System.out.println("invalid credentials");
					return null;
				}
			} else {
				throw new EmployeeExp("user not found");
			}
		} catch (Exception e) {

			e.printStackTrace();
			throw new EmployeeExp("user not found");
		} // end of authenticate

	}

	@Override
	public EmployeeBean getEmployee(int id) {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");

		EntityManager manager = factory.createEntityManager();
		try {
			EmployeeBean bean = manager.find(EmployeeBean.class, id);

			if (bean != null) {
				return bean;
			} else {
				System.out.println("employee not found ");
				return null;
			}
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		} // end of getEmployee

	}

	@Override
	public boolean deleteEmployee(int id) {

//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");

		EntityManager manager = factory.createEntityManager();

		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();

		EmployeeBean bean = manager.find(EmployeeBean.class, id);
		if (bean != null) {
			manager.remove(bean);
			transaction.commit();
			return true;
		} else {
			return false;
		}

	}// end of delete employee

	@Override
	public List<EmployeeBean> getAllData() {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");

		EntityManager manager = factory.createEntityManager();

		String query = "from EmployeeBean";

		javax.persistence.Query query2 = manager.createQuery(query);

		List<EmployeeBean> list = query2.getResultList();
		if (list != null) {
			return list;
		} else {
			return null;
		}

	}// end of getalldata method

	@Override
	public boolean addEmployee(EmployeeBean bean) {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");

		EntityManager manager = factory.createEntityManager();

		EntityTransaction transaction = manager.getTransaction();

		try {
			

			transaction.begin();
			
			manager.persist(bean);

			boolean isadded = false;

			if (bean!=null) {
				isadded = true;
				transaction.commit();
				return isadded;
			} else {
				isadded = false;
				return isadded;
			}
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
	}// end of addEmployee method

	@Override
	public boolean updateEmployee(EmployeeBean bean) {
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction transaction = manager.getTransaction();
		
		try {
			transaction.begin();
			
			boolean isupdated = false;
			
			EmployeeBean info = manager.find(EmployeeBean.class, bean.getId());
			
			
			if(bean.getName()!=null && bean.getName()!="") {
				info.setName(bean.getName());
			}
			
			if(bean.getBirtDate()!=null) {
				info.setBirtDate(bean.getBirtDate());
			}
			
			if(bean.getPassword()!=null && bean.getPassword()!="") {
				info.setPassword(bean.getPassword());
			}
			
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
	}
		
	}

