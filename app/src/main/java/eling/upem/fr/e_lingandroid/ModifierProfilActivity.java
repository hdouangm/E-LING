package eling.upem.fr.e_lingandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;

import eling.upem.fr.e_lingandroid.model.DialogBox;
import eling.upem.fr.e_lingandroid.model.DonneesSociales;
import eling.upem.fr.e_lingandroid.service.ApiService;
import eling.upem.fr.e_lingandroid.service.ApiServiceInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModifierProfilActivity extends AppCompatActivity {
    EditText nomText, prenomText, ageText, codePostalText, villeText, adressText;
    TextView nomError, prenomError, ageError, codePostalError, adressError;
    RadioButton masculinRadio, femininRadio;
    Spinner paysSpinner;
    ApiServiceInterface apiService;
    ArrayAdapter<CharSequence> adapter;
    DialogBox dialogBox;
    DonneesSociales profil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_profil);

        //////////////// Initialisation ////////////////
        nomText = (EditText) findViewById(R.id.nomText);
        prenomText = (EditText) findViewById(R.id.prenomText);
        ageText = (EditText) findViewById(R.id.ageText);
        codePostalText = (EditText) findViewById(R.id.codePostalText);
        villeText = (EditText) findViewById(R.id.villeText);
        adressText = (EditText) findViewById(R.id.adressText);
        nomError = (TextView) findViewById(R.id.nomErrorLabel);
        prenomError = (TextView) findViewById(R.id.prenomErrorLabel);
        ageError = (TextView) findViewById(R.id.ageErrorLabel);
        codePostalError = (TextView) findViewById(R.id.codePostalErrorLabel);
        adressError = (TextView) findViewById(R.id.adressErrorLabel);
        masculinRadio = findViewById(R.id.genreMasculin);
        femininRadio = findViewById(R.id.genreFeminin);
        paysSpinner = findViewById(R.id.paysText);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.pays_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dialogBox = new DialogBox();

        apiService = new ApiService().getService();
        setProfil();
        ////////////



    }

    private void setProfil() {

        //Cookier.getUserName
        String username = ConnexionActivity.cm.getCookieStore().getCookies().get(1).getValue();


        Call<DonneesSociales> call = apiService.getUserConnecte(username);
        Log.i("onResponse2: -> ", "request ->" + call.request().toString());
       Log.i("onResponse2: -> ", "headerSize " + call.request().headers().size());

        call.enqueue(new Callback<DonneesSociales>() {
            @Override
            public void onResponse(Call<DonneesSociales> call, Response<DonneesSociales> response) {
                if (!response.isSuccessful()) {
                    Log.i("onResponse2: -> ", "" + response.code());
                    Log.i("onResponse2: -> ", "" + call.request().toString());
                    Log.i("onResponse2: -> ", "" + response.errorBody());
                    return;
                }


                //204 -> no content
                if(response.code() == 204) {
                    alert("Erreur", "Oups une erreurs'est produite");
                }
                    // set PROFIL
                else {
                    //error.setVisibility(View.GONE);
                    Log.i("onResponseM: ", "2 " + response.body());
                    try {
                        profil = response.body();

                        nomText.setText(profil.getNom());
                        prenomText.setText(profil.getPrenom());
                        ageText.setText(profil.getAge());
                        codePostalText.setText(profil.getCodePostal());
                        villeText.setText(profil.getVille());
                        if(profil.getGenre()!=null) {
                            if (profil.getGenre().toLowerCase().trim() == "feminin") {
                                femininRadio.setChecked(true);
                                masculinRadio.setEnabled(false);
                            } else {
                                masculinRadio.setChecked(true);
                                femininRadio.setEnabled(false);
                            }
                        }

                        if(profil.getPays()!=null) {
                           // adapter.add();
                        }
                        // Apply the adapter to the spinner
                        paysSpinner.setAdapter(adapter);

                        adressText.setText(profil.getAdressse());

                      /*  headerNom.setText(profil.getNom());
                        headerPrenom.setText(profil.getPrenom());*/

                      setHeader();

                    } catch(Exception e) {
                        alert("Erreur","oups;");
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<DonneesSociales> call, Throwable t) {
                Log.i("onFailure2 ->: ", "erreur");
                t.printStackTrace();
            }

        });
    }

    public void validerButton_click(View view) {
        if(!nomRequired() ||
        !prenomRequired() ||
       !ageRequired() ||
        !codePostalRequired() ||
        !villeRequired() ||
        !adresseRequired() ) return;


        profil.setNom(nomText.getText().toString());
        profil.setPrenom(prenomText.getText().toString());
        profil.setAge(ageText.getText().toString());
        profil.setCodePostal(codePostalText.getText().toString());
        profil.setVille(villeText.getText().toString());
        profil.setAdressse(adressText.getText().toString());
        Log.i("modifier profil", "validerButton_click: " + adressText.getText().toString());
        if(femininRadio.isChecked()) profil.setGenre("feminin");
        else profil.setGenre("masculin");

        String pays = paysSpinner.getSelectedItem().toString();
        profil.setPays(pays);
        Log.i("modifierprofil", "validerButton_click: " + profil.toString());

        modifierProfil(profil);

    }

    private void modifierProfil(DonneesSociales profil) {

        Call<String> call = apiService.modifierProfil(profil);
        Log.i("onResponse2: -> ", "" + call.request().toString());

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (!response.isSuccessful()) {
                    Log.i("onResponse2: -> ", "" + response.code());
                    Log.i("onResponse2: -> ", "" + response.message());
                   // alert("Erreur", "Oups une erreurs'est produite");
                    return;
                }

                // set PROFIL
                else {
                    //error.setVisibility(View.GONE);
                    Log.i("onResponse23  ->: ", "2 " + response.body());
                    alert("Success", "Vos informations ont bien été modifier!");
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i("onFailure2 ->: ", "erreur");

            }

        });
    }

    ///////////////////// Initialisation du header //////////////////////////
   public void setHeader() {
        //ConnexionActivity.cm.getCookieStore().getCookies().get(1).getValue();
       TextView headerNom = (TextView) findViewById(R.id.headerNom);
       TextView headerPrenom = findViewById(R.id.headerPrenom);
        headerNom.setText(ConnexionActivity.cm.getCookieStore().getCookies().get(1).getValue());
        headerPrenom.setText(ConnexionActivity.cm.getCookieStore().getCookies().get(2).getValue());
    }

    ////////////////////// Validation des champs /////////////////////////
    private boolean nomRequired() {
        if(nomText.getText().toString().trim().equals("")) {
            nomError.setVisibility(View.VISIBLE);
            return false;
        }
        else
            nomError.setVisibility(View.GONE);
        return true;
    }

    private boolean prenomRequired() {
        if(prenomText.getText().toString().trim().equals("")) {
            prenomError.setVisibility(View.VISIBLE);
            return false;
        }
        else
            prenomError.setVisibility(View.GONE);
        return true;
    }

    private boolean ageRequired() {
        if(ageText.getText().toString().trim().equals("")) {
            ageError.setVisibility(View.VISIBLE);
            return false;
        }
        else
            ageError.setVisibility(View.GONE);
        return true;
    }

    private boolean codePostalRequired() {
        if(codePostalText.getText().toString().trim().equals("")) {
            codePostalError.setText("Veuillez renseigner le code postal");
            codePostalError.setVisibility(View.VISIBLE);
            return false;
        }
        else
            codePostalError.setVisibility(View.GONE);
        return true;
    }

    private boolean villeRequired() {
        if(villeText.getText().toString().trim().equals("")) {
            codePostalError.setText("Veuillez renseigner la ville");
           codePostalError.setVisibility(View.VISIBLE);
            return false;
        }
        else
            codePostalError.setVisibility(View.GONE);
        return true;
    }

    private boolean adresseRequired() {
        if(adressText.toString().trim().equals("")) {
            adressError.setVisibility(View.VISIBLE);
            return false;
        }
        else
            adressError.setVisibility(View.GONE);
        return true;
    }

    private void alert(String titre, String message) {
        dialogBox.setTitle(titre);//Toast.makeText(null, "Oups une erreur s'est produite", Toast.LENGTH_SHORT);
        dialogBox.setMessage(message);
        dialogBox.show(getSupportFragmentManager(), "dialogBox");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.default_menu, menu);
        return true;
    }
}

