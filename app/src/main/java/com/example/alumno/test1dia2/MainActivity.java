package com.example.alumno.test1dia2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final Integer REQUEST_INFO = 0;
    TextView name;
    TextView surnames;
    TextView address;
    TextView cp;
    TextView phone;
    TextView email;
    TextView user;
    TextView password;
    Intent intent;
    Button introducestudentdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        name = findViewById(R.id.textView);
        surnames = findViewById(R.id.textView2);
        address = findViewById(R.id.textView3);
        cp = findViewById(R.id.textView4);
        phone = findViewById(R.id.textView5);
        email = findViewById(R.id.textView6);
        user = findViewById(R.id.textView7);
        password = findViewById(R.id.textView8);
        intent = new Intent(this, FICHA_ALUMNO.class);
        introducestudentdata = findViewById(R.id.button);
        introducestudentdata.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                startActivityForResult(intent, REQUEST_INFO);
            }

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_INFO) {
            if (data.hasExtra(getString(R.string.datakey_name))) {
                name.setText(data.getExtras().getString(getString(R.string.datakey_name)));
            }
            if (data.hasExtra(getString(R.string.datakey_surnames))) {
                surnames.setText(data.getExtras().getString(getString(R.string.datakey_surnames)));
            }
            if (data.hasExtra(getString(R.string.datakey_adress))) {
                address.setText(data.getExtras().getString(getString(R.string.datakey_adress)));
            }
            if (data.hasExtra(getString(R.string.datakey_cp))) {
                cp.setText(data.getExtras().getString(getString(R.string.datakey_cp)));
            }
            if (data.hasExtra(getString(R.string.datakey_phone))) {
                phone.setText(data.getExtras().getString(getString(R.string.datakey_phone)));
            }
            if (data.hasExtra(getString(R.string.datakey_email))) {
                email.setText(data.getExtras().getString(getString(R.string.datakey_email)));
            }
            if (data.hasExtra(getString(R.string.datakey_user))) {
                user.setText(data.getExtras().getString(getString(R.string.datakey_user)));
            }
            if (data.hasExtra(getString(R.string.datakey_password))) {
                password.setText(data.getExtras().getString(getString(R.string.datakey_password)));
            }
        }
    }
}
