package com.example.coursescheduler.DAO;

import androidx.core.app.ComponentActivity;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.coursescheduler.Entity.Course;
import com.example.coursescheduler.Entity.Term;
import com.example.coursescheduler.UI.AddEditTermActivity;

import java.util.List;

@Dao
public interface CourseDAO {

    @Insert
    void insert(Course course);

    @Update
    void update(Course course);

    @Delete
    void delete(Course course);

    @Query("DELETE FROM courses")
    void deleteAllCourses();

    @Query("SELECT * FROM courses ORDER BY courseID DESC")
    LiveData<List<Course>> getAllCourses();

//    @Query("SELECT COURSES.* FROM COURSES, TERMS WHERE COURSES.termID = TERMS.termID")
//    LiveData<List<Course>> getAssignedCourses();

//    @Query("SELECT c.* FROM COURSES c JOIN TERMS t ON c.termID = t.termID")
//    LiveData<List<Course>> getAssignedCourses();

//    @Query("SELECT t.termID FROM TERMS t JOIN COURSES c ON c.termID = t.termID")
//    LiveData<List<Course>> getAssignedCourses();
    @Query("SELECT t.termID, c.* FROM TERMS t INNER JOIN COURSES c ON t.termID = c.termID" )
    LiveData<List<Course>> getAssignedCourses();
}
