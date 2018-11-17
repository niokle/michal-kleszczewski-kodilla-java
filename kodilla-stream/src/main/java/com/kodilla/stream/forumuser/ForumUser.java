package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.Objects;

public class ForumUser {
    private final int userID;
    private final String userName;
    private final char sex;
    private final LocalDate dateOfBirth;
    private final int numberOfPosts;

    public ForumUser(final int userID, final String userName, final char sex, final LocalDate dateOfBirth, final int numberOfPosts) {
        this.userID = userID;
        this.userName = userName;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.numberOfPosts = numberOfPosts;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                ", numberOfPosts=" + numberOfPosts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForumUser forumUser = (ForumUser) o;
        return getUserID() == forumUser.getUserID() &&
                getSex() == forumUser.getSex() &&
                getNumberOfPosts() == forumUser.getNumberOfPosts() &&
                Objects.equals(getUserName(), forumUser.getUserName()) &&
                Objects.equals(getDateOfBirth(), forumUser.getDateOfBirth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserID(), getUserName(), getSex(), getDateOfBirth(), getNumberOfPosts());
    }
}
