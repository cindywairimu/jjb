package Login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.developergmail.jjb.Departments;
import com.example.kogi.mysa.MainActivity;
import com.example.kogi.mysa.R;

public class LoginActivity extends AppCompatActivity {
    private Button btnRegister;


    private TextInputEditText mFirstName, mLastName, mEmail, mMobile, mPassword;
    private TextInputEditText mEditTextPassword, mEditTextUserId;
    private ProgressDialog progressDialog;

    private Button btnLogin;
    ScrollView scrollView;
    private View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        scrollView = findViewById(R.id.scrollView_parent);


        mEditTextPassword = findViewById(R.id.edt_passwordl);
        mEditTextUserId = findViewById(R.id.edt_user_idl);

        try {

            mEditTextPassword.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_person_black_24dp, 0, 0, 0);
            mEditTextUserId.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_lock_black_24dp, 0, 0, 0);


        } catch (Exception hj) {

            hj.printStackTrace();
        }




        mFirstName = findViewById(R.id.txt_firstnames);
        mLastName = findViewById(R.id.txt_lastnames);
        mEmail = findViewById(R.id.txt_emailAdresss);
        mMobile = findViewById(R.id.txt_mobiles);
        mPassword = findViewById(R.id.txt_passwords);

        try {

            mFirstName.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_person_black_24dp, 0, 0, 0);
            mLastName.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_person_black_24dp, 0, 0, 0);
            mEmail.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_email_black_24dp, 0, 0, 0);
            mMobile.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_phone_black_24dp, 0, 0, 0);
            mPassword.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_lock_black_24dp, 0, 0, 0);
            // mEmail.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_lock_black_24dp,0,0,0);


        } catch (Exception hj) {

            hj.printStackTrace();
        }
    }



    public final static boolean isValidEmail(CharSequence target) {
        if (TextUtils.isEmpty(target)) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    private static boolean isValidPhoneNumber(String mobile) {
        String regEx = "^[0-9]{10}$";
        return mobile.matches(regEx);
    }

    private boolean isFilled(TextInputEditText textInputEditText) {
        if (textInputEditText.getText().toString().equals("")) {
            textInputEditText.requestFocus();
            textInputEditText.setError("Required");
            return false;
        } else {
            return true;
        }

    }

    private void snack(String msg) {
        Snackbar.make(scrollView, msg, Snackbar.LENGTH_SHORT)
                .setAction("Action", null).show();
    }
    public void newloginBtnPressed(View view) {
        changeView(2);
    }

    public void newAccountBtnPressed(View view) {
        changeView(1);
    }

    public void Register(View view) {
    }
    private void changeView(int i) {

        RelativeLayout relativeLayoutr = findViewById(R.id.register_view);
        RelativeLayout relativeLayoutl = findViewById(R.id.login_view);


        if (i == 1) {

            relativeLayoutr.setVisibility(View.VISIBLE);
            relativeLayoutl.setVisibility(View.GONE);
        } else {
            relativeLayoutr.setVisibility(View.GONE);
            relativeLayoutl.setVisibility(View.VISIBLE);
        }

    }
    public void Login(View view) {

        if(isFilled(mEditTextPassword) && isFilled(mEditTextUserId)){
            if(mEditTextPassword.getText().toString().equals("test")&&mEditTextUserId.getText().toString().equals("test")){
                startActivity(new Intent(LoginActivity.this, Departments.class));
            }else {
                snack("Wrong credentials entered");
            }
        }

    }
}
