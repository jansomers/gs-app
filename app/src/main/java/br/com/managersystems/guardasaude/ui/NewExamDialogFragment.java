package br.com.managersystems.guardasaude.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import br.com.managersystems.guardasaude.R;


public class NewExamDialogFragment extends DialogFragment {

    public NewExamDialogFragment() {
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.dialog_newxexam, null))
                .setPositiveButton(R.string.find, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //Search for new exam
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        NewExamDialogFragment.this.getDialog().cancel();
                    }
                }).setCustomTitle(getActivity().getLayoutInflater().inflate(R.layout.dialog_title_newexam,null));
        return builder.create();
    }
}
