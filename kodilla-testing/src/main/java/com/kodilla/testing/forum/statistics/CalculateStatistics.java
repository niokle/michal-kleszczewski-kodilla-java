package com.kodilla.testing.forum.statistics;

public class CalculateStatistics {
    private double numberOfUsers;
    private double numberOfPosts;
    private double numberOfComments;
    private double avgNumerOfPostsPerUser;
    private double avgNumberOfCommentsPerUser;
    private double avgNumberOfCommentsPerPost;

    public double getNumberOfUsers() {
        return numberOfUsers;
    }

    public double getNumberOfPosts() {
        return numberOfPosts;
    }

    public double getNumberOfComments() {
        return numberOfComments;
    }

    public double getAvgNumerOfPostsPerUser() {
        return avgNumerOfPostsPerUser;
    }

    public double getAvgNumberOfCommentsPerUser() {
        return avgNumberOfCommentsPerUser;
    }

    public double getAvgNumberOfCommentsPerPost() {
        return avgNumberOfCommentsPerPost;
    }

    public void calculateAdvStatistics(Statistics statistics) {
        numberOfUsers = statistics.usersNames().size();
        numberOfPosts = statistics.postsCount();
        numberOfComments = statistics.commentsCount();
        avgNumerOfPostsPerUser = numberOfPosts / numberOfUsers;
        avgNumberOfCommentsPerUser = numberOfComments / numberOfUsers;
        avgNumberOfCommentsPerPost = numberOfComments / numberOfPosts;
    }

    public void showStatistics() {
        System.out.println("------------------------------------------------");
        System.out.println("Statystyka:");
        System.out.println("------------------------------------------------");
        System.out.println("liczba użytkowników: " + numberOfUsers);
        System.out.println("liczba postów: " + numberOfPosts);
        System.out.println("liczba komentarzy: " + numberOfComments);
        System.out.println("średnia liczba postów na użytkownika: " + avgNumerOfPostsPerUser);
        System.out.println("średnia liczba komentarzy na użytkownika: " + avgNumberOfCommentsPerUser);
        System.out.println("średnia liczba komentarzy na post: " + avgNumberOfCommentsPerPost);
        System.out.println("------------------------------------------------");
    }
}
