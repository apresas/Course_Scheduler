package com.example.coursescheduler.UI;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.coursescheduler.Database.ScheduleRepo;
import com.example.coursescheduler.Entity.Course;


import java.util.List;

public class CourseViewModel extends AndroidViewModel {

    private ScheduleRepo repository;
    private LiveData<List<Course>> allCourses;

    public CourseViewModel(@NonNull Application application) {
        super(application);
        repository = new ScheduleRepo(application);
        allCourses = repository.getAllCourses();
    }

    public void insert(Course course) {
        repository.insertCourse(course);
    }

    public void update(Course course) {
        repository.updateCourse(course);
    }

    public void delete(Course course) {
        repository.deleteCourse(course);
    }

    public void deleteAllCourses() {
        repository.deleteAllCourses();
    }

    public LiveData<List<Course>> getAllCourses() {
        return allCourses;
    }
}