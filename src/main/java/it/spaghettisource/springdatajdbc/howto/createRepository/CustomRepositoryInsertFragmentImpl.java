package it.spaghettisource.springdatajdbc.howto.createRepository;

import org.springframework.data.jdbc.core.JdbcAggregateTemplate;

public class CustomRepositoryInsertFragmentImpl<T, ID> implements CustomRepositoryInsertFragment<T,ID> {

    private final JdbcAggregateTemplate template;

    public CustomRepositoryInsertFragmentImpl(JdbcAggregateTemplate template){

        this.template = template;
    }

    @Override
    public T insert(T t){

        return template.insert(t);
    }

}
