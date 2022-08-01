package com.example.sqlitedbproj;

import androidx.appcompat.app.AppCompatActivity;

//import android.app.Fragment;
//import android.app.FragmentManager;
//import android.app.FragmentTransaction;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // creating variables for our edittext, button and dbHelper
//    private EditText studentNameEdt,  courseDescriptionEdt, courseDurationEdt, courseNameEdt,
//            professorEdt, collegeNameEdt;
//    private Button addStudentBtn, updateStudentBtn;

    // creating a new dbHelper class
// and passing our context to it.
   // private DBHelper dbHelper = new DBHelper(MainActivity.this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing all our variables.
//        studentNameEdt = findViewById(R.id.idEdtStudentName);
//        courseDescriptionEdt = findViewById(R.id.idEdtCourseDescription);
//        courseDurationEdt = findViewById(R.id.idEdtCourseDuration);
//        courseNameEdt = findViewById(R.id.idEdtCourseName);
//        professorEdt = findViewById(R.id.idEdtProfessorName);
//        collegeNameEdt = findViewById(R.id.idEdtCollegeName);
//        addStudentBtn = findViewById(R.id.idBtnAddStudent);
//        updateStudentBtn = findViewById(R.id.idBtnUpdateStudent);




        // below line is to add on click listener for our add course button.
//        btMenu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {

//                // below line is to get data from all edit text fields.
//                String studentName = studentNameEdt.getText().toString();
//                String courseTracks =  courseDescriptionEdt.getText().toString();
//                String courseDuration = courseDurationEdt.getText().toString();
//                String courseName = courseNameEdt.getText().toString();
//                String professorName = professorEdt.getText().toString();
//                String collegeName = collegeNameEdt.getText().toString();
//
//                // validating if the text fields are empty or not.
//                if (courseName.isEmpty() && courseTracks.isEmpty() && courseDuration.isEmpty() && courseName.isEmpty()) {
//                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                // on below line we are calling a method to add new
//                // course to sqlite data and pass all our values to it.
//           //     dbHelper.addNewStudent(studentName, courseDuration, courseName, courseTracks, professorName, collegeName);
//
//                // after adding the data we are displaying a toast message.
//                Toast.makeText(MainActivity.this, "Course has been added.", Toast.LENGTH_SHORT).show();
//                courseNameEdt.setText("");
//                courseDurationEdt.setText("");
//                courseDescriptionEdt.setText("");
//                courseNameEdt.setText("");
//                professorEdt.setText("");
//                collegeNameEdt.setText("");
//            }
//        });

//        updateStudentBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        Fragment fr = new FirstScreenFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.container, fr);
        fragmentTransaction.commit();
    }
}

