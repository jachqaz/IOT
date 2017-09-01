package co.edu.ucc.iotandroid;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ControlActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    private int estadoSala = 0;
    private int estadoBano = 0;
    private int estadoCocina = 0;
    private int estadoHabitacion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
        ButterKnife.bind(this);

//        String nomUsuario = getIntent().getStringExtra("nomUsuario");
//        Log.i("ControlActivity", nomUsuario);
//        setTitle("Bienvenido " + nomUsuario);

    }

    @OnClick(R.id.Csala)
    public void clickSala(View view) {
        // Read from the database
        if (estadoSala == 0) {
            view.setBackgroundColor(ContextCompat.getColor(this, R.color.cyanpd));
            estadoSala = 1;
            myRef.child("hogar").child("idusuario").child("sala").setValue(estadoSala);
        } else {
            view.setBackgroundColor(ContextCompat.getColor(this, R.color.cyan));
            estadoSala = 0;
            myRef.child("hogar").child("idusuario").child("sala").setValue(estadoSala);
        }

    }

    @OnClick(R.id.Croom)
    public void clickRoom(View view) {
        if (estadoHabitacion == 0) {
            view.setBackgroundColor(ContextCompat.getColor(this, R.color.cyanpd));
            estadoHabitacion = 1;
            myRef.child("hogar").child("idusuario").child("habitacion").setValue(estadoHabitacion);
        } else {
            view.setBackgroundColor(ContextCompat.getColor(this, R.color.cyan));
            estadoHabitacion = 0;
            myRef.child("hogar").child("idusuario").child("habitacion").setValue(estadoHabitacion);
        }
    }

    @OnClick(R.id.Ccocina)
    public void clickCocina(View view) {
        if (estadoCocina == 0) {
            view.setBackgroundColor(ContextCompat.getColor(this, R.color.cyanpd));
            estadoCocina = 1;
            myRef.child("hogar").child("idusuario").child("cocina").setValue(estadoCocina);
        } else {
            view.setBackgroundColor(ContextCompat.getColor(this, R.color.cyan));
            estadoCocina = 0;
            myRef.child("hogar").child("idusuario").child("cocina").setValue(estadoCocina);
        }
    }

    @OnClick(R.id.Cbano)
    public void clickBano(View view) {
        if (estadoBano == 0) {
            view.setBackgroundColor(ContextCompat.getColor(this, R.color.cyanpd));
            estadoBano = 1;
            myRef.child("hogar").child("idusuario").child("bano").setValue(estadoBano);
        } else {
            view.setBackgroundColor(ContextCompat.getColor(this, R.color.cyan));
            estadoBano = 0;
            myRef.child("hogar").child("idusuario").child("bano").setValue(estadoBano);
        }
    }
}
