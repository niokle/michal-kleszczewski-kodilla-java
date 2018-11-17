package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public class Forum {
    private final List<ForumUser> usersList = new ArrayList<>();

    public List<ForumUser> getUserList() {
        return new ArrayList<>(usersList);
    }
}
