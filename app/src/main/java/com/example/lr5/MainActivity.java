package com.example.lr5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.fragment.app.Fragment;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private String strName, strLastName, strSecondName, strEmail, strQuestion;
    Bundle args = new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setItemIconTintList(null);
        Fragment firstFragment = new FirstFragment();
        Fragment secondFragment = new SecondFragment();
        Fragment thirdFragment = new ThirdFragment();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.flFragment, new FirstFragment())
                    .commit();
        }

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.feedback) {
                firstFragment.setArguments(args);
                setCurrentFragment(firstFragment);
                return true;
            } else if (id == R.id.test) {
                secondFragment.setArguments(args);
                setCurrentFragment(secondFragment);
                return true;
            } else if (id == R.id.notification) {
                thirdFragment.setArguments(args);
                setCurrentFragment(thirdFragment);
                return true;
            }
            return false;
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void setCurrentFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flFragment, fragment)
                .commit();
    }
    public  void onClickSend(View view){
        EditText Email, Name, LastName, SecondName, Question;
        Email = findViewById(R.id.Email);
        Name = findViewById(R.id.Name);
        LastName = findViewById(R.id.LastName);
        SecondName = findViewById(R.id.SecondName);
        Question = findViewById(R.id.Question);
        strEmail = Email.getText().toString();
        strName = Name.getText().toString();
        strLastName = LastName.getText().toString();
        strSecondName = SecondName.getText().toString();
        strQuestion = Question.getText().toString();


        args.putString("KEY_EMAIL", strEmail);
        args.putString("KEY_NAME", strName);
        args.putString("KEY_LASTNAME", strLastName);
        args.putString("KEY_SECONDNAME", strSecondName);
        args.putString("KEY_QUESTION", strQuestion);

        CustomDialogFragment dialog = new CustomDialogFragment();
        dialog.setArguments(args);
        Email.setText("");
        Name.setText("");
        LastName.setText("");
        SecondName.setText("");
        Question.setText("");
        dialog.show(getSupportFragmentManager(), "custom");
    }
    public void onClickToTest(View view) {
        Intent intent = new Intent(this, Test.class);
        intent.putExtra("QUESTION", strQuestion);
        startActivity(intent);
    }
    public  void onClickTest(View view){

        CustomDialogTest dialog = new CustomDialogTest();
        dialog.show(getSupportFragmentManager(), "custom");
    }
}