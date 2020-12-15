package pt.ipbeja.pdm.todoapp.data;


public class Todo {

    private long id;

    private String title;
    private String description;
    private boolean isDone;

    public Todo(long id, String title, String description, boolean isDone) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isDone = isDone;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
