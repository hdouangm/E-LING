package eling.upem.fr.e_lingandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.JsonObject;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.URI;

import eling.upem.fr.e_lingandroid.model.Credential;
import eling.upem.fr.e_lingandroid.service.ApiService;
import eling.upem.fr.e_lingandroid.service.ApiServiceInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConnexionActivity extends AppCompatActivity {
    EditText loginText, passwordText;
    TextView loginError, passwordError, error;


    public static CookieManager cm = new CookieManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        //////////////// Initialisation ////////////////
        loginText = (EditText) findViewById(R.id.loginText);
        passwordText = (EditText) findViewById(R.id.passwordText);
        loginError = (TextView) findViewById(R.id.loginErrorLabel);
        passwordError = (TextView) findViewById(R.id.passwordErrorLabel);
        error = (TextView) findViewById(R.id.errorLabel);
        ApiServiceInterface apiService = new ApiService().getService();
        //////////////////////////////

    }

    public void logInButton_click(View view) {
      if(!loginRequired() || !passwordRequired()) return;
      String login = loginText.getText().toString();
      String password = passwordText.getText().toString();
      connexion(login, password);
     /*Intent intent = new Intent(this, ModifierProfilActivity.class);
     startActivity(intent);*/

    }

    //////////////////////////// Appel au service ///////////////////////////////////////////
    private void connexion(final String username, final String password) {
        JsonObject compteAphp = new JsonObject();
        compteAphp.addProperty("login",username);
        compteAphp.addProperty("motDePasse",password);
        ApiServiceInterface apiService = new ApiService().getService();
        Call<Credential> call = apiService.connexion(compteAphp);
        Log.i("onResponse: -> ", "" + call.request().toString());

        call.enqueue(new Callback<Credential>() {
            @Override
            public void onResponse(Call<Credential> call, Response<Credential> response) {
                if (!response.isSuccessful()) {
                        Log.i("onResponse: -> ", "" + response.message());
                      /*  Log.i("onResponse: -> ", "" + response.headers().toString());
                        Log.i("onResponse: -> ", "" + response.code());
                        Log.i("onResponse: -> ", "" + call.request().headers().toString());*/
                    return;
                }


                //204 -> no content
                if(response.code() == 204) error.setVisibility(View.VISIBLE);

                else {
                    error.setVisibility(View.GONE);
                    Log.i("onResponse succes  ->: ", " connexion : "+ response.body());
                  Credential credential = response.body();

                    //////////////// set cookies /////////
                    try {
                        /////////////////// initialisation ///////////////
                    //    cm = new CookieManager();
                        CookieHandler.setDefault(cm);
                        ////////////////// token ////////////
                        HttpCookie cookie = new HttpCookie("token", credential.getToken());
                        cookie.setDomain("192.168.1.11:8080");
                        cm.getCookieStore().add(new URI("http://192.168.1.11:8080"), cookie);//indice 0

                       ///////////////////// nom /////////////////////
                        cookie = new HttpCookie("nom", credential.getNom());
                       // cookie.setDomain("192.168.1.11:8080");
                        cm.getCookieStore().add(new URI("http://192.168.1.11:8080"), cookie);// indice 1

                        ////////////////// prenom ////////////
                        cookie = new HttpCookie("prenom", credential.getPrenom());
                       // cookie1.setDomain("192.168.1.11:8080");
                        cm.getCookieStore().add(new URI("http://192.168.1.11:8080"), cookie);// indice 2

                        ////////////////// login ////////////
                        cookie = new HttpCookie("login", username);
                        // cookie1.setDomain("192.168.1.11:8080");
                        cm.getCookieStore().add(new URI("http://192.168.1.11:8080"), cookie);// indice 3

                        ///////////////////// Passer à la page suivante //////////////////////
                        setIntent();


                    }catch (Exception e) {
                        e.printStackTrace();
                    }

                }

            }

            @Override
            public void onFailure(Call<Credential> call, Throwable t) {
                Log.i("onFailure ->: ", "erreur");
                t.printStackTrace();
            }

        });
    }


    private void setIntent() {
        Intent intent = new Intent(this, ModifierProfilActivity.class);
        startActivity(intent);
    }

    ////////////////////// Validation des champs /////////////////////////
    private boolean loginRequired() {
        if(loginText.getText().toString().trim().equals("")) {
            loginError.setVisibility(View.VISIBLE);
            return false;
        }
        else
            loginError.setVisibility(View.GONE);

         return true;
    }

    private boolean passwordRequired() {
        if(passwordText.getText().toString().trim().equals("")) {
            passwordError.setVisibility(View.VISIBLE);
            return false;
        }
        else
            passwordError.setVisibility(View.GONE);
        return true;
    }

    /////////////////////////////// Menu ///////////////////////////
    private void MenuDeconnexion(View view) {
        Intent intent = new Intent(this, DeconnexionActivity.class);
        startActivity(intent);
    }

    private void MenuModifier(View view) {
        Intent intent = new Intent(this, ModifierProfilActivity.class);
        startActivity(intent);
    }

    private void MenuAccederDMP(View view) {
        Intent intent = new Intent(this, AccederDmpActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.default_menu, menu);
        return true;
    }

}
