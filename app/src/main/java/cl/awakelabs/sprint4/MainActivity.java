package cl.awakelabs.sprint4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import cl.awakelabs.sprint4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnActiv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vSecond = new Intent(getBaseContext(), ActivitySecond.class);
                startActivity(vSecond);
            }
        });
    }
}