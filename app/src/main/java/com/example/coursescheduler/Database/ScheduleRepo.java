package com.example.coursescheduler.Database;

import android.app.Application;
import android.content.Intent;
import android.os.AsyncTask;

import androidx.core.app.ComponentActivity;
import androidx.lifecycle.LiveData;

import com.example.coursescheduler.DAO.AssessmentDAO;
import com.example.coursescheduler.DAO.CourseDAO;
import com.example.coursescheduler.DAO.NoteDAO;
import com.example.coursescheduler.DAO.TermDAO;
import com.example.coursescheduler.Entity.Assessment;
import com.example.coursescheduler.Entity.Course;
import com.example.coursescheduler.Entity.Note;
import com.example.coursescheduler.Entity.Term;
import com.example.coursescheduler.UI.AddEditTermActivity;

import java.util.List;

public class ScheduleRepo {
    private TermDAO termDAO;
    private LiveData<List<Term>> allTerms;
    private CourseDAO courseDAO;
    private LiveData<List<Course>> allCourses;
    private AssessmentDAO assessmentDAO;
    private LiveData<List<Assessment>> allAssessments;
    private LiveData<List<Course>> assignedCourses;
    private LiveData<List<Assessment>> assignedAssessments;
    private NoteDAO noteDAO;
    private LiveData<List<Note>> allNotes;
    private LiveData<List<Note>> assignedNotes;
    private List<Course> assignedTermID;



    public ScheduleRepo(Application application) {
        ScheduleDB database = ScheduleDB.getInstance(application);
        termDAO = database.termDAO();
        allTerms = termDAO.getAllTerms();
        courseDAO = database.courseDAO();
        allCourses = courseDAO.getAllCourses();
        assessmentDAO = database.assessmentDAO();
        allAssessments = assessmentDAO.getAllAssessments();
        noteDAO = database.noteDAO();
        allNotes = noteDAO.getAllNotes();


    }

    // TERM
    public void insertTerm(Term term){
        new InsertTermAsyncTask(termDAO).execute(term);
    }

    public void updateTerm(Term term){
        new UpdateTermAsyncTask(termDAO).execute(term);
    }

    public void deleteTerm(Term term){
        new DeleteTermAsyncTask(termDAO).execute(term);
    }

    public void deleteAllTerms() {new DeleteAllTermsAsyncTask(termDAO).execute();}

    public LiveData<List<Term>> getAllTerms() {
        return allTerms;
    }

    // TERM ASYNC
    private static class InsertTermAsyncTask extends AsyncTask<Term, Void, Void> {
        private TermDAO termDAO;

        private InsertTermAsyncTask(TermDAO termDAO) {
            this.termDAO = termDAO;
        }

        @Override
        protected Void doInBackground(Term... terms) {
            termDAO.insert(terms[0]);
            return null;
        }
    }

    private static class UpdateTermAsyncTask extends AsyncTask<Term, Void, Void> {
        private TermDAO termDAO;

        private UpdateTermAsyncTask(TermDAO termDAO) {
            this.termDAO = termDAO;
        }

        @Override
        protected Void doInBackground(Term... terms) {
            termDAO.update(terms[0]);
            return null;
        }
    }

    private static class DeleteTermAsyncTask extends AsyncTask<Term, Void, Void> {
        private TermDAO termDAO;

        private DeleteTermAsyncTask(TermDAO termDAO) {
            this.termDAO = termDAO;
        }

        @Override
        protected Void doInBackground(Term... terms) {
            termDAO.delete(terms[0]);
            return null;
        }
    }

    private static class DeleteAllTermsAsyncTask extends AsyncTask<Void, Void, Void> {
        private TermDAO termDAO;

        private DeleteAllTermsAsyncTask(TermDAO termDAO) {
            this.termDAO = termDAO;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            termDAO.deleteAllTerms();
            return null;
        }
    }

    // COURSE
    public void insertCourse(Course course){
        new InsertCourseAsyncTask(courseDAO).execute(course);
    }

    public void updateCourse(Course course){
        new UpdateCourseAsyncTask(courseDAO).execute(course);
    }

    public void deleteCourse(Course course){
        new DeleteCourseAsyncTask(courseDAO).execute(course);
    }

    public void deleteAllCourses() {new DeleteAllCoursesAsyncTask(courseDAO).execute();}

    public LiveData<List<Course>> getAllCourses() {
        return allCourses;
    }

    public LiveData<List<Course>> getAssignedCourses(int termID) {
        assignedCourses = courseDAO.getAssignedCourses(termID);
        return assignedCourses;
    }

    public List<Course> getAssignedTermID(int termID) {
        assignedTermID = courseDAO.getAssignedTermID(termID);
        return assignedTermID;
    }

    // COURSE ASYNC
    private static class InsertCourseAsyncTask extends AsyncTask<Course, Void, Void> {
        private CourseDAO courseDAO;

        private InsertCourseAsyncTask(CourseDAO courseDAO) {
            this.courseDAO = courseDAO;
        }

        @Override
        protected Void doInBackground(Course... courses) {
           courseDAO.insert(courses[0]);
            return null;
        }
    }

