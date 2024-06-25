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
import org.springframework.data.relational.core.mapping.Embedded;

import java.util.Objects;
import java.util.Set;

import static org.springframework.data.relational.core.mapping.Embedded.OnEmpty.USE_EMPTY;

/**
 * simple entity
 *
 * @author Alessandro D'Ottavio
 */
public class QueryByAnnotationRoot {

    private @Id Long id;
    private String name;

    @Embedded(onEmpty = USE_EMPTY) // you could use USE_NULL
    private QueryByAnnotationEmbeddedOne embedded;

    private QueryByAnnotationNestedOne nested;

    private Set<QueryByAnnotationNestedMany> list;


    public QueryByAnnotationRoot(){

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

    public QueryByAnnotationEmbeddedOne getEmbedded(){

        return embedded;
    }

    public void setEmbedded(QueryByAnnotationEmbeddedOne embedded){

        this.embedded = embedded;
    }

    public QueryByAnnotationNestedOne getNested(){

        return nested;
    }

    public void setNested(QueryByAnnotationNestedOne nested){

        this.nested = nested;
    }

    public Set<QueryByAnnotationNestedMany> getList(){

        return list;
    }

    public void setList(Set<QueryByAnnotationNestedMany> set){

        this.list = set;
    }

    @Override
    public boolean equals(Object o){

        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        QueryByAnnotationRoot that = (QueryByAnnotationRoot) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode(){

        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString(){

        return "QueryByAnnotationRoot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", embedded=" + embedded +
                ", nested=" + nested +
                ", list=" + list +
                '}';
    }

}
