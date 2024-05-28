package it.spaghettisource.springdatajdbc.howto.nPlu1;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleConnectionRootResultsetExtractor implements ResultSetExtractor<List<SingleCollectionRoot>> {
    @Override
    public List<SingleCollectionRoot> extractData(ResultSet rs) throws SQLException, DataAccessException {

        Map<Long,SingleCollectionRoot> map = new HashMap<>();

        SingleCollectionRoot actual = null;
        Long id;
        while(rs.next()){

            //populate the root
            id = rs.getLong("id");
            actual = map.get(id);
            if(actual== null){
                actual = new SingleCollectionRoot();
                actual.setId(id);
                map.put(id,actual);
            }


            //populate the children
            SingleCollectionNestedMany child = new SingleCollectionNestedMany();
            child.setElement(rs.getString("element"));
            actual.add(child);
        }
        return map.values().stream().toList();
    }
}
