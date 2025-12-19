package com.example.lr5;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;
import androidx.annotation.NonNull;

public class CustomDialogFragment extends DialogFragment {
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View dialogView = getActivity().getLayoutInflater().inflate(R.layout.dialog, null);

        Bundle args = getArguments();
        String receivedEmail = "";
        String receivedName = "";
        String receivedLastName = "";
        String receivedSecondName = "";
        String receivedQuestion = "";
        if (args != null) {
            receivedEmail = args.getString("KEY_EMAIL", "");
            receivedName = args.getString("KEY_NAME", "");
            receivedLastName = args.getString("KEY_LASTNAME", "");
            receivedSecondName = args.getString("KEY_SECONDNAME", "");
            receivedQuestion = args.getString("KEY_QUESTION", "");
        }

        TextView textViewName = dialogView.findViewById(R.id.textDialogName);
        TextView textViewLastName = dialogView.findViewById(R.id.textDialogLastName);
        TextView textViewSecondName = dialogView.findViewById(R.id.textDialogSecondName);
        TextView textViewEmail = dialogView.findViewById(R.id.textDialogEmail);
        TextView textViewQuestion = dialogView.findViewById(R.id.textDialogQuestion);

        textViewName.setText(receivedName);
        textViewLastName.setText(receivedLastName);
        textViewSecondName.setText(receivedSecondName);
        textViewEmail.setText(receivedEmail);
        textViewQuestion.setText(receivedQuestion);

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        return builder
                .setTitle("Диалоговое окно")
                .setView(dialogView)
                .setMessage("Для закрытия окна нажмите ОК")
                .setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "Нажата OK", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                })
                .create();
    }
}