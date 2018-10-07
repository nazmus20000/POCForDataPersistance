package edu.gatech.test.dbaccessanalysis;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBhelperStudent extends SQLiteOpenHelper {
    public static final String DB_NAME = "SDPVocab";
    public static final int version = 1;

    public static final String TABLE_NAME = "student";
    final static String ITEM_ID_COLUMN = "id";
    final static String ITEM_USERNAME_COLUMN = "username";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME
                    + " (" + ITEM_ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ITEM_USERNAME_COLUMN + " TEXT)";

    public DBhelperStudent(Context context) {
        super(context, DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public long insertStudent(Student tempStudent) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues C = new ContentValues();
        C.put(ITEM_USERNAME_COLUMN, tempStudent.getUsername());
        long val = db.insert(TABLE_NAME, null, C);
        db.close();
        return val;
    }

    public boolean checkIfStudentAlreadyExists(String inputUsername) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor C;
        C = db.query(TABLE_NAME, null, null, null, null, null, null);

        if (C != null && C.getCount() > 0) {
            C.moveToFirst();
            for (int i = 0; i < C.getCount(); i++) {
                String tempUsername = C.getString(C.getColumnIndex(ITEM_USERNAME_COLUMN));
                if(tempUsername.equals(inputUsername)) {
                    return true;
                }

                C.moveToNext();
            }
        }

        return false;
    }

    public List<Student> getAllStudents() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor C;
        C = db.query(TABLE_NAME, null, null, null, null, null, null);
        List<Student> studentList = null;

        if (C != null && C.getCount() > 0) {
            C.moveToFirst();

            studentList = new ArrayList<>();
            for (int i = 0; i < C.getCount(); i++) {
                String tempUsername = C.getString(C.getColumnIndex(ITEM_USERNAME_COLUMN));
                Student tempStudent = new Student(tempUsername);

                studentList.add(tempStudent);
                C.moveToNext();
            }
        }

        return studentList;
    }
}
