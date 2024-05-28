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
package it.spaghettisource.springdatajdbc.howto.nPlu1;

import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * simple entity
 *
 * @author Alessandro D'Ottavio
 */
public class SingleCollectionRoot {

	private @Id Long id;
	private String name;

	private Set<SingleCollectionNestedMany> list = new HashSet<>();

	public SingleCollectionRoot() {}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Set<SingleCollectionNestedMany> getList() {
		return list;
	}

	public void setList(Set<SingleCollectionNestedMany> list) {
		this.list = list;
	}

	public void add(SingleCollectionNestedMany nested){
		list.add(nested);
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SingleCollectionRoot that = (SingleCollectionRoot) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "NPluOneRoot{" +
				"id=" + id +
				", name='" + name + '\'' +
				", list=" + list +
				'}';
	}
}
