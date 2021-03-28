package me.feuerente.DAO;

import me.feuerente.UserSearchProperty;
import me.feuerente.entity.User;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

/**
 * Interface that all UserDAOs must support.
 */
public abstract class UserDAO {

    /**
     * Inserts a user.
     *
     * @param user the User to be inserted
     * @return the ID of the newly created User; -1 if the User can't be created
     */
    public abstract boolean insertUser(User user);

    /**
     * Deletes a specified user.
     *
     * @param user the User to be deleted
     * @return true on successful deletion of the User; -1 otherwise
     */
    public abstract boolean deleteUser(User user);

    /**
     * Finds users who have a matching value in the property used for the search.
     *
     * @param searchProperty the property used for finding matching Users
     * @param searchValue    the Value matching Users must have is the property used for the search
     * @return a list of users who match the search criteria; an empty list if no matching users are found
     */
    public List<User> findUsersByProperty(UserSearchProperty searchProperty, Object searchValue) {
        switch (searchProperty) {
            case ID:
                return findUsersById(Integer.parseInt(searchValue.toString()));
            case FIRST_NAME:
                return findUsersByFirstName((String) searchValue);
            case LAST_NAME:
                return findUsersByLastName((String) searchValue);
            case HEIGHT:
                return findUsersByHeight(Integer.parseInt(searchValue.toString()));
            case BIRTHDAY:
                return findUsersByBirthday(LocalDate.parse(searchValue.toString()));
            default:
                System.err.println("Unknown search property!");
                return Collections.emptyList();
        }
    }

    /**
     * Finds users who have a matching birthday.
     *
     * @param birthday the birthday
     * @return a list of users who have a matching birthday; an empty list if no matching users are found
     */
    public abstract List<User> findUsersByBirthday(LocalDate birthday);

    /**
     * Finds users who have a matching height.
     *
     * @param height the height
     * @return a list of users who have a matching height; an empty list if no matching users are found
     */
    public abstract List<User> findUsersByHeight(int height);

    /**
     * Finds users who have a matching last name.
     *
     * @param lastName the last name
     * @return a list of users who have a matching last name; an empty list if no matching users are found
     */
    public abstract List<User> findUsersByLastName(String lastName);

    /**
     * Finds users who have a matching first name.
     *
     * @param firstName the first name
     * @return a list of users who have a matching first name; an empty list if no matching users are found
     */
    public abstract List<User> findUsersByFirstName(String firstName);

    /**
     * Finds users who have a matching id.
     *
     * @param id the id
     * @return a list of users who have a matching id; an empty list if no matching users are found
     */
    public abstract List<User> findUsersById(int id);

    /**
     * Gets all Users.
     *
     * @return a list of all Users
     */
    public abstract List<User> findAll();
}
