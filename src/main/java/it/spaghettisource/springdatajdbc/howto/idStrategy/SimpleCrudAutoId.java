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

import org.springframework.data.annotation.Id;

import java.util.Objects;

/**
 * simple entity
 *
 * @author Alessandro D'Ottavio
 */
public class SimpleCrudAutoId {

    private @Id Long id;
    private String name;

    public SimpleCrudAutoId(){

    }

    public SimpleCrudAutoId(String name){

        this.name = name;
    }

    public Long getId(){

        return id;
    }
    public void setId(Long id){

        this.id = id;
    }

    public String getName(){

        return name;
    }
    public void setName(String name){

        this.name = name;
    }


    @Override
    public boolean equals(Object o){

        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        SimpleCrudAutoId entity = (SimpleCrudAutoId) o;

        return Objects.equals(id, entity.id);
    }

    @Override
    public int hashCode(){

        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString(){

        return "SimpleCrudAutoId{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
