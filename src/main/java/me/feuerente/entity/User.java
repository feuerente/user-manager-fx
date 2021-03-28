package me.feuerente.entity;

import java.time.LocalDate;

/**
 * Represents a User.
 * Is part of the model.
 */
public class User implements java.io.Serializable {

    /**
     * -1 marks an invalid id.
     */
    private int id;
    private String firstName;
    private String lastName;
    private int heightInCM;
    private LocalDate birthday;

    /**
     * Creates a User with all attributes except an id.
     *
     * @param firstName  the first name
     * @param lastName   the last name
     * @param heightInCM the height in cm
     * @param birthday   the birthday
     */
    public User(String firstName, String lastName, int heightInCM, LocalDate birthday) {
        this.id = -1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.heightInCM = heightInCM;
        this.birthday = birthday;
    }

    public User() {
    }

    /**
     * Create a User with all attributes.
     *
     * @param id         the id of the user
     * @param firstName  the first name
     * @param lastName   the last name
     * @param heightInCM the height in cm
     * @param birthday   the birthday
     */
    public User(int id, String firstName, String lastName, int heightInCM, LocalDate birthday) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.heightInCM = heightInCM;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getHeightInCM() {
        return heightInCM;
    }

    public void setHeightInCM(int heightInCM) {
        this.heightInCM = heightInCM;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", heightInCM=" + heightInCM +
                ", birthday=" + birthday +
                '}';
    }
}
