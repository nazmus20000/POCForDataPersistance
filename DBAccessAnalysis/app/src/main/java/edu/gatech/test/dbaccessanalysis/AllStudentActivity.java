package edu.gatech.test.dbaccessanalysis;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AllStudentActivity extends AppCompatActivity {

    @BindView(R.id.allStudents)
    TextView allStudentsTextView;

    private DBhelperStudent dBhelperStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_student);
        ButterKnife.bind(this);

        allStudentsTextView = (TextView) findViewById(R.id.allStudents);
        dBhelperStudent = new DBhelperStudent(getApplicationContext());

        setAllStudent();
    }

    private void setAllStudent() {
        List<Student> allStudents = dBhelperStudent.getAllStudents();

        if (allStudents != null) {
            StringBuilder allStudentsString = new StringBuilder();

            for (Student student : allStudents) {
                String tempUsername = student.getUsername();
                allStudentsString.append(tempUsername + "\n");
            }

            allStudentsTextView.setText(allStudentsString.toString());
        }
    }
}
