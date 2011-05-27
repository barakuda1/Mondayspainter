/*
 * Author: Sharon Moll
 * 
 */

package org.mondayspainter.servicehandler;

import java.lang.reflect.Method;

import org.mondayspainter.service.ServiceArgument;

import flexjson.JSONSerializer;

abstract public class BasicHandler {

	public ServiceArgument arguments;
	
	public String generate() {			

		try {
			Method m = this.getClass().getMethod(arguments.function);
			JSONSerializer serializer = new JSONSerializer();
			return serializer.exclude("*.class", "*.handler").serialize(m.invoke(this));
			
		} catch(Exception e) {
			return null;
		}

	}
}
