package com.sourcey.materiallogindemo;

import android.app.ProgressDialog;
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

public class SignupActivity extends AppCompatActivity {
    private static final String TAG = "SignupActivity";

    @BindView(R.id.input_name)
    EditText _nameText;
    @BindView(R.id.aadhar)
    EditText _Aadhar;
    @BindView(R.id.input_address)
    EditText _addressText;
    @BindView(R.id.idno)
    EditText _idno;
    @BindView(R.id.IFSC)
    EditText _Ifsc;
    @BindView(R.id.Accountno)
    EditText _Accountno;
    @BindView(R.id.btn_signup)
    Button _signupButton;
    @BindView(R.id.bankname)
    EditText _BankName;
    @BindView(R.id.Spinner_gender)
    Spinner _spinnerGender;
    @BindView(R.id.Spinner_department)
    Spinner _spinnerDepartment;
    String department;
    String gender;
    private String[] genderRoleString = new String[]{"MALE", "FEMALE"};
    private String[] departmentRoleString = new String[]{"CASING", "C.N.C", "GRNIDING", "Q AND A"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);


        _spinnerDepartment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                ((TextView) arg0.getChildAt(0)).setTextColor(Color.WHITE);
                department = (String) _spinnerDepartment.getSelectedItem();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        ArrayAdapter<String> adapter_role = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, departmentRoleString);
        adapter_role
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        _spinnerDepartment.setAdapter(adapter_role);


        _spinnerGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                ((TextView) arg0.getChildAt(0)).setTextColor(Color.WHITE);
                gender = (String) _spinnerGender.getSelectedItem();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        ArrayAdapter<String> adapter_role1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, genderRoleString);
        adapter_role
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        _spinnerGender.setAdapter(adapter_role);


        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });


    }

    public void signup() {
        Log.d(TAG, "Worker Registration");

        if (!validate()) {
            onSignupFailed();
            return;
        }

        _signupButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SignupActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Worker...");
        progressDialog.show();

        String name = _nameText.getText().toString();
        String address = _addressText.getText().toString();
        String idno = _idno.getText().toString();
        String Aadhar = _Aadhar.getText().toString();
        String Bankname = _BankName.getText().toString();
        String Ifsc = _Ifsc.getText().toString();
        String Accountno = _Accountno.getText().toString();
        // TODO: Implement your own signup logic here.
        Toast.makeText(this, "registration success", Toast.LENGTH_LONG);

    }


    public void onSignupSuccess() {
        _signupButton.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _signupButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;
        String name = _nameText.getText().toString();
        String address = _addressText.getText().toString();
        String idno = _idno.getText().toString();
        String Aadhar = _Aadhar.getText().toString();
        String Bankname = _BankName.getText().toString();
        String Ifsc = _Ifsc.getText().toString();
        String Accountno = _Accountno.getText().toString();

        if (name.isEmpty() || name.length() < 3) {
            _nameText.setError("at least 3 characters");
            valid = false;
        } else {
            _nameText.setError(null);
        }

        if (address.isEmpty()) {
            _addressText.setError("Enter Valid Address");
            valid = false;
        } else {
            _addressText.setError(null);
        }
        if (idno.isEmpty() || idno.length() != 5) {
            _idno.setError("Enter valid ID no");
        } else {
            _idno.setError(null);
        }
        if (Aadhar.isEmpty() || Aadhar.length() != 12) {
            _Aadhar.setError("Enter Valid AADHAAR");
        } else {
            _Aadhar.setError(null);
        }


        return valid;
    }
}