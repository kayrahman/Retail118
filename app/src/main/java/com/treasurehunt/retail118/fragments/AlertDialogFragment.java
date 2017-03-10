package com.treasurehunt.retail118.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import com.treasurehunt.retail118.R;

/**
 * Created by neel on 07/11/2016.
 */
public class AlertDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context context=getActivity();
        AlertDialog.Builder builder=new AlertDialog.Builder(context)
                .setTitle(context.getString(R.string.error_title))
                .setMessage(context.getString(R.string.error_message))
                .setPositiveButton(context.getString(R.string.error_ok_button_text), null);

        AlertDialog dialog=builder.create();
        return dialog;

    }
}
