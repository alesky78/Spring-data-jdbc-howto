package it.spaghettisource.springdatajdbc.howto.nPlu1;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

import java.util.List;

public class SingleCollectionRootRepositoryFragmentImpl implements SingleCollectionRootRepositoryFragment{

    private final NamedParameterJdbcOperations template;


    public SingleCollectionRootRepositoryFragmentImpl(NamedParameterJdbcOperations template) {
        this.template = template;
    }

    @Override
    public List<SingleCollectionRoot> findAllBy_NamedParameterJdbcOperations(){

        String join = """
                        SELECT SINGLE_COLLECTION_ROOT.ID AS ID, SINGLE_COLLECTION_ROOT.NAME AS NAME,  
                        nested.ELEMENT AS ELEMENT
                        FROM SINGLE_COLLECTION_ROOT LEFT OUTER JOIN SINGLE_COLLECTION_NESTED_MANY nested ON nested.SINGLE_COLLECTION_ROOT = SINGLE_COLLECTION_ROOT.ID
                      """;

        return template.query(join, new SingleConnectionRootResultsetExtractor());
    }

}
