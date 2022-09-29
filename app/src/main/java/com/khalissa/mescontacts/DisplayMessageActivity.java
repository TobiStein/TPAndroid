package com.khalissa.mescontacts;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    ActivityResultLauncher<Intent> mainActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK){
                    Intent data = result.getData();
                    if (data != null){
                        String testData = data.getStringExtra("newContact");
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        //get the intent that started the activity and extract the string
        Intent intent2 = getIntent();
        String message = intent2.getStringExtra("newContact");

        //Capture the layout TextView and set the string as its text
        TextView textview = findViewById(R.id.textView);
        textview.setText(message);

        final Button button = findViewById(R.id.plus);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(DisplayMessageActivity.this,MainActivity.class);
                intent.putExtra("firstname", "");
                mainActivityResultLauncher.launch(intent);
            }
        });

    }
    /*
    public void openContact(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("firstname", "");
        startActivity(intent);
    }*/

}