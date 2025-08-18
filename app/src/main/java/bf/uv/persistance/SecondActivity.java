package bf.uv.persistance;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    EditText nom_field ,email_field ,tel_field ,password_field ;
    public static final String TAG= "Etapes actuelle";
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        Button btn = findViewById(R.id.button);
        nom_field = findViewById(R.id.editTextname);
        email_field = findViewById(R.id.editTextemail);
        tel_field = findViewById(R.id.editTexttel);
        password_field = findViewById(R.id.editTextpassword);

        btn.setOnClickListener(v -> {
            Log.d(TAG,"Boutton clicker dans lapp");
            String name = nom_field.getText().toString().trim();
            String email = email_field.getText().toString().trim();
            String tel = tel_field.getText().toString().trim();
            String password = password_field.getText().toString().trim();

            Toast.makeText(this, "Données enregistrées", Toast.LENGTH_SHORT).show();

            Log.d(TAG,"Save successfully in prefs");

        });

        Button btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(v -> {

            Log.d(TAG,"Boutton clicker dans lapp pour migrer vers la second Activity");
            Intent intent=new Intent(SecondActivity.this, MainActivity.class);
            startActivity(intent);
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
}