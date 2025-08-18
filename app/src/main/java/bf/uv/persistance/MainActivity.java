package bf.uv.persistance;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText nom_field ,email_field ,tel_field ,password_field ;
    public static final String TAG= "Etapes actuelle";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"onCreated appelle par lapp");
        Button btn = findViewById(R.id.button);
        nom_field = findViewById(R.id.editTextname);
        email_field = findViewById(R.id.editTextemail);
        tel_field = findViewById(R.id.editTexttel);
        password_field = findViewById(R.id.editTextpassword);

        loadFromPrefs();
        btn.setOnClickListener(v -> {
            Log.d(TAG,"Boutton clicker dans lapp");
            String name = nom_field.getText().toString().trim();
            String email = email_field.getText().toString().trim();
            String tel = tel_field.getText().toString().trim();
            String password = password_field.getText().toString().trim();

            saveToPrefs(name,email,tel,password);
            Toast.makeText(this, "Données enregistrées", Toast.LENGTH_SHORT).show();

            Log.d(TAG,"Save successfully in prefs");

        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart appelle par lapp");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume appelle par lapp");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop appelle par lapp");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause appelle par lapp");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy appelle par lapp");
    }

    private void saveToPrefs(String name, String email, String phone, String password) {
        SharedPreferences sp = getSharedPreferences("form", MODE_PRIVATE);
        sp.edit()
                .putString("name", name)
                .putString("email", email)
                .putString("phone", phone)
                .putString("password", password)
                .apply();
    }

    private void loadFromPrefs() {
        SharedPreferences sp = getSharedPreferences("form", MODE_PRIVATE);
        nom_field.setText(sp.getString("name", ""));
        email_field.setText(sp.getString("email", ""));
        tel_field.setText(sp.getString("phone", ""));
        password_field.setText(sp.getString("password", ""));
    }
}