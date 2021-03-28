package me.feuerente.DAO;

/**
 * Im memory concrete {@link DAOFactory} implementation.
 */
public class MemoryDAOFactory extends DAOFactory {

    @Override
    public UserDAO getUserDAO() {
        return new MemoryUserDAO();
    }
}
