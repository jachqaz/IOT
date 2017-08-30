package co.edu.ucc.iotandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class ControlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
        String nomUsuario = getIntent().getStringExtra("nomUsuario");
        Log.i("ControlActivity", nomUsuario);
        setTitle("Bienvenido " + nomUsuario);
    }
}
