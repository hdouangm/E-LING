package eling.upem.fr.e_lingandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DeconnexionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConnexionActivity.cm.getCookieStore().removeAll();
        Intent intent = new Intent(this, ConnexionActivity.class);
        startActivity(intent);
    }
}
