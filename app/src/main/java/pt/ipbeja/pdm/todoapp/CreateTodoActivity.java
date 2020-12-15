package pt.ipbeja.pdm.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import pt.ipbeja.pdm.todoapp.data.Todo;
import pt.ipbeja.pdm.todoapp.data.database.TodoDao;
import pt.ipbeja.pdm.todoapp.data.database.TodoDatabase;

public class CreateTodoActivity extends AppCompatActivity {

    private EditText titleInput;
    private EditText descriptionInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_todo);

        titleInput = findViewById(R.id.todo_title);
        descriptionInput = findViewById(R.id.todo_description);

        ExtendedFloatingActionButton btn = findViewById(R.id.create_todo_btn);


        btn.setOnClickListener(v -> {
            String title = titleInput.getText().toString();
            String description = descriptionInput.getText().toString();

            // Criar um objecto da class Todo
            Todo todo = new Todo(0, title, description, false);

            // E pedir ao DAO que o insira na BD
            TodoDatabase
                    .getInstance(getApplicationContext())
                    .todoDao()
                    .insert(todo);
            // Depois podemos terminar esta activity
            finish();

        });

    }
}