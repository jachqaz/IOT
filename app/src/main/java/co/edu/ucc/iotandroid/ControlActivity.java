package co.edu.ucc.iotandroid;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.edu.ucc.iotandroid.entidad.Estado;

public class ControlActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("hogar");
    @BindView(R.id.Csala)
    Button Csala;
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
        validar();

    }

    private void validar() {
//        Task<Void> estado=myRef.child("hogar").child("sala").removeValue();
//        Log.e("ControlActivity", String.valueOf(estado));
////        if(estado.equals(1)){
////            Csala.setBackgroundColor(ContextCompat.getColor(this, R.color.cyan));
////        }
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Estado value = dataSnapshot.getValue(Estado.class);
                Log.e("ControlActivity", "Value is: " + value);
                if (value.getBano() == 1) {
                    Log.e("ControlActivity", "change");
                    Csala.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.rojo));
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e("ControlActivity", "Failed to read value.", error.toException());
            }
        });
    }

    @OnClick(R.id.Csala)
    public void clickSala(View view) {
        // Read from the database
        if (estadoSala == 0) {
            view.setBackgroundColor(ContextCompat.getColor(this, R.color.cyanpd));
            estadoSala = 1;
            myRef.child("hogar").child("sala").setValue(estadoSala);
        } else {
            view.setBackgroundColor(ContextCompat.getColor(this, R.color.cyan));
            estadoSala = 0;
            myRef.child("hogar").child("sala").setValue(estadoSala);
        }
    }

    @OnClick(R.id.Croom)
    public void clickRoom(View view) {
        if (estadoHabitacion == 0) {
            view.setBackgroundColor(ContextCompat.getColor(this, R.color.cyanpd));
            estadoHabitacion = 1;
            myRef.child("hogar").child("habitacion").setValue(estadoHabitacion);
        } else {
            view.setBackgroundColor(ContextCompat.getColor(this, R.color.cyan));
            estadoHabitacion = 0;
            myRef.child("hogar").child("habitacion").setValue(estadoHabitacion);
        }
    }

    @OnClick(R.id.Ccocina)
    public void clickCocina(View view) {
        if (estadoCocina == 0) {
            view.setBackgroundColor(ContextCompat.getColor(this, R.color.cyanpd));
            estadoCocina = 1;
            myRef.child("hogar").child("cocina").setValue(estadoCocina);
        } else {
            view.setBackgroundColor(ContextCompat.getColor(this, R.color.cyan));
            estadoCocina = 0;
            myRef.child("hogar").child("cocina").setValue(estadoCocina);
        }
    }

    @OnClick(R.id.Cbano)
    public void clickBano(View view) {
        if (estadoBano == 0) {
            view.setBackgroundColor(ContextCompat.getColor(this, R.color.cyanpd));
            estadoBano = 1;
            myRef.child("hogar").child("bano").setValue(estadoBano);
        } else {
            view.setBackgroundColor(ContextCompat.getColor(this, R.color.cyan));
            estadoBano = 0;
            myRef.child("hogar").child("bano").setValue(estadoBano);
        }
    }
}
