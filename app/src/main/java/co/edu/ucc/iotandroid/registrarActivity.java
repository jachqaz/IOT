package co.edu.ucc.iotandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class registrarActivity extends AppCompatActivity {
    @BindView(R.id.r_btnRegistrar)
    Button r_btnRegistrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.r_btnRegistrar)
    public void clickRegistrar(View view) {
        Intent intent =new Intent(registrarActivity.this,loginActivity.class);
        startActivity(intent);
    }
}
