package it.spaghettisource.springdatajdbc.howto.nPlu1;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.util.List;

public class SingleCollectionRootRepositoryFragmentImpl implements SingleCollectionRootRepositoryFragment {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final JdbcTemplate jdbcTemplate;

    //jdbcClient is a custom class introduced in the new Spring version that wraps the JdbcTemplate and expose a more fluent API, then is always advisable to use it instead the jdbcTemplate
    private final JdbcClient jdbcClient;

    private final String join = """
              SELECT SINGLE_COLLECTION_ROOT.ID AS ID, SINGLE_COLLECTION_ROOT.NAME AS NAME,
              nested.ELEMENT AS ELEMENT
              FROM SINGLE_COLLECTION_ROOT LEFT OUTER JOIN SINGLE_COLLECTION_NESTED_MANY nested ON nested.SINGLE_COLLECTION_ROOT = SINGLE_COLLECTION_ROOT.ID
            """;

    public SingleCollectionRootRepositoryFragmentImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate, JdbcTemplate jdbcTemplate, JdbcClient jdbcClient){

        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.jdbcTemplate = jdbcTemplate;
        this.jdbcClient = jdbcClient;
    }

    @Override
    public List<SingleCollectionRoot> findAllBy_NamedParameterJdbcTemplate(){

        return namedParameterJdbcTemplate.query(join, new SingleConnectionRootResultsetExtractor());
    }

    @Override
    public List<SingleCollectionRoot> findAllBy_JdbcTemplate(){

        return jdbcTemplate.query(join, new SingleConnectionRootResultsetExtractor());
    }
    @Override
    public List<SingleCollectionRoot> findAllBy_JdbcClient(){

        return jdbcClient.sql(join).query(new SingleConnectionRootResultsetExtractor());
    }

}
