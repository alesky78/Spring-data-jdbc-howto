package it.spaghettisource.springdatajdbc.howto.createRepository;

/**
 * Fragment interface providing the {@link CustomRepositoryInsertFragment#insert(Object)} signature.
 *
 * @author Jens Schauder
 */
public interface CustomRepositoryInsertFragment<T, ID> {

    /**
     * Custom insert method.
     *
     * @param <T>
     * @return
     */
    T insert(T t);

}
