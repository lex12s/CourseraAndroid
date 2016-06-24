package lexgame.com.tareaintent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatosActivity extends AppCompatActivity {

    private TextView nombrec;
    private TextView fechac;
    private TextView telefonoc;
    private TextView emailc;
    private TextView descripcionc;
    private Button Editarc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        Bundle bundle = getIntent().getExtras();

        String nombre       = bundle.getString("nombre");
        int year            = bundle.getInt("year");
        int month           = bundle.getInt("month");
        int day             = bundle.getInt("day");
        String telefono     = bundle.getString("telefono");
        String email        = bundle.getString("email");
        String descripcion  = bundle.getString("descripcion");

        nombrec             = (TextView) findViewById(R.id.nombreCompletoConfirnar);
        fechac              = (TextView) findViewById(R.id.fechaCumpleañosConfirmar);
        telefonoc           = (TextView) findViewById(R.id.telefonoConfirmar);
        emailc              = (TextView) findViewById(R.id.eMailConfirmar);
        descripcionc        = (TextView) findViewById(R.id.descripcionConfirmar);

        nombrec.setText(getResources().getString(R.string.nombreCompleto) + ": " + nombre);
        fechac.setText(getResources().getString(R.string.fechaNacimiento) + ": " + day+"/"+month+"/"+year);
        telefonoc.setText(getResources().getString(R.string.telefono) + ": " + telefono);
        emailc.setText(getResources().getString(R.string.eMail) + ": " + email);
        descripcionc.setText(getResources().getString(R.string.descripcion) + ": " + descripcion);

        Editarc             = (Button) findViewById(R.id.editarDatos);

        Editarc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
