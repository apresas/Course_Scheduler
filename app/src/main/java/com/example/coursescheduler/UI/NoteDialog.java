//package com.example.coursescheduler.UI;
//
//import android.app.Dialog;
//import android.content.Context;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AlertDialog;
//import androidx.appcompat.app.AppCompatDialogFragment;
//import androidx.lifecycle.LiveData;
//
//import com.example.coursescheduler.Entity.Note;
//import com.example.coursescheduler.R;
//
//import java.util.List;
//
//public class NoteDialog extends AppCompatDialogFragment {
//    private EditText editTextTitle;
//    private EditText editTextNote;
//    private TextView textViewTitle;
//    private TextView textViewNote;
//    private DialogListener listener;
//    private NoteViewModel noteViewModel;
//    int position;
//
//    @NonNull
//    @Override
//    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//
//        LayoutInflater inflater = getActivity().getLayoutInflater();
//        View view = inflater.inflate(R.layout.layout_dialog, null);
//
//        builder.setView(view)
//                .setTitle("Add Course Note")
//                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                })
//                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        String title = editTextTitle.getText().toString();
//                        String note = editTextNote.getText().toString();
//                        saveNote();
////                        listener.applyText(title,note);
//
//
//                    }
//                });
//        editTextTitle = view.findViewById(R.id.edit_note_title);
//        editTextNote = view.findViewById(R.id.edit_note_comment);
////        textViewTitle = view.findViewById(R.id.note_title);
////        textViewNote = view.findViewById(R.id.note_body);
//
//
//        return builder.create();
//
//    }
//
//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//
//        try {
//            listener = (DialogListener) context;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(context.toString() + "must implement DialogListener.");
//        }
//
//    }
//
//    public interface DialogListener {
//        void applyText(String title, String note);
//    }
//
//    private void saveNote() {
////        int ID = AddEditCourseActivity.courseID;
////        String title = textViewTitle.getText().toString();
////        String note = textViewNote.getText().toString();
////
////        LiveData<List<Note>> assignedNotes = noteViewModel.getAssignedNotes(ID);
////        Note currentNote = assignedNotes.getValue().get(position);
////
////        Note newNote = new Note(title, note, ID);
////
////
////        if (assignedNotes.getValue().contains(newNote)){
////            noteViewModel.update(newNote);
////        } else {
////            noteViewModel.insert(newNote);
////        }
//        int ID = AddEditCourseActivity.courseID;
//        String title = editTextTitle.getText().toString();
//        String note = editTextNote.getText().toString();
//
//
//        Intent noteData = new Intent();
//        noteData.putExtra(AddEditCourseActivity.EXTRA_NOTE_COURSE_ID, String.valueOf(ID));
//        noteData.putExtra(AddEditCourseActivity.EXTRA_NOTE_TITLE, title);
//        noteData.putExtra(AddEditCourseActivity.EXTRA_NOTE_BODY, note);
//
//
//
//        int noteID = getIntent().getIntExtra(AddEditCourseActivity.EXTRA_NOTE_ID, -1);
//        System.out.println("Save Note ID: " + noteID);
//        if (noteID != -1) {
//            noteData.putExtra(AddEditCourseActivity.EXTRA_NOTE_ID, noteID);
//            System.out.println("Save Note IF ID: " + noteID);
//
//        }
//        System.out.println("Save Note ELSE ID: " + noteID);
//
//        AddEditCourseActivity.noteTitle = title;
//        AddEditCourseActivity.noteBody = note;
//        AddEditCourseActivity.nID = noteID;
//        AddEditCourseActivity.courseID = ID;
//
//        setResult(RESULT_OK, noteData);
//        finish();
//
//    }
//
//
//}
