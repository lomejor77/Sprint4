package cl.awakelabs.sprint4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import cl.awakelabs.sprint4.databinding.ActivitySecondBinding;

public class ActivitySecond extends AppCompatActivity {
    String message= "ponte en contacto";
    private ActivitySecondBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        initListener();


    }

    private void initListener() {
        binding.imgWath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendWhatsapp(message);
            }
        });


        binding.imgLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlLink = "https://linkedin.com/in/alex-muñoz-95aab890/";
                Uri linkedin = Uri.parse(urlLink);
                Intent linked = new Intent(Intent.ACTION_VIEW, linkedin);
                startActivity(linked);
            }
        });

        binding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mensajeText = binding.editMensaje.getText().toString();

                composeEmail("lomejor77@gmail.com","Mensaje de Contacto",mensajeText);
            }
        });

    }

    @SuppressLint("IntentReset")
    private void composeEmail(String address, String subject, String mensajeText) {

        Intent implicitMail = new Intent(Intent.ACTION_SEND);
        implicitMail.setType("*/*");
        implicitMail.setData(Uri.parse("mailto:"));
        implicitMail.putExtra(Intent.EXTRA_EMAIL, address);
        implicitMail.putExtra(Intent.EXTRA_SUBJECT, subject);
        implicitMail.putExtra(Intent.EXTRA_TEXT, mensajeText);
        startActivity(Intent.createChooser(implicitMail,"Mensaje Enviado"));
        finish();

    }

    //metodo para abrir app whatsapp
    private void sendWhatsapp(String message) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, message);
        sendIntent.setType("text/plain");
        sendIntent.setPackage("com.whatsapp");
        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(sendIntent);
        }
    }



}