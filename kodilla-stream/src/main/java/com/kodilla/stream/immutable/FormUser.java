package com.kodilla.stream.immutable;

public class FormUser {
    final private String userName;
    final private String realName;

    public FormUser(final String userName, final String realName) {
        this.userName = userName;
        this.realName = realName;
    }

    public String getUserName() {
        return userName;
    }

    public String getRealName() {
        return realName;
    }
}
