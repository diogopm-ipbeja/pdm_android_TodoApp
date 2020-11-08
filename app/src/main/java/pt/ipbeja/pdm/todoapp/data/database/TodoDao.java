package pt.ipbeja.pdm.todoapp.data.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import pt.ipbeja.pdm.todoapp.data.Todo;

@Dao
public interface TodoDao {

    @Query("select * from todo")
    List<Todo> getAll();

    @Query("select * from todo where id = :id")
    Todo get(long id);

    @Insert
    long insert(Todo todo);

    @Update
    void update(Todo updatedTodo);
}
