package duke;

import duke.task.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskList {
    private ArrayList<Task> taskList = new ArrayList<>();

    public TaskList(ArrayList<Task> taskList) {
        this.taskList.addAll(taskList);
    }
    public int getLength() {
        return this.taskList.size();
    }

    public boolean isEmpty() {
        return this.taskList.size() == 0;
    }

    public void add(Task task) {
        this.taskList.add(task);
    }

    public void remove(int taskId) {
        this.taskList.remove(taskId - 1);
    }


    public Task get(int taskId) {
        return this.taskList.get(taskId - 1);
    }

    public TaskList filter(String keyword) {
        List<Task> filteredTasks = this.taskList.stream()
                .filter(t -> t.getDescription().contains(keyword))
                .collect(Collectors.toList());

        return new TaskList(new ArrayList<>(filteredTasks));
    }
}
