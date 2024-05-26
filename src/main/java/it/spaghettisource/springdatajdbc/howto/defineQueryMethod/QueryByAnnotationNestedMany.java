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
package it.spaghettisource.springdatajdbc.howto.defineQueryMethod;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.Objects;

/**
 * simple entity
 *
 * @author Alessandro D'Ottavio
 */
public class QueryByAnnotationNestedMany {

	private @Id Long id;
	private String name;


}
