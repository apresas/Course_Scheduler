package com.example.coursescheduler.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.coursescheduler.Database.ScheduleRepo;
import com.example.coursescheduler.Entity.Term;
import com.example.coursescheduler.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void enterHere(View view) {
        Intent intent = new Intent(MainActivity.this, TermActivity.class);
        startActivity(intent);

//        ScheduleRepo repo = new ScheduleRepo(getApplication());
//        Term term = new Term( "Term 1", "01/01/22", "05/30/22");
//        Term term1 = new Term("Term 2", "06/01/22", "01/01/23");
//        Term term2 = new Term( "Spring Term", "03/01/22", "10/01/22");
//        repo.insertTerm(term);
//        repo.insertTerm(term1);
//        repo.insertTerm(term2);


    }

}