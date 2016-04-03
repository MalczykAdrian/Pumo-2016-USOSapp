package pl.edu.wat.usos.usosapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view) throws ExecutionException, InterruptedException {
        String authURL = new LoginTask(this).execute().get();
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(authURL));
        startActivity(i);
    }
}
