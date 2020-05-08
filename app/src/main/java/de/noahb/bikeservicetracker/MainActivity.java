package de.noahb.bikeservicetracker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = getApplicationContext();
        if (context.fileList().length == 0){
            IO.initFiles(1000, context);
        }

        System.out.println(context.fileList()[0]);
    }

    public void newService(View v){
        Intent i = new Intent(this, NewServiceActivity.class);
        startActivity(i);
    }

    public void showPending(View v){
        ArrayList<String> list;

        try {
            list = IO.getFileContent(getApplicationContext());
        } catch (FileNotFoundException e){
            e.printStackTrace();
            return;
        }

        for(String s : list){
            System.out.println(s);
        }

    }

}
