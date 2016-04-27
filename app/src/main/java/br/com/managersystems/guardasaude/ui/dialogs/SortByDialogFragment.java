package br.com.managersystems.guardasaude.ui.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;

import br.com.managersystems.guardasaude.R;
import br.com.managersystems.guardasaude.ui.fragments.ExamOverviewFragment;

public class SortByDialogFragment extends DialogFragment {

    public SortByDialogFragment() {
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.dialog_sortby, null))
                .setPositiveButton(R.string.sort, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //TODO Sort items
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        SortByDialogFragment.this.getDialog().cancel();
                    }
                }).setCustomTitle(getActivity().getLayoutInflater().inflate(R.layout.dialog_title_sortby,null));

        return builder.create();
    }
}
