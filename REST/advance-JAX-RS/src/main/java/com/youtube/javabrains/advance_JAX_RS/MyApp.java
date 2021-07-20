package com.youtube.javabrains.advance_JAX_RS;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("webapi")		//tells the root context
public class MyApp extends Application{		//extend Application class to turn into JAX-RS app. check its documentation
	
	//override to only include certain resources
	/*public Set<Class<?>> getClasses() {
		HashSet<Class<?>> hashSet = new HashSet<>();
		hashSet.add(MyResource.class);
		hashSet.add(MyResource2.class);
		hashSet.add(MyResource3ParamConverter.class);
		return hashSet;
	}*/
}
