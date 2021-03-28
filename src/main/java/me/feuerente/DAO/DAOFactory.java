package me.feuerente.DAO;

/**
 * This class creates specific DAOFactories.
 */
public abstract class DAOFactory {

    public static DAOFactory getDAOFactory(DAOFactoryType factoryType) {
        return switch (factoryType) {
            case MEMORY -> new MemoryDAOFactory();
            case MY_SQL -> new MySqlDAOFactory();
        };
    }

    public abstract UserDAO getUserDAO();
}
