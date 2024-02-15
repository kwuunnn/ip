package duke.task;


/**
 * Abstract representation of a task.
 */
public abstract class Task {
    private String task;
    private boolean isDone = false;


    /**
     * Constructor for Task.
     *
     * @param task Task description.
     */
    public Task(String task) {
        this.task = task;
    }


    /**
     * Mark the task as done or not done yet.
     *
     * @param command Mark command or Unmark command.
     */
    public void changeMark(String command) {
        isDone = command.equals("MARK");
    }


    /**
     * Current status of the task.
     *
     * @return True of task is marked as done.
     */
    public boolean getStatus() {
        return isDone;
    }


    /**
     * Format task to store in the Tasks File.
     *
     * @return String representation of the formatted task.
     */
    public String formatTask() {
        return task;
    }


    /**
     * Return the string representation of the task.
     *
     * @return String representation of the task
     */
    @Override
    public String toString() {
        String mark = isDone ? "X" : " ";
        return String.format("[%s] %s", mark, task);
    }


    /**
     * Getter to retrieve the task's description.
     *
     * @return Description of task.
     */
    public String getDescription() {
        return this.task;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Task) {
            Task task = (Task) obj;
            return this.task.equals(task.task);
        } else {
            return false;
        }
    }
}
