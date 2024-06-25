package it.spaghettisource.springdatajdbc.howto.nPlu1;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

import java.util.List;

public class SingleCollectionRootRepositoryFragmentImpl implements SingleCollectionRootRepositoryFragment {

    private final NamedParameterJdbcOperations JdbcOperations;
    private final JdbcTemplate jdbcTemplate;

    private final String join = """
              SELECT SINGLE_COLLECTION_ROOT.ID AS ID, SINGLE_COLLECTION_ROOT.NAME AS NAME,
              nested.ELEMENT AS ELEMENT
              FROM SINGLE_COLLECTION_ROOT LEFT OUTER JOIN SINGLE_COLLECTION_NESTED_MANY nested ON nested.SINGLE_COLLECTION_ROOT = SINGLE_COLLECTION_ROOT.ID
            """;

    public SingleCollectionRootRepositoryFragmentImpl(NamedParameterJdbcOperations JdbcOperations
            , JdbcTemplate jdbcTemplate){

        this.JdbcOperations = JdbcOperations;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<SingleCollectionRoot> findAllBy_NamedParameterJdbcOperations(){

        return JdbcOperations.query(join, new SingleConnectionRootResultsetExtractor());
    }

    @Override
    public List<SingleCollectionRoot> findAllBy_JdbcTemplate(){

        return jdbcTemplate.query(join, new SingleConnectionRootResultsetExtractor());
    }

}
