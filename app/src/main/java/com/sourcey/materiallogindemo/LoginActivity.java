package com.sourcey.materiallogindemo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;
    String userrole;


    String password;
    @BindView(R.id.input_username)
    EditText _userText;
    @BindView(R.id.input_password)
    EditText _passwordText;
    @BindView(R.id.btn_login)
    Button _loginButton;
    // @BindView(R.id.link_signup) TextView _signupLink;
    @BindView(R.id.spinner_login)
    Spinner _spinnerLogin;
    private String[] userRoleString = new String[]{"ADMIN", "SUPERVISOR"};

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        _spinnerLogin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                ((TextView) arg0.getChildAt(0)).setTextColor(Color.WHITE);
                userrole = (String) _spinnerLogin.getSelectedItem();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        ArrayAdapter<String> adapter_role = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, userRoleString);
        adapter_role
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        _spinnerLogin.setAdapter(adapter_role);


        _loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });


       /* _signupLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });*/

    }

    public void login() {
        Log.d(TAG, "Login");
        _loginButton.setEnabled(true);
        _loginButton.setOnClickListener(new View.OnClickListener() {
            String user_name = _userText.getText().toString();
            String pass_word = _passwordText.getText().toString();
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if (userrole.equals("ADMIN")) {

                    String user_name = _userText.getText().toString();
                    String pass_word = _passwordText.getText().toString();

                    if (user_name.equals("admin") & pass_word.equals("admin123")) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_SHORT).show();
                    }
                } else if (userrole.equals("SUPERVISOR")) {
                    String user_name = _userText.getText().toString();
                    String pass_word = _passwordText.getText().toString();
                    if (user_name.equals("chinmay") && pass_word.equals("password123")) {
                        Intent intent1 = new Intent(LoginActivity.this, MenuActivity.class);
                        startActivity(intent1);
                        Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Login unsuccessful", Toast.LENGTH_SHORT).show();
                    }

/*
                                                if (TextUtils.isEmpty(user_name)) {
                                                    _userText.setError("Invalid User Name");
                                                } else if (TextUtils.isEmpty(pass_word)) {
                                                    _passwordText.setError("enter password");
                                                }
                                                DBAdapter dbAdapter = new DBAdapter(LoginActivity.this);
                                                SupervisorBean supervisorBean = dbAdapter.validateFaculty(user_name, pass_word);

                                                if (supervisorBean != null) {
                                                    Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                                                    startActivity(intent);
                                                    ((ApplicationContext) LoginActivity.this.getApplicationContext()).setSupervisorBean(supervisorBean);
                                                    Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
                                                } else {
                                                    Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_SHORT).show();
                                                }
                                            }*/
                }
            }
        });


        String email = _userText.getText().toString();
        String password = _passwordText.getText().toString();

        // TODO: Implement your own authentication logic here.


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // Disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        _loginButton.setEnabled(true);
        finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _loginButton.setEnabled(true);
    }


    private boolean validate() {
        boolean valid = true;

        String password = _passwordText.getText().toString();


        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }
}


