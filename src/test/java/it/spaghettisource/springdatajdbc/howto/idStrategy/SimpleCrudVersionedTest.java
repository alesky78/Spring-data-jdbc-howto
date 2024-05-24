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
package it.spaghettisource.springdatajdbc.howto.idStrategy;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.OptimisticLockingFailureException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Demonstrates simple CRUD operations with a simple entity without any references.
 *
 * @author Alessandro D'Ottavio
 */
@SpringBootTest(classes = SimpleCrudConfiguration.class)
@AutoConfigureJdbc
class SimpleCrudVersionedTest {

	private static final Logger logger = LoggerFactory.getLogger(SimpleCrudVersioned.class);
	
	@Autowired
	SimpleCrudVersionedRepository repository;

	@Test
	void runInsertForIdAndVersionNull() {

		//in this case spring has no doubt, there is no version and no ID then will do an insert
		var entity = repository.save(new SimpleCrudVersioned(null,"MAKE INSERT",null));//make an INSERT

		logger.info("entity inserted: "+entity);

		assertThat(entity).isNotNull();
	}

	@Test()
	void throwExceptionForIdNullAndVersionNotNull() {
		assertThrows(OptimisticLockingFailureException.class,
				()->{
					//in this case spring will try to do an update because also if the ID is null the version is populated then suppose entity already exsist
					var entity = repository.save(new SimpleCrudVersioned(null,"MAKE INSERT",10L));//make an UPDATE also if the entity no exsit
				});
	}

	@Test()
	void runInsertForIdNotNullAndVersionNull() {

		//this case show that the version is has an Higher priority that an ID:
		//If a property annotated with @Version is null, or in case of a version property of primitive type 0 the entity is considered new (INSERT!)
		//this happen independently by the value of the property ID ()

		var entity = repository.save(new SimpleCrudVersioned(100L,"MAKE INSERT",null));//make an INSERT also if the ID has a value

		assertThat(entity).isNotNull();

	}

	@Test
	void findEntity() {

		// create some simple entity
		var entity = repository.save(new SimpleCrudVersioned(null,"1 simple entity with manual id",null));
		var found = repository.findById(entity.getId());

		logger.info("Simple entity found: "+found.isPresent());

		assertThat(found.isPresent()).isTrue();

	}

	@Test
	void deleteEntity() {

		// create some simple entity
		var entity = repository.save(new SimpleCrudVersioned(null,"to delete simple entity",null));

		logger.info("Simple entity to delete created: "+entity.toString());

		repository.delete(entity);
		var delete  = repository.findById(entity.getId());

		assertThat(delete.isEmpty()).isTrue();

	}

}
