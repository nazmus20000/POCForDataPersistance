package edu.gatech.test.dbaccessanalysis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResigtrationActivity extends AppCompatActivity {

    @BindView(R.id.usernameReg)
    EditText username;

    @BindView(R.id.buttonReg)
    Button registrationButton;

    private DBhelperStudent dBhelperStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resigtration);
        ButterKnife.bind(this);

        dBhelperStudent = new DBhelperStudent(getApplicationContext());

        registrationButtonClicked();
    }

    private void registrationButtonClicked() {
        registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputUsername = username.getText().toString();

                if(dBhelperStudent.checkIfStudentAlreadyExists(inputUsername)) {
                    Toast.makeText(getApplicationContext(), "Already Registered", Toast.LENGTH_SHORT).show();
                }else {
                    Student tempStudent = new Student(inputUsername);

                    dBhelperStudent.insertStudent(tempStudent);
                    Toast.makeText(getApplicationContext(), "Successfully Registered!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
