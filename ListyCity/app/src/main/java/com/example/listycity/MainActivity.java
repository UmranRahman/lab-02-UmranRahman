package com.example.listycity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView cityList;
    ArrayAdapter<String> cityAdaptor;
    ArrayList<String> dataList;

    Button add;
    Button remove;

    Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityList = findViewById(R.id.city_list);

        String[] cities = {"Edmonton", "Dhaka", "Tokyo", "New York", "Delhi"};

        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        cityAdaptor = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdaptor);

        confirm = findViewById(R.id.button);
        confirm.setBackgroundColor(Color.GRAY);
        confirm.setClickable(false);
        // took help from stackoverflow with the link below for both buttons
        //https://developer.android.com/develop/ui/views/components/button#java
        /* Other links that have been used for some other stuff:
        * https://stackoverflow.com/questions/33138862/text-box-in-android
        * https://stackoverflow.com/questions/25002788/add-items-to-an-arrayliststring-that-has-been-passed-between-activities
        * https://stackoverflow.com/questions/5740708/android-clearing-all-edittext-fields-with-clear-button
        * https://www.digitalocean.com/community/tutorials/java-remove-array-elements
        * */
        add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                confirm.setClickable(true);
                confirm.setBackgroundColor(Color.BLUE);

                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText textBox = findViewById(R.id.editTextText2);
                        cityAdaptor.add(textBox.getText().toString());
                        textBox.setText("");
                        confirm.setClickable(false);
                        confirm.setBackgroundColor(Color.GRAY);
                    }
                });

            }
        });

        remove = findViewById(R.id.remove);
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirm.setClickable(true);
                confirm.setBackgroundColor(Color.RED);

                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText textBox = findViewById(R.id.editTextText2);
                        cityAdaptor.remove(textBox.getText().toString());
                        textBox.setText("");
                        confirm.setClickable(false);
                        confirm.setBackgroundColor(Color.GRAY);
                    }
                });

            }
        });
    }
}