package com.smg.springmvc.dao;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
 
import com.smg.springmvc.model.Employee;
 
@Repository("loginDao")
public class LoginDaoImpl extends AbstractDao<Integer, Employee> implements LoginDao {
    
	private String UPDATE_LOGIN_DATE = "update Employee set last_logon_date = :loginDate "
									+  "where username = :username" ; 
	
    public Employee findEmployeeByUsername(String username) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("username", username));
        return (Employee) criteria.uniqueResult();
    }
    
    public Employee findEmployeeByUsernamePassword(String username, String password) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("username", username));
        criteria.add(Restrictions.eq("password", password));
        return (Employee) criteria.uniqueResult();
    }
    
    public void updateLoginDate(String username, Date loginDate) {
        Query query = getSession().createSQLQuery(UPDATE_LOGIN_DATE);
        query.setTimestamp("loginDate", loginDate);
        query.setString("username", username);
        query.executeUpdate();
    }
 
}