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
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.edu.ucc.iotandroid.entidad.Usuario;

public class registrarActivity extends AppCompatActivity {


    @BindView(R.id.r_txtNombre)
    EditText r_txtNombre;
    @BindView(R.id.r_txtUsuario)
    EditText r_txtUsuario;
    @BindView(R.id.r_txtPassword)
    EditText r_txtPassword;
    @BindView(R.id.r_txtEmail)
    EditText r_txtEmail;
    @BindView(R.id.r_btnRegistrar)
    Button r_btnRegistrar;

    private FirebaseAuth auth;
    private FirebaseDatabase database;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        ButterKnife.bind(this);
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("usuarios");
    }

    @OnClick(R.id.r_btnRegistrar)
    public void clickRegistrar() {

        String nombre = r_txtNombre.getText().toString();
        String password = r_txtPassword.getText().toString();
        String email = r_txtEmail.getText().toString();

        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            final String uid = task.getResult().getUser().getUid();

                            task.getResult().getUser().getToken(true)
                                    .addOnCompleteListener(new OnCompleteListener<GetTokenResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<GetTokenResult> task) {

                                            if (task.isSuccessful()) {

                                                final String nomUsuario = r_txtNombre.getText().toString();

                                                Usuario objUsuario = new Usuario();
                                                objUsuario.setNombres(nomUsuario);
                                                objUsuario.setToken(task.getResult().getToken());

                                                reference.child(uid).setValue(objUsuario)
                                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                            @Override
                                                            public void onComplete(@NonNull Task<Void> task) {
                                                                if (task.isSuccessful()) {

                                                                    Intent intent1 = new Intent(registrarActivity.this, ControlActivity.class);
                                                                    intent1.putExtra("nomUsuario", nomUsuario);
                                                                    startActivity(intent1);
                                                                    finish();
                                                                } else {
                                                                    Toast.makeText(registrarActivity.this, "Error " + task.getException().getMessage(),
                                                                            Toast.LENGTH_SHORT).show();
                                                                }
                                                            }
                                                        });

                                            } else {
                                                Toast.makeText(registrarActivity.this, "Error " + task.getException().getMessage(),
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });

                        } else {
                            Toast.makeText(registrarActivity.this, "Error " + task.getException().getMessage(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}
