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

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.relational.core.mapping.event.BeforeConvertCallback;

import java.util.UUID;

/**
 * Contains infrastructure necessary for creating repositories, listeners and EntityCallbacks.
 * <p>
 * Not that a listener may change an entity without any problem.
 *
 * @author Alessandro D'Ottavio
 */
@Configuration
@EnableJdbcRepositories
public class SimpleCrudConfiguration extends AbstractJdbcConfiguration {


    /**
     * An EntityCallback that gets invoked before the aggregate is converted into a database change.
     * The decision if the change will be an insert or update is made before this callback gets called.
     */
    @Bean
    BeforeConvertCallback<SimpleCrudManualIdByCallBack> beforeSaveCallback() {

        return (entity) -> {
            //remember that if the ID is null spring has already determined to execute an INSERT
            if (entity.getId() == null) {
                entity.setId(UUID.randomUUID().toString()); //generate the ID in the code
            }
            return entity;
        };
    }

}
