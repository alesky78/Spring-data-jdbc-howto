package it.spaghettisource.springdatajdbc.howto.nPlu1;

import java.util.List;

public interface SingleCollectionRootRepositoryFragment {


    List<SingleCollectionRoot> findAllBy_NamedParameterJdbcTemplate();

    List<SingleCollectionRoot> findAllBy_JdbcTemplate();

    List<SingleCollectionRoot> findAllBy_JdbcClient();

}
