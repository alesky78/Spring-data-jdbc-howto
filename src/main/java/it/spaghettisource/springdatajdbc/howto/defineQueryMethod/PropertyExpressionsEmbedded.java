package it.spaghettisource.springdatajdbc.howto.defineQueryMethod;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class PropertyExpressionsEmbedded {

    private String job;
    private Integer age;

    public PropertyExpressionsEmbedded(String job, Integer age) {
        this.job = job;
        this.age = age;
    }
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "PropertyExpressionsEmbedded{" +
                "  job='" + job + '\'' +
                ", age=" + age +
                '}';
    }
}
