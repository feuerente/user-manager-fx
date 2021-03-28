package me.feuerente;

import me.feuerente.entity.User;

import java.time.LocalDate;

/**
 * Represents a row in the table view.
 * It wraps a {@link User} and is port af the View-Model.
 */
public class UserTableRow {

    private final User user;

    public UserTableRow(User user) {
        this.user = user;
    }

    public int getId() {
        return user.getId();
    }

    public void setId(int id) {
        user.setId(id);
    }

    public String getFirstName() {
        return user.getFirstName();
    }

    public void setFirstName(String firstName) {
        user.setFirstName(firstName);
    }

    public String getLastName() {
        return user.getLastName();
    }

    public void setLastName(String lastName) {
        user.setLastName(lastName);
    }

    public int getHeightInCM() {
        return user.getHeightInCM();
    }

    public void setHeightInCM(int heightInCM) {
        user.setHeightInCM(heightInCM);
    }

    public LocalDate getBirthday() {
        return user.getBirthday();
    }

    public void setBirthday(LocalDate birthday) {
        user.setBirthday(birthday);
    }
}
