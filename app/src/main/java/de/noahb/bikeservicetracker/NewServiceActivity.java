package de.noahb.bikeservicetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ViewAnimator;

import static de.noahb.bikeservicetracker.R.id.new_service_reminder;

public class NewServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_service);

        Intent i = getIntent();
    }

    public void addService(View v){
        EditText name = findViewById(R.id.new_service_name);
        EditText description = findViewById(R.id.new_service_description);
        EditText distance = findViewById(R.id.new_service_distance);
        CheckBox reminder = findViewById(new_service_reminder);

        String n = name.getText().toString();
        String des = description.getText().toString();
        String dis = distance.getText().toString();
        Boolean re = reminder.isActivated();

        if (n.isEmpty() || des.isEmpty() || dis.isEmpty()){
            Toast.makeText(getApplicationContext(), getString(R.string.new_service_input_error), Toast.LENGTH_SHORT).show();
        }

    }
}
