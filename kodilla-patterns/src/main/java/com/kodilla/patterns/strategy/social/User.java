package com.kodilla.patterns.strategy.social;

public class User {
    private String userName;
    protected SocialPublisher socialPublisher;

    public User(String userName) {
        this.userName = userName;
    }

    public String sharePoast(String postText) {
        return postText + " opublikowano na portalu " + socialPublisher.share();
    }

    public void setSocialPublisher(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }

    public String getUserName() {
        return userName;
    }

    public SocialPublisher getSocialPublisher() {
        return socialPublisher;
    }
}
