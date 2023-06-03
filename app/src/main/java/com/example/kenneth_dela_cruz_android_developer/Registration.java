package com.example.kenneth_dela_cruz_android_developer;

import static android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class Registration extends AppCompatActivity {

    TextInputLayout name_layout;
    TextInputEditText name_Edit;

    TextInputLayout email_layout;
    TextInputEditText email_Edit;

    TextInputLayout password_layout;
    TextInputEditText password_Edit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        window.setStatusBarColor(Color.parseColor("#FEF5AC"));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            this.getWindow().getDecorView().getWindowInsetsController().setSystemBarsAppearance(APPEARANCE_LIGHT_STATUS_BARS, APPEARANCE_LIGHT_STATUS_BARS);
        } else {
            window.setFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            window.setStatusBarColor(Color.parseColor("#e28743"));
        }

        name_layout = findViewById(R.id.name_layout);
        name_Edit = findViewById(R.id.name_Edit);

        email_layout = findViewById(R.id.email_layout);
        email_Edit = findViewById(R.id.email_Edit);

        password_layout = findViewById(R.id.password_layout);
        password_Edit = findViewById(R.id.password_Edit);


        TextView goBackLogin = findViewById(R.id.goBackLogin);
        goBackLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registration.this, Login.class));
                finish();
            }
        });
        CardView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registration.this, Login.class));
                finish();
            }
        });
        Button Register = findViewById(R.id.Register);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInput();
            }
        });


    }


    private void checkInput() {
        CONSTANT constant = new CONSTANT();
        String name = name_Edit.getText().toString();
        String email = email_Edit.getText().toString();
        String pass = password_Edit.getText().toString();

        if (name.isEmpty()) {
            name_layout.setHelperText("*Please enter your name");
            name_layout.setHelperTextColor(ColorStateList.valueOf(Color.parseColor("#F4511E")));
            name_Edit.requestFocus();
            return;
        }
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
        Button okay = view.findViewById(R.id.okay);
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.show();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent i = new Intent(Registration.this, Login.class);
                // set the new task and clear flags
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                finish();

            }
        });
    }
}