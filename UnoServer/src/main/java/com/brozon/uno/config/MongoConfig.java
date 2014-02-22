package com.brozon.uno.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
 
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
 
@Configuration
public class MongoConfig extends AbstractMongoConfiguration {
 
	@Override
	public String getDatabaseName() {
		return "uno";
	}
 
	@Override
	@Bean
	public Mongo mongo() throws Exception {
		return new MongoClient("127.0.0.1");
	}
	
	@Bean
	public MongoOperations mongoOperations() throws Exception {
		return new MongoTemplate(new MongoClient("127.0.0.1"), "uno");
	}
}