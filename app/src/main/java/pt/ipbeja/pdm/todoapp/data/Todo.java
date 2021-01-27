package pt.ipbeja.pdm.todoapp.data;


import com.google.firebase.firestore.Exclude;

public class Todo {

    private String title;
    private String description;
    private boolean isDone;
    private String firestoreId;

    public Todo() { }

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

    public void setFirestoreId(String id) {
        this.firestoreId = id;
    }

    public Todo withFirestoreId(String id) {
        this.firestoreId = id;ma
        return this;
    }

    @Exclude
    public String getFirestoreId() {
        return firestoreId;
    }
}
