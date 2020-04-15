package com.example.hw1.contacts;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hw1.CallDialog;
import com.example.hw1.ContactFragment;
import com.example.hw1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteDialog extends DialogFragment {
    OnDeleteDialogInteractionListener mListener;
    public DeleteDialog() {
        // Required empty public constructor
    }


    public static DeleteDialog newInstance(){
        return new DeleteDialog();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ContactFragment.OnListFragmentInteractionListener) {
            mListener = (DeleteDialog.OnDeleteDialogInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(getString(R.string.delete_question));
        builder.setPositiveButton(getString(R.string.dialog_confirm), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mListener.onDeleteDialogPositiveClick(DeleteDialog.this);
            }
        });
        builder.setNegativeButton(getString(R.string.dialog_cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mListener.onDeleteDialogNegativeClick(DeleteDialog.this);
            }
        });
        return builder.create();

    }



    public interface OnDeleteDialogInteractionListener {

        void onDeleteDialogNegativeClick(DialogFragment dialog);

        void onDeleteDialogPositiveClick(DialogFragment dialog);

    }


}


