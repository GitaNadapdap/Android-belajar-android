package stud11417030.develops.uts2019;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Splashscreen extends AppCompatActivity {
    public static Db db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        //make database
        db = new Db(this, null, 1);

        db.createQuery("CREATE TABLE IF NOT EXISTS book(id INTEGER PRIMARY KEY AUTOINCREMENT, judul VARCHAR, harga VARCHAR)");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), ProdukList.class);
                startActivity(intent);
            }
        }, 3000);
    }

    public void shp(View view) {
        final Intent a =  new Intent(Splashscreen.this, ProdukList.class);
        startActivity(a);
        finish();
    }
}
