package com.example.coursescheduler.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Query;

import com.example.coursescheduler.DAO.CourseDAO;

@Entity(tableName = "courses")
public class Course {
    @PrimaryKey(autoGenerate = true)
    private int courseID;

    private String courseTitle;
    private String instructorName;
    private String startDate;
    private String endDate;
    private int termID;

    // Constructor
    public Course(String courseTitle, String instructorName, String startDate, String endDate, int termID) {
        this.courseTitle = courseTitle;
        this.instructorName = instructorName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.termID = termID;
    }

    // Getters
    public int getCourseID() {
        return courseID;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public int getTermID() {return termID;}

    // Setters

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setTermID(int termID) {
        this.termID = termID;
    }
}
