package edu.gatech.test.dbaccessanalysis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.buttonRegPage)
    Button regPageButton;

    @BindView(R.id.buttonlogPage)
    Button logPageButton;

    @BindView(R.id.buttonAllStudentPage)
    Button allStudentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        regPageButtonClicked();
        logPageButtonClicked();
        allStudentButtonClicked();
    }

    private void allStudentButtonClicked() {
        allStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AllStudentActivity.class);
                startActivity(intent);
            }
        });
    }

    private void logPageButtonClicked() {
        logPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void regPageButtonClicked() {
        regPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ResigtrationActivity.class);
                startActivity(intent);
            }
        });
    }
}
