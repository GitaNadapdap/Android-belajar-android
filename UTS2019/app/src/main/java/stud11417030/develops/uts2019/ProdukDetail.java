package stud11417030.develops.uts2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProdukDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produk_detail);

        TextView text1 = (TextView)findViewById(R.id.detail);
        text1.setText(getIntent().getStringExtra("judul"));

        TextView text2 = (TextView)findViewById(R.id.details);
        text2.setText(getIntent().getStringExtra("harga"));
    }

    public void back(View view) {
        Intent b = new Intent(ProdukDetail.this,ProdukList.class);
        startActivity(b);
    }
}
