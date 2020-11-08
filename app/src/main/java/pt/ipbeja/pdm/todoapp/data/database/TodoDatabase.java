package pt.ipbeja.pdm.todoapp.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import pt.ipbeja.pdm.todoapp.data.Todo;

@Database(entities = {Todo.class}, version = 1, exportSchema = false)
public abstract class TodoDatabase extends RoomDatabase {

    private static TodoDatabase instance;

    public static TodoDatabase getInstance(Context context) {
        if(instance == null) {
            instance = Room
                    .databaseBuilder(context, TodoDatabase.class, "todo_db")
                    .allowMainThreadQueries()
                    .build();
        }

        return instance;
    }

    public abstract TodoDao todoDao();
}
