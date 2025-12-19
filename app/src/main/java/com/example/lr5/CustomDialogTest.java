package com.example.lr5;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class CustomDialogTest extends DialogFragment {
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View dialogView = getActivity().getLayoutInflater().inflate(R.layout.dialog_test, null);

        Button btnRight = dialogView.findViewById(R.id.buttonRight);
        if (btnRight != null) {
            btnRight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "Вы сделали Правильный выбор", Toast.LENGTH_LONG).show();
                    dismiss();
                }
            });
        }

        Button btnNotRight = dialogView.findViewById(R.id.buttonNotRight);
        if (btnNotRight != null) {
            btnNotRight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "Вы сделали Не Правильный выбор", Toast.LENGTH_LONG).show();
                    dismiss();
                }
            });
        }

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        return builder
                .setTitle("Сделай правильный выбор")
                .setView(dialogView)
                .setMessage("Для закрытия окна нажмите ОК")
                .create();
    }
    public  void onClickRight(View view){
        Toast toast = Toast.makeText(getActivity(), "кнопка номер 1 нажата",Toast.LENGTH_LONG);
        toast.show();
    }
}
