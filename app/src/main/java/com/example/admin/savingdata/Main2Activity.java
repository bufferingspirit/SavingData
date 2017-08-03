package com.example.admin.savingdata;

import android.content.Intent;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private static final String TAG = "second";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Person person = getIntent().getParcelableExtra("person");
        Log.d(TAG, "onCreate: " + person.getName());

        Toast.makeText(this, person.getName(), Toast.LENGTH_SHORT).show();


    }
}
