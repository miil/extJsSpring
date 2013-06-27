package co.il.emet.admin.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import co.il.emet.admin.model.L7ServiceConfig;

/**
 * L7ServiceConfig DAO class.
 * 
 * @author Oleg B.
 */
@Repository
public class L7ServiceConfigDAO {

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	/**
	 * Get List of contacts from database
	 * 
	 * @return list of all contacts
	 */
	@SuppressWarnings("unchecked")
	public List<L7ServiceConfig> getContacts(int start, int limit) {

		DetachedCriteria criteria = DetachedCriteria.forClass(L7ServiceConfig.class);

		return hibernateTemplate.findByCriteria(criteria, start, limit);
	}

	/**
	 * Delete a contact with the id passed as parameter
	 * 
	 * @param id
	 */
	public void deleteContact(int id) {
		Object record = hibernateTemplate.load(L7ServiceConfig.class, id);
		hibernateTemplate.delete(record);
	}

	/**
	 * Create a new L7ServiceConfig on the database or Update contact
	 * 
	 * @param l7ServiceConfig
	 * @return contact added or updated in DB
	 */
	public L7ServiceConfig saveContact(L7ServiceConfig l7ServiceConfig) {
		hibernateTemplate.saveOrUpdate(l7ServiceConfig);
		return l7ServiceConfig;
	}

	/**
	 * Get total of Contacts from database
	 * 
	 * @return
	 */
	public int getTotalContacts() {
		return DataAccessUtils.intResult(hibernateTemplate
				.find("SELECT COUNT(*) FROM L7ServiceConfig"));
	}

}
