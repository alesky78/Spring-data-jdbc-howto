package it.spaghettisource.springdatajdbc.howto.createRepository;

import org.springframework.data.jdbc.core.JdbcAggregateTemplate;

public class CustomRepositoryFragmentImpl<T, ID> implements CustomRepositoryFragment<T,ID> {

    private final JdbcAggregateTemplate template;

    public CustomRepositoryFragmentImpl(JdbcAggregateTemplate template){

        this.template = template;
    }

    @Override
    public T insert(T t){

        return template.insert(t);
    }

    @Override
    public void update(T t){
        template.update(t);
    }

}
