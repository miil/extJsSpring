package co.il.emet.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.il.emet.admin.dao.L7ServiceConfigDAO;
import co.il.emet.admin.model.L7ServiceConfig;


/**
 * L7ServiceConfig Service
 *  
 * @author Oleg B.
 */
@Service
public class ContactService {
	
	private L7ServiceConfigDAO l7ServiceConfigDAO;

	/**
	 * Get all contacts
	 * @return
	 */
	@Transactional(readOnly=true)
	public List<L7ServiceConfig> getContactList(int start, int limit){
		
		return l7ServiceConfigDAO.getContacts(start, limit);
	}
	
	/**
	 * Create new L7ServiceConfig/Contacts
	 * @param data - json data from request
	 * @return created contacts
	 */
	@Transactional
	public List<L7ServiceConfig> create(L7ServiceConfig l7ServiceConfig){
		
        List<L7ServiceConfig> newContacts = new ArrayList<L7ServiceConfig>();
		
		newContacts.add(l7ServiceConfigDAO.saveContact(l7ServiceConfig));
		
		return newContacts;
	}
	
	
	/**
	 * Update contact/contacts
	 * @param data - json data from request
	 * @return updated contacts
	 */
	@Transactional
	public List<L7ServiceConfig> update(L7ServiceConfig l7ServiceConfig){
		
		List<L7ServiceConfig> returnContacts = new ArrayList<L7ServiceConfig>();
		
		returnContacts.add(l7ServiceConfigDAO.saveContact(l7ServiceConfig));
		
		return returnContacts;
	}
	
	/**
	 * Delete contact/contacts
	 * @param l7ServiceConfig - json data from request
	 */
	@Transactional
	public void delete(L7ServiceConfig l7ServiceConfig){
		
		l7ServiceConfigDAO.deleteContact(l7ServiceConfig.getId());
	}
	
	/**
	 * Get total of Contacts from database.
	 * Need to set this value on ExtJS Store
	 * @return
	 */
	public int getTotalContacts(){

		return l7ServiceConfigDAO.getTotalContacts();
	}

	/**
	 * Spring use - DI
	 * @param l7ServiceConfigDAO
	 */
	@Autowired
	public void setContactDAO(L7ServiceConfigDAO l7ServiceConfigDAO) {
		this.l7ServiceConfigDAO = l7ServiceConfigDAO;
	}
	
}
