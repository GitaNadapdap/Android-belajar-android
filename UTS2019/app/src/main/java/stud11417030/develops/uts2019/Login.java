package stud11417030.develops.uts2019;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    EditText Username,Password;
    private final String USERNAME ="uname11417030";
    private final String PASS ="pwd11417030";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Username = (EditText)findViewById(R.id.uss);
        Password = (EditText)findViewById(R.id.pass);

        pref = getSharedPreferences("mypreferences", MODE_PRIVATE);
        editor = pref.edit();
        editor.putString(USERNAME,"uname11417030");
        editor.putString(PASS,"pwd11417030");
        editor.apply();

        Button log = (Button)findViewById(R.id.btnLogin);
        log.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String uss = Username.getText().toString();
                String passw = Password.getText().toString();
                String savedName = pref.getString(USERNAME,"-");
                String savedPass = pref.getString(PASS,"-");

                if (uss.equals("") || passw.equals("")) {
                    Toast.makeText(Login.this,"Tidak boleh kosong ",
                            Toast.LENGTH_SHORT).show();
                } else if (uss.equals(savedName) && passw.equals(savedPass)) {
                    Intent log = new Intent(getApplicationContext(), ProdukEntry.class);
                    startActivity(log);
                    finish();
                }else {
                    Toast.makeText( Login.this,"salah", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
