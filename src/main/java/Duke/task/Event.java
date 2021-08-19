package Duke.task;

public class Event extends Task{
    private String at;

    public Event(String content, String at){
        super(content);
        this.at = at;
    }

    public String toString() {
        return "[E]" + super.toString() + " (at:" + at + ")";
    }
}