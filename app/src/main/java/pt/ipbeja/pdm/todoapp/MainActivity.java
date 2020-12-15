package pt.ipbeja.pdm.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import pt.ipbeja.pdm.todoapp.data.Todo;

public class MainActivity extends AppCompatActivity {


    private TodoAdapter adapter;
    private Toolbar toolbar;
    private View noDataIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        this.noDataIndicator = findViewById(R.id.no_data_indicator);

        RecyclerView list = findViewById(R.id.todo_list);
        FloatingActionButton button = findViewById(R.id.create_todo_btn);


        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        this.adapter = new TodoAdapter();

        list.setLayoutManager(lm);
        list.setAdapter(adapter);


        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, CreateTodoActivity.class);
            startActivity(intent);
        });


    }

    @Override
    protected void onStart() {
        super.onStart();


    }



    public class TodoAdapter extends RecyclerView.Adapter<TodoViewHolder> {

        private List<Todo> data = new ArrayList<>();

        public void setData(List<Todo> data) {
            this.data = data;
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_list_item, parent, false);
            return new TodoViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
            Todo todo = data.get(position);
            holder.bind(todo);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }


    public class TodoViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView description;
        private final CheckBox isDone;
        private Todo todo;

        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.todo_title);
            description = itemView.findViewById(R.id.todo_description);
            isDone = itemView.findViewById(R.id.todo_check_box);

            // Colocamos um change listner na CheckBox para sermos notificados sempre que o seu estado muda
            isDone.setOnCheckedChangeListener((buttonView, isChecked) -> {
                // Sempre que mudar, actualizamos o objecto
                todo.setDone(isChecked);


            });

            itemView.setOnClickListener(v -> {
            });

        }

        public void bind(Todo todo) {
            this.todo = todo;
            title.setText(todo.getTitle());
            description.setText(todo.getDescription());
            isDone.setChecked(todo.isDone());
        }
    }






}