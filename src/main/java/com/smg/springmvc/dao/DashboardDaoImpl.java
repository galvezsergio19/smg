package com.smg.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
 
import com.smg.springmvc.model.Employee;
 
@Repository("dashboardDao")
public class DashboardDaoImpl extends AbstractDao<Integer, Employee> implements DashboardDao {
    
    public Long countRegistered() {
        Criteria criteria = createEntityCriteria();
        criteria.setProjection(Projections.rowCount());
        return (Long) criteria.uniqueResult();
    }
    
    public Employee getFullName(String username){
    	Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("username", username));
        return (Employee) criteria.uniqueResult();
    }
    
    @SuppressWarnings("unchecked")
    public List<Employee> getContacts(String username) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.ne("username", username));
        criteria.addOrder(Order.asc("full_name"));
        return (List<Employee>) criteria.list();
    }
 
}