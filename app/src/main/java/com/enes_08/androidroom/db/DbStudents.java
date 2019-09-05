package com.enes_08.androidroom.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.enes_08.androidroom.dao.StudentDao;
import com.enes_08.androidroom.entitiy.Student;

@Database( entities = {Student.class},version = 1,exportSchema = false)
public abstract class DbStudents extends RoomDatabase {


    private static  DbStudents mInstance;

    public abstract StudentDao studentModel();



    //uygulama kill olunca veritabanı kaldırılmaz
    //veriler kalıcıdır

    public static  DbStudents getDatabase(Context context){

        if(mInstance==null){

            mInstance= Room.databaseBuilder(context.getApplicationContext(),DbStudents.class,"DbStudetns")
                    .allowMainThreadQueries().build();

        }

        return mInstance;

    }



    //veritabanı sistem belleğinde üretilir
    //uygulama kill olunca veritabanı kaldırılır
    //veriler kalıcı değildir
    public static DbStudents getMemoryDatabase(Context context){

        if(mInstance==null){

            mInstance= Room.inMemoryDatabaseBuilder(context.getApplicationContext(),DbStudents.class)
                    .allowMainThreadQueries().build();

        }

        return mInstance;

    }

    public static void destroyInstance() {
        mInstance = null;
    }

}
