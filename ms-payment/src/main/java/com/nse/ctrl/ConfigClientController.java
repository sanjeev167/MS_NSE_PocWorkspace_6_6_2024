/**
 * 
 */
package com.nse.ctrl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sanjeevkumar
 *
 */
@RestController
@RequestMapping("")
public class ConfigClientController {
	
	@Value("${spring.profiles.active}")
    private String activeProfile;

    @Value("${example.property}")
    private String exampleProperty;
    
    @Value("${global.example.property}")
    private String globalExampleProperty;
    
   @Value("${deafault.example.property}")
    private String defaultExampleProperty;
    
    @GetMapping("/getConfig")
    public String getConfig() {
        return "###########  Active-profile ["+activeProfile+"] ==> "+
               "Configured key-values are coming from Config-Server. ##########<br><br> [1] " 
			  + exampleProperty
			  +"<br><br> [2] "+defaultExampleProperty
			  +"<br><br> [3] "+ globalExampleProperty;
        //return "Configuration property value: " + exampleProperty;
    }
}
