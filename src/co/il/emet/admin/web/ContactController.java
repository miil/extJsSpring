package co.il.emet.admin.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.il.emet.admin.model.L7ServiceConfig;
import co.il.emet.admin.model.L7ServiceConfigWrapper;
import co.il.emet.admin.service.ContactService;
import co.il.emet.admin.util.ExtJSReturn;


/**
 * Controller - Spring
 * 
 * Sample project presented at BrazilJS Brazilian JavaScript Conference
 * Fortaleza - Ceará - 13-14 May 2011 http://braziljs.com.br/2011
 * 
 * @author Loiane Groner http://loianegroner.com (English) http://loiane.com
 *         (Portuguese)
 */
@Controller
public class ContactController {

	private ContactService contactService;

	@RequestMapping(value = "/contact/view.action")
	public @ResponseBody
	Map<String, ? extends Object> view(@RequestParam int start,
			@RequestParam int limit) throws Exception {

		try {

			List<L7ServiceConfig> l7ServiceConfigs = contactService
					.getContactList(start, limit);

			int total = contactService.getTotalContacts();

			return ExtJSReturn.mapOK(l7ServiceConfigs, total);

		} catch (Exception e) {

			return ExtJSReturn
					.mapError("Error retrieving Contacts from database.");
		}
	}

	@RequestMapping(value = "/contact/create.action")
	public @ResponseBody
	Map<String, ? extends Object> create(@RequestBody L7ServiceConfigWrapper data)
			throws Exception {

		try {

			List<L7ServiceConfig> l7ServiceConfigs = contactService.create(data.getData());

			return ExtJSReturn.mapOK(l7ServiceConfigs);

		} catch (Exception e) {

			return ExtJSReturn.mapError("Error trying to create contact.");
		}
	}

	@RequestMapping(value = "/contact/update.action")
	public @ResponseBody
	Map<String, ? extends Object> update(@RequestBody L7ServiceConfigWrapper data)
			throws Exception {
		try {

			List<L7ServiceConfig> l7ServiceConfigs = contactService.update(data.getData());

			return ExtJSReturn.mapOK(l7ServiceConfigs);

		} catch (Exception e) {

			return ExtJSReturn.mapError("Error trying to update contact.");
		}
	}

	@RequestMapping(value = "/contact/delete.action")
	public @ResponseBody
	Map<String, ? extends Object> delete(@RequestBody L7ServiceConfigWrapper data)
			throws Exception {

		try {

			contactService.delete(data.getData());

			Map<String, Object> modelMap = new HashMap<String, Object>(3);
			modelMap.put("success", true);

			return modelMap;

		} catch (Exception e) {

			return ExtJSReturn.mapError("Error trying to delete contact.");
		}
	}

	@Autowired
	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}

}
