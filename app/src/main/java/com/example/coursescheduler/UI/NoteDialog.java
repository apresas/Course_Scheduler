package com.example.coursescheduler.UI;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.coursescheduler.R;

public class NoteDialog extends AppCompatDialogFragment {
    private EditText editTextTitle;
    private EditText editTextNote;
    private TextView textViewTitle;
    private TextView textViewNote;
    private DialogListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);

        builder.setView(view)
                .setTitle("Add Course Note")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String title = editTextTitle.getText().toString();
                        String note = editTextNote.getText().toString();
                        listener.applyText(title,note);


                    }
                });
        editTextTitle = view.findViewById(R.id.edit_note_title);
        editTextNote = view.findViewById(R.id.edit_note_comment);
//        textViewTitle = view.findViewById(R.id.note_title);
//        textViewNote = view.findViewById(R.id.note_body);


        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener = (DialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement DialogListener.");
        }

    }

    public interface DialogListener {
        void applyText(String title, String note);
    }
}
