package com.example.kenneth_dela_cruz_android_developer;

import static android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class Login extends AppCompatActivity {

    TextInputLayout email_layout;
    TextInputEditText email_Edit;

    TextInputLayout password_layout;
    TextInputEditText password_Edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        window.setStatusBarColor(Color.parseColor("#FEF5AC"));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            this.getWindow().getDecorView().getWindowInsetsController().setSystemBarsAppearance(APPEARANCE_LIGHT_STATUS_BARS, APPEARANCE_LIGHT_STATUS_BARS);
        } else {
            window.setFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            window.setStatusBarColor(Color.parseColor("#e28743"));
        }

        email_layout = findViewById(R.id.email_layout);
        email_Edit = findViewById(R.id.email_Edit);

        password_layout = findViewById(R.id.password_layout);
        password_Edit = findViewById(R.id.password_Edit);

        Button register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, Registration.class);
                startActivity(i);

            }
        });
        Button forgot = findViewById(R.id.forgot);
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(Login.this, ForgotPassword.class);
                startActivity(intent);
            }
        });
        Button login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInput();
            }
        });

    }


    @SuppressLint("SetTextI18n")
    private void checkInput() {
        String email = email_Edit.getText().toString();
        String pass = password_Edit.getText().toString();
        CONSTANT constant = new CONSTANT();

        CharSequence emailcs = email_Edit.getText().toString();
        if (email.isEmpty()) {
            email_layout.setHelperText("Please input your email");
            email_layout.setHelperTextColor(ColorStateList.valueOf(Color.parseColor("#F4511E")));
            email_Edit.requestFocus();
            return;
        } else if (!(Pattern.matches(Patterns.EMAIL_ADDRESS.pattern(), emailcs))) {
            email_layout.setHelperText("Enter a valid email ex. example@gmail.com");
            email_layout.setHelperTextColor(ColorStateList.valueOf(Color.parseColor("#F4511E")));
            email_Edit.requestFocus();
            return;
        }
        CharSequence passwordcs = password_Edit.getText().toString();
        if (pass.isEmpty()) {
            password_layout.setHelperText("Please input your password");
            password_layout.setHelperTextColor(ColorStateList.valueOf(Color.parseColor("#F4511E")));
            password_Edit.requestFocus();
            return;
        } else if (pass.length() < 5) {
            password_layout.setHelperText("Password must have 5 characters");
            password_layout.setHelperTextColor(ColorStateList.valueOf(Color.parseColor("#F4511E")));
            password_Edit.requestFocus();
            return;
        } else if (!(Pattern.matches(constant.passwordPattern.pattern(), passwordcs))) {

            password_layout.setHelperText(constant.passError);
            password_layout.setHelperTextColor(ColorStateList.valueOf(Color.parseColor("#F4511E")));
            password_Edit.requestFocus();
            return;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = View.inflate(this, R.layout.registered_alert, null);
        builder.setCancelable(false);
        builder.setView(view);
        Button okay = view.findViewById(R.id.okay);
        TextView title = view.findViewById(R.id.title);
        title.setText("Login Successfully");

        AlertDialog dialog = builder.create();
        dialog.show();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                startActivity(new Intent(Login.this, Dashboard.class));
            }
        });

    }
}