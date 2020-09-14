package com.ritmoli.music;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ForgetPasswordActivity extends AppCompatActivity {

    EditText edittxt_email, edittxt_password, edittxt_name, edittxt_contact,edittxt_address,edittxt_city,edittxt_state,edittxt_pincode, edittxt_confirmpassword;
    TextView btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password_layout);

    }
}