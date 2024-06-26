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

import java.util.Objects;

/**
 * simple entity
 *
 * @author Alessandro D'Ottavio
 */
public class SingleCollectionNestedMany {

    private String element;

    public SingleCollectionNestedMany(){

    }

    public SingleCollectionNestedMany(String element){

        this.element = element;
    }

    public String getElement(){

        return element;
    }

    public void setElement(String element){

        this.element = element;
    }

    @Override
    public boolean equals(Object o){

        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        SingleCollectionNestedMany that = (SingleCollectionNestedMany) o;

        return Objects.equals(element, that.element);
    }

    @Override
    public int hashCode(){

        return element != null ? element.hashCode() : 0;
    }

    @Override
    public String toString(){

        return "QueryByAnnotationNestedMany{" +
                "element='" + element + '\'' +
                '}';
    }

}
