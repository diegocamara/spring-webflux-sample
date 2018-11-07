package com.example.reactiveapplication.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.mongodb.reactivestreams.client.MongoClient;

@Configuration
public class MongoTransactionConfiguration {

	@Autowired
	private MongoClient mongoClient;

	@Value("${spring.data.mongodb.database}")
	private String databaseName;

	@Bean
	public MongoTransactionManager transactionManager(MongoDbFactory mongoDbFactory) {
		return new MongoTransactionManager(mongoDbFactory);
	}

	@Bean
	public ReactiveMongoTemplate reactiveMongoTemplate() {
		return new ReactiveMongoTemplate(this.mongoClient, this.databaseName);
	}

}
