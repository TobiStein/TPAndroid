package com.khalissa.bontest;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DisplayMessageActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.exemple.myfirstapp.MESSAGE";

    List<Contact> list = new ArrayList<Contact>();
    CustomListAdapter adapter;

    ActivityResultLauncher<Intent> mainActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK){
                    Intent data = result.getData();
                    if (data != null){
                        Contact listIt = (Contact) data.getSerializableExtra("newContact");
                        list.add(listIt);
                        adapter.notifyDataSetChanged();
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        //List<Contact> list = new ArrayList<Contact>();
        list = getListContact();

        //get the intent that started the activity and extract the string
        Intent intent2 = getIntent();
        /*
        //Capture the layout TextView and set the string as its text
        TextView textview = findViewById(R.id.textView);
        textview.setText(message);
        */
        final ListView listView = (ListView) findViewById(R.id.listView);
        adapter = new CustomListAdapter(this, list);
        listView.setAdapter(adapter);

        // When the user clicks on the ListItem
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                Contact cont = (Contact) o;
                Toast.makeText(DisplayMessageActivity.this, "Selected :" + " " + cont, Toast.LENGTH_LONG).show();
            }
        });

        final Button button = findViewById(R.id.plus);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(DisplayMessageActivity.this,MainActivity.class);
                intent.putExtra(EXTRA_MESSAGE, "firstname");
                mainActivityResultLauncher.launch(intent);
            }
        });

    }

    private List<Contact>getListContact(){
        List<Contact> list = new ArrayList<Contact>();
        Contact moi = new Contact("rhoulam", "khalissa", "femme", "06-02-2002", "0652496577", "khalissa.rhoulam@gmail.com");
        list.add(moi);
        return  list;
    }
}