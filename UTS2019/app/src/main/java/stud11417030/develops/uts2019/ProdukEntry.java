package stud11417030.develops.uts2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ProdukEntry extends AppCompatActivity {
    EditText judul;
    EditText harga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produk_entry);
        judul = (EditText) findViewById(R.id.enttry);
        harga = (EditText) findViewById(R.id.entryy);

    }

    public void Simpan(View view){
        if(judul.getText().length()==0){
            judul.setError("Tidak boleh kosong");
        }
        else if(harga.getText().length()==0){
            harga.setError("Tidak boleh kosong");
        }else{
            Splashscreen.db.simpan(judul.getText().toString(), harga.getText().toString());
            startActivity(new Intent(getApplicationContext(), ProdukList.class));
        }
    }
    public void batal(View view){
        judul.setText("");
        harga.setText("");
    }
    public void tutup(View view){
        startActivity(new Intent(getApplicationContext(),ProdukList.class));
    }
}
