package it.spaghettisource.springdatajdbc.howto.createRepository;

/**
 * Fragment interface providing the {@link CustomRepositoryFragment#insert(Object)} signature.
 *
 * @author Jens Schauder
 */
public interface CustomRepositoryFragment<T, ID> {

    /**
     * Custom insert method.
     *
     * @param <T>
     * @return
     */
    T insert(T t);

    /**
     * Custom update method.
     *
     * @param <T>
     * @return
     */
    void update(T t);


}
