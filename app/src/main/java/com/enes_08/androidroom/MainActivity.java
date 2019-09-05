package com.enes_08.androidroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.enes_08.androidroom.adapter.StudentAdapter;
import com.enes_08.androidroom.db.DbStudents;
import com.enes_08.androidroom.entitiy.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,StudentAdapter.Callback {


    private Button btnSave;
    private EditText etName;
    private EditText etSurname;
    private EditText etClass;
    private EditText etNo;

    private DbStudents mDB;

    private RecyclerView rvStundets;
    private StudentAdapter mAdapter;
    private List<Student> mStudents;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDB=DbStudents.getDatabase(this);

        rvStundets=findViewById(R.id.rvStudents);

        btnSave=findViewById(R.id.btnSave);
        etName=findViewById(R.id.etName);
        etSurname=findViewById(R.id.etsurName);
        etNo=findViewById(R.id.etNo);
        etClass=findViewById(R.id.etClass);

        mStudents=new ArrayList<>();
        mAdapter=new StudentAdapter(this,mStudents);
        mAdapter.setCallback(this);
        rvStundets.setAdapter(mAdapter);



        btnSave.setOnClickListener(this);


        initStudentList();


    }

    private void initStudentList() {

        mStudents.clear();
        mStudents.addAll( mDB.studentModel().getAllStudent());
        mAdapter.notifyDataSetChanged();


    }

    @Override
    public void onClick(View view) {

        if (view==btnSave){

            String sudentName=etName.getText().toString().trim();
            String studentSurname=etSurname.getText().toString().trim();
            String etClassName=etClass.getText().toString().trim();
            String etStudentNo=etNo.getText().toString().trim();


            Student student=new Student();
            student.setName(sudentName);
            student.setSurName(studentSurname);
            student.setStudentClass(etClassName);
            student.setNo(Integer.parseInt(etStudentNo));

            mDB.studentModel().addStudent(student);
            initStudentList();
        }
    }

    @Override
    public void deleteStudent(Student student) {

        mDB.studentModel().deleteStudent(student);
        initStudentList();

    }
}
