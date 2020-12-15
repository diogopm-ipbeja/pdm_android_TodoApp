package pt.ipbeja.pdm.todoapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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


        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
        });

    }

    public static void start(Context context, long todoId) {
        Intent starter = new Intent(context, ViewTodoActivity.class);
        // Temos de colocar o ID nos extras do intent
        starter.putExtra(TODO_ID_KEY, todoId);
        context.startActivity(starter);
    }




}