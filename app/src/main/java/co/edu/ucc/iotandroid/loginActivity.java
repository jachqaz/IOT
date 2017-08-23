package co.edu.ucc.iotandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class loginActivity extends AppCompatActivity {
    @BindView(R.id.txtNomUsuario)
    EditText txtUsuario;

    @BindView(R.id.txtPassword)
    EditText txtPassword;

    @BindView(R.id.btnIngresar)
    Button btnIngresar;

    @BindView(R.id.btnRegistrar)
    Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.btnIngresar)
    public void clickIngresar() {
        Toast.makeText(this, getString(R.string.ingreso),
                Toast.LENGTH_SHORT).show();
    }


    @OnClick(R.id.btnRegistrar)
    public void clickRegistrar(View view) {
        Intent intent =new Intent(loginActivity.this, registrarActivity.class);
        startActivity(intent);
    }
}
