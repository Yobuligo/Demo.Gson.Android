package com.yobuligo.demogsonandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yobuligo.demogsonandroid.model.Gender;
import com.yobuligo.demogsonandroid.model.Person;

public class MainActivity extends AppCompatActivity {

    EditText editTextToJson;
    EditText editTextFromJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextToJson = findViewById(R.id.text_to_json);
        editTextFromJson = findViewById(R.id.text_from_json);

        Button button = findViewById(R.id.btn_from_json);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromJson();
            }
        });

        button = findViewById(R.id.btn_to_json);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toJson();
            }
        });
    }

    private void toJson() {
        Person person = createInitialPerson();
        Gson gson = new Gson();
        editTextToJson.setText(gson.toJson(person));
    }

    private void fromJson() {
        Gson gson = new Gson();
        String json = editTextToJson.getText().toString();
        Person person = gson.fromJson(json, new TypeToken<Person>() {
        }.getType());

        if (person == null) {
            Toast.makeText(this, "Person is null", Toast.LENGTH_LONG).show();
            editTextFromJson.setText("");
            return;
        }

        editTextFromJson.setText(person.showMe());
    }

    private Person createInitialPerson() {
        Person person = new Person();
        person.setFirstname("Marianne");
        person.setLastname("Schmidt");
        person.setGender(Gender.female);
        person.setId(Long.valueOf(1));
        return person;
    }
}
