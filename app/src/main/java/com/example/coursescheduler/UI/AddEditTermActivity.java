package com.example.coursescheduler.UI;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursescheduler.Database.ScheduleRepo;
import com.example.coursescheduler.Entity.Term;
import com.example.coursescheduler.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
    private TextView startDate;
    private TextView endDate;
    DatePickerDialog.OnDateSetListener startDP;
    DatePickerDialog.OnDateSetListener endDP;
    final Calendar calendarStart = Calendar.getInstance();
    String dateFormat = "MM/dd/yy";
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.US);
    private RecyclerView recyclerView;
    private ScheduleRepo repository;
    private LiveData<List<Term>> allTerms;
    Term term;


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
        dateFormat = "MM/dd/yy";
        sdf = new SimpleDateFormat(dateFormat, Locale.US);
        startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date date;
                String info = startDate.getText().toString();
                if (info.equals(""))info = "03/03/22";
                try {
                    calendarStart.setTime(sdf.parse(info));
                }catch (ParseException e) {
                    e.printStackTrace();
                }
                new DatePickerDialog(AddEditTermActivity.this, startDP, calendarStart.get(Calendar.YEAR),
                        calendarStart.get(Calendar.MONTH), calendarStart.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        endDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String info = endDate.getText().toString();
                if (info.equals(""))info = "03/04/22";
                try {
                    calendarStart.setTime(sdf.parse(info));
                }catch (ParseException e) {
                    e.printStackTrace();
                }
                new DatePickerDialog(AddEditTermActivity.this, endDP, calendarStart.get(Calendar.YEAR),
                        calendarStart.get(Calendar.MONTH), calendarStart.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        startDP = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                calendarStart.set(Calendar.YEAR, year);
                calendarStart.set(Calendar.MONTH, monthOfYear);
                calendarStart.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabelStart();
            }
        };

        endDP = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                calendarStart.set(Calendar.YEAR, year);
                calendarStart.set(Calendar.MONTH, monthOfYear);
                calendarStart.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabelEnd();
            }
        };

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

    private void updateLabelStart() {startDate.setText(sdf.format(calendarStart.getTime()));}
    private void updateLabelEnd() {
        endDate.setText(sdf.format(calendarStart.getTime()));
    }

    private void saveTerm() {
        String title = termTitle.getText().toString();
        String start = startDate.getText().toString();
        String end = endDate.getText().toString();

        if (title.trim().isEmpty()) {
            Toast.makeText(this, "Please enter a title", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE, title);
        data.putExtra(EXTRA_START, start);
        data.putExtra(EXTRA_END, end);

        int id = getIntent().getIntExtra(EXTRA_ID, -1);
        if (id != -1) {
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
