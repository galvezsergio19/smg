package com.smg.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.smg.springmvc.model.Message;
 
@Repository("messageDao")
public class MessageDaoImpl extends AbstractDao<Integer, Message> implements MessageDao {
 
	private String UPDATE_ONLINE_STATUS = "update Employee set online_status = :online_status "
			+  "where username = :username" ;
	private String DELETE_MESSAGE = "delete from Message";
	
	public void saveMessage(Message message) {
        persist(message);
    }
	
	public Long countMessage() {
        Criteria criteria = createEntityCriteria();
        criteria.setProjection(Projections.rowCount());
        return (Long) criteria.uniqueResult();
    }
    
	@SuppressWarnings("unchecked")
    public List<Message> getMessage() {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("recepient", ""));
        criteria.addOrder(Order.asc("createdate"));
        return (List<Message>) criteria.list();
    }
	
	@SuppressWarnings("unchecked")
    public List<Message> getMessageByContact(String username, String recepient) {
        Criteria criteria = createEntityCriteria();
        Criterion rest1= Restrictions.and(Restrictions.eq("recepient", recepient),
        					Restrictions.eq("username", username));
        Criterion rest2= Restrictions.and(Restrictions.eq("username", recepient),
							Restrictions.eq("recepient", username));
        criteria.add(Restrictions.or(rest1, rest2));
        criteria.addOrder(Order.asc("createdate"));
        return (List<Message>) criteria.list();
    }
	
	public void updateOnlineStatus(String username, Integer status) {
        Query query = getSession().createSQLQuery(UPDATE_ONLINE_STATUS);
        query.setInteger("online_status", status);
        query.setString("username", username);
        query.executeUpdate();
    }
	
	public void deleteMessage() {
		Query query = getSession().createSQLQuery(DELETE_MESSAGE);
        query.executeUpdate();
	}
 
}