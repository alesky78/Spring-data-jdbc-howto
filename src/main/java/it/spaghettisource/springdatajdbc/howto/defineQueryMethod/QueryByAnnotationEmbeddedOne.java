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

/**
 * simple entity
 *
 * @author Alessandro D'Ottavio
 */
public class QueryByAnnotationEmbeddedOne {


    private String job;
    private Integer age;

    public QueryByAnnotationEmbeddedOne(){

    }

    public QueryByAnnotationEmbeddedOne(String job, Integer age){

        this.job = job;
        this.age = age;
    }
    public String getJob(){

        return job;
    }

    public void setJob(String job){

        this.job = job;
    }

    public Integer getAge(){

        return age;
    }

    public void setAge(Integer age){

        this.age = age;
    }


    @Override
    public String toString(){

        return "PropertyExpressionsEmbedded{" +
                "  job='" + job + '\'' +
                ", age=" + age +
                '}';
    }


}
