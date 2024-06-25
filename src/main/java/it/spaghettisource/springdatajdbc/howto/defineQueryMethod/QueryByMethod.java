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
public class QueryByMethod {

    private @Id Long id;
    private String name;
    private Integer age;
    private LocalDate birthDate;
    private String job;

    public QueryByMethod(String name, Integer age, LocalDate birthDate, String job){

        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
        this.job = job;
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

    public Integer getAge(){

        return age;
    }

    public void setAge(Integer age){

        this.age = age;
    }

    public LocalDate getBirthDate(){

        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate){

        this.birthDate = birthDate;
    }

    public String getJob(){

        return job;
    }

    public void setJob(String job){

        this.job = job;
    }

    @Override
    public boolean equals(Object o){

        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        QueryByMethod that = (QueryByMethod) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode(){

        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (job != null ? job.hashCode() : 0);
        return result;
    }

    @Override
    public String toString(){

        return "SimpleQueryMethod{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", bornDate=" + birthDate +
                ", role='" + job + '\'' +
                '}';
    }

}
