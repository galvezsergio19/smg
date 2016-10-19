package com.smg.springmvc.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
 
import com.smg.springmvc.model.Employee;
 
@Repository("registrationDao")
public class RegistrationDaoImpl extends AbstractDao<Integer, Employee> implements RegistrationDao {
 
    public void saveEmployee(Employee employee) {
        persist(employee);
    }
    
    public Employee findEmployeeByUsername(String username) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("username", username));
        return (Employee) criteria.uniqueResult();
    }
 
}