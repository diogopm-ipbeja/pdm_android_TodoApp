package pt.ipbeja.pdm.todoapp.data;


public class Todo {

    private String title;
    private String description;
    private boolean isDone;

    public Todo(String title, String description, boolean isDone) {
        this.title = title;
        this.description = description;
        this.isDone = isDone;
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
