package ru.job4j.search;

import java.awt.*;
import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();
    public void put(Task task) {
        var index = 0;
        for (Task element : tasks) {
if (task.getPriority() < element.getPriority()) {
    break;
}
index++;
        }
        this.tasks.add(index, task);
    }

    public Task take() {
        return tasks.poll();
    }
}