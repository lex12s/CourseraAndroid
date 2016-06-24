package lexgame.com.tareaintent;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    //Variables de DatePiker
    private DatePicker datePicker;
    private int year;
    private int month;
    private int day;

    //Variables de Datos
    private EditText nombre;
    private EditText telefono;
    private EditText email;
    private EditText descripcion;
    private Button siguiente;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setCurrentDate();

        nombre      = (EditText) findViewById(R.id.nombreCompleto);
        telefono    = (EditText) findViewById(R.id.telefono);
        email       = (EditText) findViewById(R.id.eMail);
        descripcion = (EditText) findViewById(R.id.descripcion);
        siguiente   = (Button) findViewById(R.id.Siguiente);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (day == 0 || month == 0 || day == 0 || nombre.getText().toString().isEmpty()
                        || telefono.getText().toString().isEmpty() || email.getText().toString().isEmpty()
                        || descripcion.getText().toString().isEmpty()){
                    Toast.makeText(getBaseContext(),getResources().getString(R.string.CompletarInformacion), Toast.LENGTH_SHORT).show();
                }else {

                    Intent intent = new Intent(MainActivity.this,ConfirmarDatosActivity.class);
                    intent.putExtra("nombre",nombre.getText().toString());
                    intent.putExtra("year",year);
                    intent.putExtra("month",month);
                    intent.putExtra("day",day);
                    intent.putExtra("telefono",telefono.getText().toString());
                    intent.putExtra("email",email.getText().toString());
                    intent.putExtra("descripcion",descripcion.getText().toString());
                    startActivity(intent);
                }
            }
        });




    }

    public void setCurrentDate(){
        datePicker = (DatePicker) findViewById(R.id.fechaCumpleaños);

        final Calendar calendar = Calendar.getInstance();
        year    = calendar.get(Calendar.YEAR);
        month   = calendar.get(Calendar.MONTH);
        day     = calendar.get(Calendar.DAY_OF_MONTH);

        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int yearc, int monthOfYear, int dayOfMonth) {
                year = yearc;
                month = monthOfYear+1;
                day = dayOfMonth;
            }
        });

        datePicker.setCalendarViewShown(false);
        datePicker.setSpinnersShown(true);
    }
}
