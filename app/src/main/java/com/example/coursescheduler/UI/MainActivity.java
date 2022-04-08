package com.example.coursescheduler.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.coursescheduler.Database.ScheduleRepo;
import com.example.coursescheduler.Entity.Assessment;
import com.example.coursescheduler.Entity.Course;
import com.example.coursescheduler.Entity.Instructor;
import com.example.coursescheduler.Entity.Note;
import com.example.coursescheduler.Entity.Term;
import com.example.coursescheduler.R;

public class MainActivity extends AppCompatActivity {
    public static int numAlert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void enterHere(View view) {
        Intent intent = new Intent(MainActivity.this, TermActivity.class);
        startActivity(intent);

//        ScheduleRepo repo = new ScheduleRepo(getApplication());
//        Assessment assessment = new Assessment("Database Project", "Performance","01/01/22", "05/30/22", 1);
//        Assessment assessment1 = new Assessment("Mobile App Project", "Performance","06/01/22", "06/30/22", 2);
//        Assessment assessment2 = new Assessment("Software Test", "Objective","07/01/22", "07/30/22", 3);
//        repo.insertAssessment(assessment);
//        repo.insertAssessment(assessment1);
//        repo.insertAssessment(assessment2);
//        Term term = new Term( "Term 1", "01/01/22", "05/30/22");
//        Term term1 = new Term("Term 2", "06/01/22", "01/01/23");
//        Term term2 = new Term( "Spring Term", "03/01/22", "10/01/22");
//        repo.insertTerm(term);
//        repo.insertTerm(term1);
//        repo.insertTerm(term2);
//
//        Course course = new Course("Software 1", "In Progress","03/01/22", "04/03/22", 1);
//        Course course1 = new Course("Software 2", "In Progress","05/01/22", "06/01/22", 2);
//        Course course2 = new Course("Mobile App", "In Progress","06/01/22", "07/01/22", 3);
//        Course course3 = new Course("Tester","In Progress","06/01/22", "07/01/22", 1);
//        repo.insertCourse(course);
//        repo.insertCourse(course1);
//        repo.insertCourse(course2);
//        repo.insertCourse(course3);
//
//        Note note = new Note("Test Title 1", "Test Message Body", 1);
//        Note note1 = new Note("Test Title 2", "Test Message Body", 2);
//        Note note2 = new Note("Test Title 3", "Test Message Body", 3);
//        repo.insertNote(note);
//        repo.insertNote(note1);
//        repo.insertNote(note2);
//
//        Instructor instructor = new Instructor("John Doe", "j.doe@email.com", "222-222-2222", 1);
//        Instructor instructor1 = new Instructor("Jane Doe", "jdoe@email.com", "222-222-2223", 2);
//        Instructor instructor2 = new Instructor("Tim Tom", "t.tom@email.com", "222-222-2224", 3);
//        repo.insertInstructor(instructor);
//        repo.insertInstructor(instructor1);
//        repo.insertInstructor(instructor2);


    }

}