package com.example.parcial1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private LinearLayout taskListLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskListLayout = findViewById(R.id.taskListLayout);
        Button addTaskButton = findViewById(R.id.addTaskButton);

        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewTask("Nueva Tarea");
            }
        });
    }

    // Método para agregar una nueva tarea dinámicamente
    private void addNewTask(String taskName) {
        // Crear un nuevo LinearLayout horizontal para la tarea
        LinearLayout taskLayout = new LinearLayout(this);
        taskLayout.setOrientation(LinearLayout.HORIZONTAL);

        // Agregar un ImageView (ícono) a la tarea
        ImageView taskIcon = new ImageView(this);
        taskIcon.setImageResource(R.drawable.ic_task);  // Asegúrate de tener un ícono en tu carpeta drawable
        taskLayout.addView(taskIcon);

        // Agregar un TextView para el nombre de la tarea
        TextView taskTextView = new TextView(this);
        taskTextView.setText(taskName);
        taskTextView.setTextSize(18f);
        taskLayout.addView(taskTextView);

        // Agregar un Button para completar/eliminar la tarea
        Button completeButton = new Button(this);
        completeButton.setText("Completada");
        completeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskListLayout.removeView(taskLayout);
            }
        });
        taskLayout.addView(completeButton);

        // Añadir el nuevo taskLayout al layout de la lista de tareas
        taskListLayout.addView(taskLayout);
    }
}
