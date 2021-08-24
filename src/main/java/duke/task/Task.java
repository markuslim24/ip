package duke.task;

/**
 * Represents a task.
 */
public class Task {
    private final String content;
    private boolean isCompleted;

    /**
     * Constructor for a task.
     * @param content The task main content.
     */
    public Task(String content) {
        this.content = content;
        this.isCompleted = false;
    }

    /**
     * Returns true if task is marked completed.
     * @return
     */
    public boolean isComplete() {
        return this.isCompleted;
    }

    /**
     * Marks the task as complete.
     */
    public void markComplete() {
        this.isCompleted = true;
    }

    /**
     * String representation of a task.
     * @return Task in string.
     */
    @Override
    public String toString() {
        String cross = this.isCompleted ? "X" : " ";
        return "[" + cross + "]" + this.content;
    }

    /**
     * String representation of a task for storage.
     * @return Task in String(Storage format).
     */
    public String toStorageString() {
        String done = isCompleted ? "1" : "0";
        String s = String.format("| %s | %s", done, content);
        return s;
    }

}
