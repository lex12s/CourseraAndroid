package lexgame.com.petragramcursocoursera.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import lexgame.com.petragramcursocoursera.R;
import lexgame.com.petragramcursocoursera.emailsender.EmailSender;

public class ContactoActivity extends AppCompatActivity {

    private ImageView imageView;
    private EditText nombre;
    private EditText correo;
    private EditText pass;
    private EditText mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        imageView = (ImageView) findViewById(R.id.imgTopPet);
        imageView.setVisibility(View.INVISIBLE);

        Toolbar toolbar = (Toolbar) findViewById(R.id.ActionBarContaco);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button button = (Button) findViewById(R.id.enviarMail);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre = (EditText) findViewById(R.id.NomContacto);
                correo = (EditText) findViewById(R.id.EmailContacto);
                pass = (EditText) findViewById(R.id.PassContacto);
                mensaje = (EditText) findViewById(R.id.MsgContacto);

                EmailSender emailSender = new EmailSender();
                emailSender.execute(correo.getText().toString(),pass.getText().toString(),"alexander1.0@hotmail.com",
                        "desdeAndroid",mensaje.getText().toString(),"/home/asusn56/Descargas/Wolf-48.png");

                //regreso a la pantalla principal despues de enviar el comentario
                Intent i = new Intent(ContactoActivity.this, MainActivity.class);
                startActivity(i);

            }
        });

    }
}
