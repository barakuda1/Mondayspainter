/*
 * Author: Sharon Moll
 * 
 */

package org.mondayspainter.service;

import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.mondayspainter.servicehandler.BasicHandler;

@ManagedBean(name="mondayspainterService")
@ApplicationScoped
public class MondayspainterService extends BasicHandler  {
	
	public String getJson() {

		try {
			FacesContext context = FacesContext.getCurrentInstance();
			Map<String, String> params = context.getExternalContext().getRequestParameterMap();
		
			ServiceArgument arguments = new ServiceArgument();
			arguments.controller = params.get("controller");
			arguments.function = params.get("function");			
			arguments.data = params;
			
//			arguments.controller = "ChatHandler";
//			arguments.function = "getLastMessages";
			
			Class handlerClass;
			
			handlerClass = Class.forName("org.mondayspainter.servicehandler."+arguments.controller);
			BasicHandler handler = (BasicHandler)handlerClass.newInstance();
			
			handler.arguments = arguments;			
			
			return handler.generate();
	    }
	    catch (Exception e) {
	    	return "Wrong Handler or Function Called!";
	    }
    } 
    
}
