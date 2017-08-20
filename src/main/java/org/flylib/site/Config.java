package org.flylib.site;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 
 * @author Frank Liu
 *
 */
@Configuration
@ImportResource(locations={"classpath:spring-${spring.profiles.active}/appContext.xml"})
public class Config {

}