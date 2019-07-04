package stud11417030.develops.uts2019;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProdukList extends AppCompatActivity {
    ListView mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produk_list);
        mList = (ListView) findViewById(R.id.myList);
        ArrayList<book> dataBk= new ArrayList<book>();
        Cursor crs = Splashscreen.db.fetch();
        if(crs.moveToFirst()){
            do{
                dataBk.add(new book(crs.getString(1),crs.getString(2),"tes"));
            }while (crs.moveToNext());
        }
        bookAdapter books = new bookAdapter(this,R.layout.list_item,dataBk);
        mList.setAdapter(books);
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                book books  = (book) mList.getItemAtPosition(position);
                Intent bk = new Intent(ProdukList.this, ProdukDetail.class);
                bk.putExtra("judul", books .getJudul());
                bk.putExtra("harga", books .getHarga());
                startActivity(bk);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menuopt, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.addPdk:{
                Intent log = new Intent(getApplicationContext(), Login.class);
                startActivity(log);
                break;
            }
            case R.id.keluar:{
                Intent next = new Intent(getApplicationContext(), Splashscreen.class);
                startActivity(next);
                break;
            }
            default:{
                Toast.makeText(getApplicationContext(),"Pilih menu yang ingin anda pilih", Toast.LENGTH_SHORT).show();
            }
        }
        return super.onOptionsItemSelected(item);
    }
//
//    public void img1(View view) {
//        final Intent a =  new Intent(ProdukList.this, ProdukDetail.class);
//        startActivity(a);
//        finish();
//    }

}
