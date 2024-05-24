/*
 * Copyright 2017-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package it.spaghettisource.springdatajdbc.howto.simplecrud;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Demonstrates simple CRUD operations with a simple entity without any references.
 *
 * @author Alessandro D'Ottavio
 */
@SpringBootTest(classes = SimpleCrudConfiguration.class)
@AutoConfigureJdbc
class SimpleCrudManualIdByCallBackTests {

	private static final Logger logger = LoggerFactory.getLogger(SimpleCrudManualIdByCallBackTests.class);
	
	@Autowired
	SimpleCrudManualIdByCallBackRepository repository;

	@Test
	void createSimpleEntity() {

		// create some simple entity
		repository.save(new SimpleCrudManualIdByCallBack("1 simple entity with manual id"));
		repository.save(new SimpleCrudManualIdByCallBack("2 simple entity with manual id"));
		repository.save(new SimpleCrudManualIdByCallBack("3 simple entity with manual id"));

		var all = repository.findAll();
		all.forEach(entity -> logger.info("Simple entity inserted: "+entity.toString()));

		assertThat(all.size()).isGreaterThan(0);
	}

	@Test
	void findSimpleEntity() {

		// create some simple entity
		var entity = repository.save(new SimpleCrudManualIdByCallBack("1 simple entity with manual id"));
		var found = repository.findById(entity.getId());

		logger.info("Simple entity found: "+found.isPresent());

		assertThat(found.isPresent()).isTrue();

	}

	@Test
	void deleteSimpleEntity() {

		// create some simple entity
		var entity = repository.save(new SimpleCrudManualIdByCallBack("to delete simple entity"));

		logger.info("Simple entity to delete created: "+entity.toString());

		repository.delete(entity);
		var delete  = repository.findById(entity.getId());

		assertThat(delete.isEmpty()).isTrue();

	}

}
