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

import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.AccessType.Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.annotation.Version;
import org.springframework.data.domain.Persistable;

import java.util.Objects;

/**
 * versioned entity
 *
 * @author Alessandro D'Ottavio
 */
@AccessType(Type.FIELD)
public class SimpleCrudVersioned{

	private @Id Long id;
	private String name;

	@Version
	private Long version;

	public SimpleCrudVersioned() {
	}

	public SimpleCrudVersioned(Long id, String name,Long version) {
		this.id = id;
		this.name = name;
		this.version = version;
	}

	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Long getVersion() {return version;}
	public void setVersion(Long version) {this.version = version;}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		SimpleCrudVersioned entity = (SimpleCrudVersioned) o;

		return Objects.equals(id, entity.id);
    }

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "SimpleCrudVersioned{" +
				"id=" + id +
				", name='" + name + '\'' +
				", version=" + version +
				'}';
	}
}