    private static class UpdateCourseAsyncTask extends AsyncTask<Course, Void, Void> {
        private CourseDAO courseDAO;

        private UpdateCourseAsyncTask(CourseDAO courseDAO) {
            this.courseDAO = courseDAO;
        }

        @Override
        protected Void doInBackground(Course... courses) {
            courseDAO.update(courses[0]);
            return null;
        }
    }

    private static class DeleteCourseAsyncTask extends AsyncTask<Course, Void, Void> {
        private CourseDAO courseDAO;

        private DeleteCourseAsyncTask(CourseDAO courseDAO) {
            this.courseDAO = courseDAO;
        }

        @Override
        protected Void doInBackground(Course... courses) {
            courseDAO.delete(courses[0]);
            return null;
        }
    }

    private static class DeleteAllCoursesAsyncTask extends AsyncTask<Void, Void, Void> {
        private CourseDAO courseDAO;

        private DeleteAllCoursesAsyncTask(CourseDAO courseDAO) {
            this.courseDAO = courseDAO;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            courseDAO.deleteAllCourses();
            return null;
        }
    }

    // ASSESSMENT
    public void insertAssessment(Assessment assessment){
        new InsertAssessmentAsyncTask(assessmentDAO).execute(assessment);
    }

    public void updateAssessment(Assessment assessment){
        new UpdateAssessmentAsyncTask(assessmentDAO).execute(assessment);
    }

    public void deleteAssessment(Assessment assessment){
        new DeleteAssessmentAsyncTask(assessmentDAO).execute(assessment);
    }

    public void deleteAllAssessments() {new DeleteAllAssessmentsAsyncTask(assessmentDAO).execute();}

    public LiveData<List<Assessment>> getAllAssessments() {
        return allAssessments;
    }

    public LiveData<List<Assessment>> getAssignedAssessments(int courseID) {
        assignedAssessments = assessmentDAO.getAssignedAssessments(courseID);
        return assignedAssessments;
    }

    // ASSESSMENT ASYNC
    private static class InsertAssessmentAsyncTask extends AsyncTask<Assessment, Void, Void> {
        private AssessmentDAO assessmentDAO;

        private InsertAssessmentAsyncTask(AssessmentDAO assessmentDAO) {
            this.assessmentDAO = assessmentDAO;
        }

        @Override
        protected Void doInBackground(Assessment... assessments) {
            assessmentDAO.insert(assessments[0]);
            return null;
        }
    }

    private static class UpdateAssessmentAsyncTask extends AsyncTask<Assessment, Void, Void> {
        private AssessmentDAO assessmentDAO;

        private UpdateAssessmentAsyncTask(AssessmentDAO assessmentDAO) {
            this.assessmentDAO = assessmentDAO;
        }

        @Override
        protected Void doInBackground(Assessment... assessments) {
            assessmentDAO.update(assessments[0]);
            return null;
        }
    }

    private static class DeleteAssessmentAsyncTask extends AsyncTask<Assessment, Void, Void> {
        private AssessmentDAO assessmentDAO;

        private DeleteAssessmentAsyncTask(AssessmentDAO assessmentDAO) {
            this.assessmentDAO = assessmentDAO;
        }

        @Override
        protected Void doInBackground(Assessment... assessments) {
            assessmentDAO.delete(assessments[0]);
            return null;
        }
    }

    private static class DeleteAllAssessmentsAsyncTask extends AsyncTask<Void, Void, Void> {
        private AssessmentDAO assessmentDAO;

        private DeleteAllAssessmentsAsyncTask(AssessmentDAO assessmentDAO) {
            this.assessmentDAO = assessmentDAO;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            assessmentDAO.deleteAllAssessments();
            return null;
        }
    }


    // NOTE
    public void insertNote(Note note){
        new InsertNoteAsyncTask(noteDAO).execute(note);
    }

    public void updateNote(Note note){
        new UpdateNoteAsyncTask(noteDAO).execute(note);
    }

    public void deleteNote(Note note){
        new DeleteNoteAsyncTask(noteDAO).execute(note);
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }

    public LiveData<List<Note>> getAssignedNotes(int courseID) {
        assignedNotes = noteDAO.getAssignedNotes(courseID);
        return assignedNotes;
    }

    // NOTE ASYNC
    private static class InsertNoteAsyncTask extends AsyncTask<Note, Void, Void> {
        private NoteDAO noteDAO;

        private InsertNoteAsyncTask(NoteDAO noteDAO) {
            this.noteDAO = noteDAO;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDAO.insert(notes[0]);
            return null;
        }
    }

    private static class UpdateNoteAsyncTask extends AsyncTask<Note, Void, Void> {
        private NoteDAO noteDAO;

        private UpdateNoteAsyncTask(NoteDAO noteDAO) {
            this.noteDAO = noteDAO;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDAO.update(notes[0]);
            return null;
        }
    }

    private static class DeleteNoteAsyncTask extends AsyncTask<Note, Void, Void> {
        private NoteDAO noteDAO;

        private DeleteNoteAsyncTask(NoteDAO noteDAO) {
            this.noteDAO = noteDAO;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDAO.delete(notes[0]);
            return null;
        }
    }


}
