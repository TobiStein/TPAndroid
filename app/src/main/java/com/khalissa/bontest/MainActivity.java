package com.khalissa.bontest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String message = intent.getStringExtra(DisplayMessageActivity.EXTRA_MESSAGE);

        //Capture the layout TextView and set the string as its text
        TextView textview = findViewById(R.id.prenom);
        textview.setText(message);


        final Button button = findViewById(R.id.valider);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Contact obj = new Contact();

                //get les EditText
                EditText nom = (EditText) findViewById(R.id.nom);
                obj.setNom(nom.getText().toString());

                EditText prenom = (EditText) findViewById(R.id.prenom);
                obj.setPrenom(prenom.getText().toString());

                EditText date = (EditText) findViewById(R.id.date);
                obj.setDate_naissance(date.getText().toString());

                EditText numero = (EditText) findViewById(R.id.numero);
                obj.setNumeroTel(numero.getText().toString());

                EditText mail = (EditText) findViewById(R.id.mail);
                obj.setMail(mail.getText().toString());

                //get RadioButton
                RadioGroup rd = (RadioGroup) findViewById(R.id.genre);
                RadioButton selectedRadioButton = (RadioButton) findViewById(rd.getCheckedRadioButtonId());
                obj.setSexe(selectedRadioButton.getText().toString());

                // Afficher dans un toast
                Context context = getApplicationContext();
                CharSequence text = obj.toString();

                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                Intent intent_contact = new Intent();
                intent_contact.putExtra("newContact", obj);
                setResult(Activity.RESULT_OK, intent_contact);
                finish();
            }
        });
    }
}