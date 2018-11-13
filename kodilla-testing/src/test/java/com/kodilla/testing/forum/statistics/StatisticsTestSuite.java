package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatisticsTestSuite {

    @Test
    public void testStatisticsWithMockNumberOfPosts0() {
        Statistics statisticsMock = mock(Statistics.class);
        int numberOfPosts = 0;
        int numberOfComments = 10;
        List<String> usersNames = new LinkedList<>();

        for (int i = 1; i <= 1000; i++) {
            usersNames.add("user" + i);
        }

        when(statisticsMock.postsCount()).thenReturn(numberOfPosts);
        when(statisticsMock.commentsCount()).thenReturn(numberOfComments);
        when(statisticsMock.usersNames()).thenReturn(usersNames);

        CalculateStatistics calculateStatistics = new CalculateStatistics();
        calculateStatistics.calculateAdvStatistics(statisticsMock);

        Assert.assertEquals(1000, calculateStatistics.getNumberOfUsers(),0);
        Assert.assertEquals(0, calculateStatistics.getNumberOfPosts(),0);
        Assert.assertEquals(10, calculateStatistics.getNumberOfComments(),0);
        Assert.assertEquals(0, calculateStatistics.getAvgNumerOfPostsPerUser(), 0);
        Assert.assertEquals(0.01, calculateStatistics.getAvgNumberOfCommentsPerUser(),0);
        Assert.assertEquals(Double.POSITIVE_INFINITY, calculateStatistics.getAvgNumberOfCommentsPerPost(),0);
    }

    @Test
    public void testStatisticsWithMockNumberOfPosts1000() {
        Statistics statisticsMock = mock(Statistics.class);
        int numberOfPosts = 1000;
        int numberOfComments = 10;
        List<String> usersNames = new LinkedList<>();

        for (int i = 1; i <= 1000; i++) {
            usersNames.add("user" + i);
        }

        when(statisticsMock.postsCount()).thenReturn(numberOfPosts);
        when(statisticsMock.commentsCount()).thenReturn(numberOfComments);
        when(statisticsMock.usersNames()).thenReturn(usersNames);

        CalculateStatistics calculateStatistics = new CalculateStatistics();
        calculateStatistics.calculateAdvStatistics(statisticsMock);

        Assert.assertEquals(1000, calculateStatistics.getNumberOfUsers(),0);
        Assert.assertEquals(1000, calculateStatistics.getNumberOfPosts(),0);
        Assert.assertEquals(10 , calculateStatistics.getNumberOfComments(),0);
        Assert.assertEquals(1, calculateStatistics.getAvgNumerOfPostsPerUser(),0);
        Assert.assertEquals(0.01, calculateStatistics.getAvgNumberOfCommentsPerUser(),0);
        Assert.assertEquals(0.01, calculateStatistics.getAvgNumberOfCommentsPerPost(),0);
    }

    @Test
    public void testStatisticsWithMockNumberOfComments0() {
        Statistics statisticsMock = mock(Statistics.class);
        int numberOfPosts = 1000;
        int numberOfComments = 0;
        List<String> usersNames = new LinkedList<>();

        for (int i = 1; i <= 1000; i++) {
            usersNames.add("user" + i);
        }

        when(statisticsMock.postsCount()).thenReturn(numberOfPosts);
        when(statisticsMock.commentsCount()).thenReturn(numberOfComments);
        when(statisticsMock.usersNames()).thenReturn(usersNames);

        CalculateStatistics calculateStatistics = new CalculateStatistics();
        calculateStatistics.calculateAdvStatistics(statisticsMock);

        Assert.assertEquals(1000, calculateStatistics.getNumberOfUsers(),0);
        Assert.assertEquals(1000, calculateStatistics.getNumberOfPosts(),0);
        Assert.assertEquals(0 , calculateStatistics.getNumberOfComments(),0);
        Assert.assertEquals(1, calculateStatistics.getAvgNumerOfPostsPerUser(),0);
        Assert.assertEquals(0, calculateStatistics.getAvgNumberOfCommentsPerUser(),0);
        Assert.assertEquals(0, calculateStatistics.getAvgNumberOfCommentsPerPost(),0);
    }

    @Test
    public void testStatisticsWithMockNumberOfCommentsLessThenPosts() {
        Statistics statisticsMock = mock(Statistics.class);
        int numberOfPosts = 1000;
        int numberOfComments = 500;
        List<String> usersNames = new LinkedList<>();

        for (int i = 1; i <= 1000; i++) {
            usersNames.add("user" + i);
        }

        when(statisticsMock.postsCount()).thenReturn(numberOfPosts);
        when(statisticsMock.commentsCount()).thenReturn(numberOfComments);
        when(statisticsMock.usersNames()).thenReturn(usersNames);

        CalculateStatistics calculateStatistics = new CalculateStatistics();
        calculateStatistics.calculateAdvStatistics(statisticsMock);

        Assert.assertEquals(1000, calculateStatistics.getNumberOfUsers(),0);
        Assert.assertEquals(1000, calculateStatistics.getNumberOfPosts(),0);
        Assert.assertEquals(500 , calculateStatistics.getNumberOfComments(),0);
        Assert.assertEquals(1, calculateStatistics.getAvgNumerOfPostsPerUser(),0);
        Assert.assertEquals(0.5, calculateStatistics.getAvgNumberOfCommentsPerUser(),0);
        Assert.assertEquals(0.5, calculateStatistics.getAvgNumberOfCommentsPerPost(),0);
    }

    @Test
    public void testStatisticsWithMockNumberOfCommentsMoreThenPosts() {
        Statistics statisticsMock = mock(Statistics.class);
        int numberOfPosts = 500;
        int numberOfComments = 1000;
        List<String> usersNames = new LinkedList<>();

        for (int i = 1; i <= 1000; i++) {
            usersNames.add("user" + i);
        }

        when(statisticsMock.postsCount()).thenReturn(numberOfPosts);
        when(statisticsMock.commentsCount()).thenReturn(numberOfComments);
        when(statisticsMock.usersNames()).thenReturn(usersNames);

        CalculateStatistics calculateStatistics = new CalculateStatistics();
        calculateStatistics.calculateAdvStatistics(statisticsMock);

        Assert.assertEquals(1000, calculateStatistics.getNumberOfUsers(),0);
        Assert.assertEquals(500, calculateStatistics.getNumberOfPosts(),0);
        Assert.assertEquals(1000 , calculateStatistics.getNumberOfComments(),0);
        Assert.assertEquals(0.5, calculateStatistics.getAvgNumerOfPostsPerUser(),0);
        Assert.assertEquals(1, calculateStatistics.getAvgNumberOfCommentsPerUser(),0);
        Assert.assertEquals(2, calculateStatistics.getAvgNumberOfCommentsPerPost(),0);
    }

    @Test
    public void testStatisticsWithMockNumberOfUsers0() {
        Statistics statisticsMock = mock(Statistics.class);
        int numberOfPosts = 500;
        int numberOfComments = 1000;
        List<String> usersNames = new LinkedList<>();

        when(statisticsMock.postsCount()).thenReturn(numberOfPosts);
        when(statisticsMock.commentsCount()).thenReturn(numberOfComments);
        when(statisticsMock.usersNames()).thenReturn(usersNames);

        CalculateStatistics calculateStatistics = new CalculateStatistics();
        calculateStatistics.calculateAdvStatistics(statisticsMock);

        Assert.assertEquals(0, calculateStatistics.getNumberOfUsers(),0);
        Assert.assertEquals(500, calculateStatistics.getNumberOfPosts(),0);
        Assert.assertEquals(1000 , calculateStatistics.getNumberOfComments(),0);
        Assert.assertEquals(Double.POSITIVE_INFINITY, calculateStatistics.getAvgNumerOfPostsPerUser(),0);
        Assert.assertEquals(Double.POSITIVE_INFINITY, calculateStatistics.getAvgNumberOfCommentsPerUser(),0);
        Assert.assertEquals(2, calculateStatistics.getAvgNumberOfCommentsPerPost(),0);
    }

    @Test
    public void testStatisticsWithMockNumberOfUsers100() {
        Statistics statisticsMock = mock(Statistics.class);
        int numberOfPosts = 500;
        int numberOfComments = 1000;
        List<String> usersNames = new LinkedList<>();

        for (int i = 1; i <= 100; i++) {
            usersNames.add("user" + i);
        }

        when(statisticsMock.postsCount()).thenReturn(numberOfPosts);
        when(statisticsMock.commentsCount()).thenReturn(numberOfComments);
        when(statisticsMock.usersNames()).thenReturn(usersNames);

        CalculateStatistics calculateStatistics = new CalculateStatistics();
        calculateStatistics.calculateAdvStatistics(statisticsMock);

        Assert.assertEquals(100, calculateStatistics.getNumberOfUsers(),0);
        Assert.assertEquals(500, calculateStatistics.getNumberOfPosts(),0);
        Assert.assertEquals(1000 , calculateStatistics.getNumberOfComments(),0);
        Assert.assertEquals(5, calculateStatistics.getAvgNumerOfPostsPerUser(),0);
        Assert.assertEquals(10, calculateStatistics.getAvgNumberOfCommentsPerUser(),0);
        Assert.assertEquals(2, calculateStatistics.getAvgNumberOfCommentsPerPost(),0);
    }
}
