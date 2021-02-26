package com.yy.android.myapplicationaaq.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.yy.android.myapplicationaaq.R;

public class MvpActivity extends AppCompatActivity implements IMvpView{

    EditText userName;
    EditText password;
    Button login;
    TextView result;
    MvpPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        userName = findViewById(R.id.user_name);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        result = findViewById(R.id.result);
        presenter = new MvpPresenter(this);
        login.setOnClickListener(v->{
            presenter.login();
        });
    }

    @Override
    public String getUserName() {
        return userName.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public void onSuccess(String s) {
        result.setText(s);
    }
}