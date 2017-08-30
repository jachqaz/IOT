package co.edu.ucc.iotandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

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

    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.btnIngresar)
    public void clickIngresar() {
        String password = txtPassword.getText().toString();
        String usuario = txtUsuario.getText().toString();
        FirebaseAuth.getInstance().signInWithEmailAndPassword(usuario, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent1 = new Intent(loginActivity.this, ControlActivity.class);
                            startActivity(intent1);
                            finish();
                            return;
                        }
                        Toast.makeText(loginActivity.this, "Error " + task.getException().getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                });
//        Toast.makeText(this, getString(R.string.ingreso),
//                Toast.LENGTH_SHORT).show();
    }


    @OnClick(R.id.btnRegistrar)
    public void clickRegistrar() {
        Intent intent = new Intent(getApplicationContext(), registrarActivity.class);
        startActivity(intent);
    }
}
