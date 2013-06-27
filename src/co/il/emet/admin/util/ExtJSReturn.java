package co.il.emet.admin.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import co.il.emet.admin.model.L7ServiceConfig;


/**
 * 
 * Util class, returns a Map in the format Ext JS expects
 *
 * @author Oleg B.
 * 
 */
@Component
public class ExtJSReturn {

	/**
	 * Generates modelMap to return in the modelAndView
	 * @param l7ServiceConfigs
	 * @return
	 */
	public static Map<String,Object> mapOK(List<L7ServiceConfig> l7ServiceConfigs){
		
		Map<String,Object> modelMap = new HashMap<String,Object>(3);
		modelMap.put("total", l7ServiceConfigs.size());
		modelMap.put("data", l7ServiceConfigs);
		modelMap.put("success", true);
		
		return modelMap;
	}
	
	/**
	 * Generates modelMap to return in the modelAndView
	 * @param l7ServiceConfigs
	 * @return
	 */
	public static Map<String,Object> mapOK(List<L7ServiceConfig> l7ServiceConfigs, int total){
		
		Map<String,Object> modelMap = new HashMap<String,Object>(3);
		modelMap.put("total", total);
		modelMap.put("data", l7ServiceConfigs);
		modelMap.put("success", true);
		
		return modelMap;
	}
	
	/**
	 * Generates modelMap to return in the modelAndView in case
	 * of exception
	 * @param msg message
	 * @return
	 */
	public static Map<String,Object> mapError(String msg){

		Map<String,Object> modelMap = new HashMap<String,Object>(2);
		modelMap.put("message", msg);
		modelMap.put("success", false);

		return modelMap;
	} 
}
