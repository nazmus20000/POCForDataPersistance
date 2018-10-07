package edu.gatech.test.dbaccessanalysis;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.usernameLogin)
    EditText username;

    @BindView(R.id.buttonLog)
    Button logButton;

    private DBhelperStudent dBhelperStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        dBhelperStudent = new DBhelperStudent(getApplicationContext());

        loginButtonClicked();
    }

    private void loginButtonClicked() {
        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputUsername = username.getText().toString();

                if(dBhelperStudent.checkIfStudentAlreadyExists(inputUsername)) {
                    Toast.makeText(getApplicationContext(), "Successfully Logged in", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Invalid Username", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
