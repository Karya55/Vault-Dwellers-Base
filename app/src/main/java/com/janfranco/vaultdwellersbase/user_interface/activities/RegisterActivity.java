package com.janfranco.vaultdwellersbase.user_interface.activities;

import androidx.appcompat.app.AppCompatActivity;
import com.janfranco.vaultdwellersbase.R;
import android.os.Bundle;

import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ButterKnife.bind(this);
    }

}
