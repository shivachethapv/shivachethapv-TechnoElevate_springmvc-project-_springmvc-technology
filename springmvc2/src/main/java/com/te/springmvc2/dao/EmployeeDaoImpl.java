package com.te.springmvc2.dao;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.te.springmvc2.beans.EmployeeBean;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public EmployeeBean authenticate(int id, String pwd) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");

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
				System.out.println("user not found");
				return null;
			}
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		} // end of authenticate

	}

	@Override
	public EmployeeBean getEmployee(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");

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

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");

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

	}//end of delete employee

	@Override
	public List<EmployeeBean> getAllData() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");

		EntityManager manager = factory.createEntityManager();
		
		String query = "from EmployeeBean";
		
		javax.persistence.Query query2 = manager.createQuery(query);
		
		List<EmployeeBean> list = query2.getResultList();
		if(list!=null) {
			return list;
		}
		else {
			return null;
		}
		
	}
	
	

}
