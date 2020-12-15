package pt.ipbeja.pdm.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

import pt.ipbeja.pdm.todoapp.data.Todo;
import pt.ipbeja.pdm.todoapp.data.database.TodoDatabase;

public class ViewTodoActivity extends AppCompatActivity {

    public static final String TODO_ID_KEY = "todo_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_todo);

        // Quando esta activity é criada, devemos ir buscar o ID do Todo a mostrar
        // No caso dos extras primitivos, temos de passar um valor default.
        // Este é o valor devolvido caso não exista um para a chave indicada
        // Uso o -1 para me indicar que é um identificador inválido.
        long todoId = getIntent().getLongExtra(TODO_ID_KEY, -1);

        // Se o ID for inválido, termino de imediato a Activity (não há todo para este id)
        if(todoId == -1){
            finish();
            return;
        }
        // Caso contrário, continuamos

        TextView title = findViewById(R.id.title);
        TextView description = findViewById(R.id.description);
        CheckBox checkBox = findViewById(R.id.done);

        // vamos buscar o Todo para o ID indicado
        Todo todo = TodoDatabase.getInstance(getApplicationContext()).todoDao().get(todoId);

        // E populamos os campos
        title.setText(todo.getTitle());
        description.setText(todo.getDescription());
        checkBox.setChecked(todo.isDone());

        // Da mesma forma que fizemos no ViewHolder, ficamos à escuta de alterações na checkbox e
        // actualizamos o registo da DB sempre que ocorra um desses eventos
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            todo.setDone(isChecked);
            TodoDatabase.getInstance(getApplicationContext()).todoDao().update(todo);
        });

    }

    public static void start(Context context, long todoId) {
        Intent starter = new Intent(context, ViewTodoActivity.class);
        // Temos de colocar o ID nos extras do intent
        starter.putExtra(TODO_ID_KEY, todoId);
        context.startActivity(starter);
    }




}