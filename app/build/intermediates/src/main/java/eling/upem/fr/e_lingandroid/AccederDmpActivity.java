package eling.upem.fr.e_lingandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AccederDmpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceder_dmp);
    }

    public void interventionButton_click(View view) {
        Intent intent = new Intent();//new Intent(this, InterventionActivity.class);
        startActivity(intent);
    }

    public void examensButton_click_click(View view) {
        Intent intent = new Intent();//new Intent(this, ExamenActivity.class);
        startActivity(intent);
    }

    public void documentsButton_click(View view) {
        Intent intent = new Intent();//new Intent(this, DocumentActivity.class);
        startActivity(intent);
    }
}
