package me.feuerente.DAO;

import me.feuerente.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the {@link UserDAO} interface with a MySQL database.
 */
public class MySqlUserDAO extends UserDAO {

    MySqlConnection connection;

    /**
     * Class constructor.
     * Instantiates a connection;
     */
    public MySqlUserDAO() {
        this.connection = new MySqlConnection();
    }

    @Override
    public boolean insertUser(User user) {
        try {
            connection.openConnection();

            String sql = "INSERT INTO user_app.users (idusers, firstname, lastname, heightInCM, birthday) VALUES ('"
                    + "0" + "', '"   // Insert zero to use the AUTO_INCREMENT feature
                    + user.getFirstName() + "', '"
                    + user.getLastName() + "', '"
                    + user.getHeightInCM() + "', '"
                    + user.getBirthday().toString() + "');";

            return connection.update(sql);
        } catch (Exception ex) {
            return false;
        } finally {
            connection.closeConnection();
        }
    }

    @Override
    public boolean deleteUser(User user) {
        try {
            String sql = "DELETE FROM user_app.users WHERE (idusers = '" + user.getId() + "')";
            connection.openConnection();
            return connection.update(sql);

        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        } finally {
            connection.closeConnection();
        }
    }

    @Override
    public List<User> findUsersByBirthday(LocalDate birthday) {
        return findByWhere("birthday LIKE '" + birthday + "'");
    }

    @Override
    public List<User> findUsersByHeight(int height) {
        return findByWhere("heightInCM = " + height);
    }

    @Override
    public List<User> findUsersByLastName(String lastName) {
        return findByWhere("lastname LIKE '" + lastName + "'");
    }

    @Override
    public List<User> findUsersByFirstName(String firstName) {
        return findByWhere("firstname LIKE '" + firstName + "'");
    }

    @Override
    public List<User> findUsersById(int id) {
        return findByWhere("idusers = " + id);
    }

    private List<User> findByWhere(String whereStr) {
        List<User> foundUsers = new ArrayList<>();
        ResultSet resultSet;

        String sql = "SELECT idusers, firstname, lastname, heightInCM, birthday FROM user_app.users";
        if (whereStr != null) {
            sql += " WHERE " + whereStr;
        }

        try {
            connection.openConnection();

            resultSet = connection.read(sql);

            while (resultSet.next()) {
                User foundUser = new User();
                foundUser.setId(Integer.parseInt(resultSet.getString("idusers")));
                foundUser.setFirstName(resultSet.getString("firstname"));
                foundUser.setLastName(resultSet.getString("lastname"));
                foundUser.setHeightInCM(Integer.parseInt(resultSet.getString("heightInCM")));
                foundUser.setBirthday(LocalDate.parse(resultSet.getString("birthday")));
                foundUsers.add(foundUser);
            }
            return foundUsers;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        } finally {
            connection.closeConnection();
        }
    }

    @Override
    public List<User> findAll() {
        return findByWhere(null);
    }
}
