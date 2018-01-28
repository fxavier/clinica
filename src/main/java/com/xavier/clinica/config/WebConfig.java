package com.xavier.clinica.config;

import javax.cache.Caching;

import org.springframework.cache.CacheManager;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
public class WebConfig implements WebMvcConfigurer{
	
@Bean
public CacheManager cacheManager() throws Exception {		
		return new JCacheCacheManager(Caching.getCachingProvider().getCacheManager(
				getClass().getResource("/env/ehcache.xml").toURI(),
				getClass().getClassLoader()));
}
	


}
