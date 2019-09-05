package com.enes_08.androidroom.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.enes_08.androidroom.entitiy.Student;

import java.util.List;

@Dao
public interface StudentDao {


    @Insert
    void  addStudent(Student student);

    @Update
    void updateStudent(Student student);

     @Delete
      void deleteStudent(Student student);

     @Query("Select * from students")
      List<Student> getAllStudent();

     @Query("Select * from students WHERE name like :name")
      Student  getStudentByName(String name);

     @Query("Select * from students WHERE studentNo like :studentNo")
      Student  getStudentByNo(String studentNo);

}
