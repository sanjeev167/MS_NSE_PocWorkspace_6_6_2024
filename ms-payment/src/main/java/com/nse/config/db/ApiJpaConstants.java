/**
 * 
 */
package com.nse.config.db;

/**
 * @author sanjeevkumar
 * 20-Mar-2024
 * 11:50:26 am 
 * Objective: 
 */
public class ApiJpaConstants {
	
	//Persistence unit 
    public static final String API_SERVICE_JPA_UNIT ="ms-payment";
   
	
	//Define all the entities package names here. This will be an entityManager specific
    public static final String[] API_SERVICE_PKG_ENTITIES_ARRAY=new String[] {"com.nse.entities" };    
    
  //Define all the repositories package names here. This will be an entityManager specific   
    public static final String PKG_REPO = "com.nse.repo";
   
}//End of ApiJpaConstants
