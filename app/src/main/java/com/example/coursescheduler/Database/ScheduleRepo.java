package com.example.coursescheduler.Database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.coursescheduler.DAO.TermDAO;
import com.example.coursescheduler.Entity.Term;

import java.util.List;

public class ScheduleRepo {
    private TermDAO termDAO;
    private LiveData<List<Term>> allTerms;

    public ScheduleRepo(Application application) {
        ScheduleDB database = ScheduleDB.getInstance(application);
        termDAO = database.termDAO();
        allTerms = termDAO.getAllTerms();
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
}
