package it.spaghettisource.springdatajdbc.howto.nPlu1;

import java.util.List;

public interface SingleCollectionRootRepositoryFragment {


    List<SingleCollectionRoot> findAllBy_NamedParameterJdbcOperations();

    List<SingleCollectionRoot> findAllBy_JdbcTemplate();

}
