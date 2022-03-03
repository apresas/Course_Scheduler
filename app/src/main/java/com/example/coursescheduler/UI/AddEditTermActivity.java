package com.example.coursescheduler.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursescheduler.Entity.Term;
import com.example.coursescheduler.R;

public class AddEditTermActivity extends AppCompatActivity {


    public static final String EXTRA_ID =
            "com.example.coursescheduler.EXTRA_ID";
    public static final String EXTRA_TITLE =
            "com.example.coursescheduler.EXTRA_TITLE";
    public static final String EXTRA_START =
            "com.example.coursescheduler.EXTRA_START";
    public static final String EXTRA_END =
            "com.example.coursescheduler.EXTRA_END";

    private TextView editTermID;
    private EditText termTitle;
    private EditText startDate;
    private EditText endDate;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_term);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        editTermID = findViewById(R.id.edit_text_termID);
        termTitle = findViewById(R.id.edit_text_termTitle);
        startDate = findViewById(R.id.editStart);
        endDate = findViewById(R.id.editEnd);
        RecyclerView recyclerView = findViewById(R.id.termRecycler_view);


        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        Intent intent = getIntent();

        if(intent.hasExtra(EXTRA_ID)) {
            setTitle("Edit Term");
            editTermID.setText(intent.getStringExtra(EXTRA_ID));
            termTitle.setText(intent.getStringExtra(EXTRA_TITLE));
            startDate.setText(intent.getStringExtra(EXTRA_START));
            endDate.setText(intent.getStringExtra(EXTRA_END));
        } else {
            setTitle("Add Term");
        }
    }

    private void saveTerm() {
//        String termID = editTermID.getText().toString();
        int termID = Integer.parseInt(editTermID.getText().toString());
        String title = termTitle.getText().toString();
        String start = startDate.getText().toString();
        String end = endDate.getText().toString();

        if (title.trim().isEmpty()) {
            Toast.makeText(this, "Please enter a title", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_ID, termID);
        data.putExtra(EXTRA_TITLE, title);
        data.putExtra(EXTRA_START, start);
        data.putExtra(EXTRA_END, end);


        int id = getIntent().getIntExtra(EXTRA_ID, -1);
        if(id != -1) {
            data.putExtra(EXTRA_ID, id);
        }

        setResult(RESULT_OK, data);
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_terms_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_term:
                saveTerm();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
