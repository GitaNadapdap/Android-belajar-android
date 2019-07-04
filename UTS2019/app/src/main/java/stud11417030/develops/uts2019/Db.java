package stud11417030.develops.uts2019;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Db extends SQLiteOpenHelper {

    static String DB_NAME = "db_Gita";

    public Db(Context context, SQLiteDatabase.CursorFactory factory, int version){
        super(context, DB_NAME, factory, version);
    }

    public void createQuery(String sql){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public Cursor fetch(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor crs = db.rawQuery("SELECT * FROM book", null);
        return crs;
    }

    public void simpan(String judul, String harga){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO book(judul, harga) VALUES('"+judul + "', '"+harga+"')");
    }

}
