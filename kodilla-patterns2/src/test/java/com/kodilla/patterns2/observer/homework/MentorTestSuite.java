package com.kodilla.patterns2.observer.homework;

import org.junit.Assert;
import org.junit.Test;

public class MentorTestSuite {
    @Test
    public void testMentorUpdate() {
        //given
        Task task1 = new Task(1, "zadanie 1", "rozwiazanie zadania 1");
        Task task2 = new Task(2, "zadanie 2", "rozwiazanie zadania 2");
        Task task3 = new Task(3, "zadanie 3", "rozwiazanie zadania 3");
        Task task4 = new Task(4, "zadanie 4", "rozwiazanie zadania 4");
        Task task5 = new Task(5, "zadanie 5", "rozwiazanie zadania 5");
        Task task6 = new Task(6, "zadanie 6", "rozwiazanie zadania 6");
        Task task7 = new Task(7, "zadanie 7", "rozwiazanie zadania 7");
        Task task8 = new Task(8, "zadanie 8", "rozwiazanie zadania 8");
        Task task9 = new Task(9, "zadanie 9", "rozwiazanie zadania 9");
        Task task10 = new Task(10, "zadanie 10", "rozwiazanie zadania 10");
        TasksDone tasksDoneMichal = new TasksDone("Michal");
        TasksDone tasksDoneOla = new TasksDone("Ola");
        TasksDone tasksDonePiotrek = new TasksDone("Piotrek");
        TasksDone tasksDoneEwa = new TasksDone("Ewa");
        TasksDone tasksDonePawel = new TasksDone("Pawel");
        Mentor mentorJarema = new Mentor("Jarema");
        Mentor mentorAndrzej = new Mentor("Andrzej");
        tasksDoneMichal.registerObserver(mentorJarema);
        tasksDoneOla.registerObserver(mentorAndrzej);
        tasksDonePiotrek.registerObserver(mentorJarema);
        tasksDoneEwa.registerObserver(mentorAndrzej);
        tasksDonePawel.registerObserver(mentorJarema);

        //when
        tasksDoneMichal.addTask(task1);
        tasksDoneMichal.addTask(task2);
        tasksDoneMichal.addTask(task3);
        tasksDoneOla.addTask(task4);
        tasksDoneOla.addTask(task5);
        tasksDonePiotrek.addTask(task6);
        tasksDoneEwa.addTask(task7);
        tasksDoneEwa.addTask(task8);
        tasksDoneEwa.addTask(task9);
        tasksDonePawel.addTask(task10);

        //then
        Assert.assertEquals(5, mentorJarema.getTasksCount());
        Assert.assertEquals(5, mentorAndrzej.getTasksCount());
    }

}