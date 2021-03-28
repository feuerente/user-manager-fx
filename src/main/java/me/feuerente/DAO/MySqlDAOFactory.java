package me.feuerente.DAO;

/**
 * Concrete {@link DAOFactory} implementation using a MySQL database.
 */
public class MySqlDAOFactory extends DAOFactory {

    @Override
    public UserDAO getUserDAO() {
        return new MySqlUserDAO();
    }
}
