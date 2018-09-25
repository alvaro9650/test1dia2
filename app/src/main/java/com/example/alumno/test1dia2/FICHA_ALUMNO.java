package com.example.alumno.test1dia2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class FICHA_ALUMNO extends AppCompatActivity {
    EditText name;
    EditText surnames;
    EditText address;
    EditText cp;
    EditText phone;
    EditText email;
    EditText user;
    EditText password;
    ImageButton introducestudentdata;
    Context context;
    int duration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha__alumno);
        name = findViewById(R.id.editText);
        surnames = findViewById(R.id.editText2);
        address = findViewById(R.id.editText3);
        cp = findViewById(R.id.editText4);
        phone = findViewById(R.id.editText5);
        email = findViewById(R.id.editText6);
        user = findViewById(R.id.editText7);
        user.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        password = findViewById(R.id.editText8);
        introducestudentdata = findViewById(R.id.imageButton);
        context = getApplicationContext();
        duration = Toast.LENGTH_SHORT;
        introducestudentdata.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (name.getText().toString().isEmpty()) {
                    Toast.makeText(context, R.string.error_msg_empty_name, duration).show();
                } else if (surnames.getText().toString().isEmpty()) {
                    Toast.makeText(context, R.string.error_msg_empty_surname, duration).show();
                } else if (address.getText().toString().isEmpty()) {
                    Toast.makeText(context, R.string.error_msg_empty_address, duration).show();
                } else if (cp.getText().toString().isEmpty()) {
                    Toast.makeText(context, R.string.error_msg_empty_cp, duration).show();
                } else if (phone.getText().toString().isEmpty()) {
                    Toast.makeText(context, R.string.error_msg_empty_phone, duration).show();
                } else if (email.getText().toString().isEmpty()) {
                    Toast.makeText(context, R.string.error_msg_empty_email, duration).show();
                } else if (user.getText().toString().isEmpty()) {
                    Toast.makeText(context, R.string.error_msg_empty_user, duration).show();
                } else if (password.getText().toString().isEmpty()) {
                    Toast.makeText(context, R.string.error_msg_empty_pass, duration).show();
                } else if (!email.getText().toString().contains("@")) {
                    Toast.makeText(context, R.string.error_msg_email_needs_at, duration).show();
                } else if (!email.getText().toString().contains(".")) {
                    Toast.makeText(context, R.string.error_msg_email_needs_dot, duration).show();
                } else if (!(cp.getText().toString().length() == 5)) {
                    Toast.makeText(context, R.string.error_msg_cp_length, duration).show();
                } else if (!(user.getText().toString().length() == 8)) {
                    Toast.makeText(context, R.string.error_msg_user_length, duration).show();
                } else if (!(password.getText().toString().length() == 8)) {
                    Toast.makeText(context, R.string.error_msg_pass_length, duration).show();
                } else {
                    finish();
                }
            }

        });
    }

    @Override
    public void finish() {
        Intent data = new Intent();
        data.putExtra(getString(R.string.datakey_name), name.getText().toString());
        data.putExtra(getString(R.string.datakey_surnames), surnames.getText().toString());
        data.putExtra(getString(R.string.datakey_adress), address.getText().toString());
        data.putExtra(getString(R.string.datakey_cp), cp.getText().toString());
        data.putExtra(getString(R.string.datakey_phone), phone.getText().toString());
        data.putExtra(getString(R.string.datakey_email), email.getText().toString());
        data.putExtra(getString(R.string.datakey_user), user.getText().toString());
        data.putExtra(getString(R.string.datakey_password), password.getText().toString());
        setResult(RESULT_OK, data);
        super.finish();
    }
}
