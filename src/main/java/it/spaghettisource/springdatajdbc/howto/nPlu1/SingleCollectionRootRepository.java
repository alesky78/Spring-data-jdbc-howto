package it.spaghettisource.springdatajdbc.howto.nPlu1;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface SingleCollectionRootRepository extends ListCrudRepository<SingleCollectionRoot,Long>, SingleCollectionRootRepositoryFragment {

    @Query(value = """
            SELECT SINGLE_COLLECTION_ROOT.ID AS ID, SINGLE_COLLECTION_ROOT.NAME AS NAME,  
            nested.ELEMENT AS ELEMENT
            FROM SINGLE_COLLECTION_ROOT LEFT OUTER JOIN SINGLE_COLLECTION_NESTED_MANY nested ON nested.SINGLE_COLLECTION_ROOT = SINGLE_COLLECTION_ROOT.ID
            """, resultSetExtractorClass = SingleConnectionRootResultsetExtractor.class)
    List<SingleCollectionRoot> findAllBy_SingleQuery_ByExtractor();


}
