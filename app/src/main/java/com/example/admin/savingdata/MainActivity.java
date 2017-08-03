package com.example.admin.savingdata;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    TextView textView, personName, personGender;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.etname);
        textView = (TextView) findViewById(R.id.tvName);
        personName = (TextView) findViewById(R.id.PersonName);
        personGender = (TextView) findViewById(R.id.PersonGender);

    }

    public void changeText(View view) {
        String data = editText.getText().toString();
        textView.setText(data);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        String data = textView.getText().toString();
        outState.putString("data", data);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        textView.setText(savedInstanceState.getString("data"));
    }

    public void doSomething(View view){
        switch (view.getId()){

            case R.id.btnChangeText:
                break;

            case R.id.btnGoToSecond:

                Intent intent = new Intent(this, Main2Activity.class);
                intent.putExtra("person", new Person(personName.getText().toString(), personGender.getText().toString()));
                startActivity(intent);

                break;
            case R.id.shareData:

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "this is a message");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);

        }
    }
}