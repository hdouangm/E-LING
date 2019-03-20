package eling.upem.fr.e_lingandroid.service;

import com.google.gson.JsonObject;

import java.util.List;

import eling.upem.fr.e_lingandroid.model.Credential;
import eling.upem.fr.e_lingandroid.model.DonneesSociales;
import eling.upem.fr.e_lingandroid.model.Employe;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiServiceInterface {

  /* @Headers({

            "Content-Type: application/json"
           " .addHeader(\"Authorization\", \"Bearer ${PrefManager.login.token}\")"
    })*/

    @POST("Connexion/")
    Call<Credential> connexion(@Body JsonObject compteAphp);


    @GET("Profil/byLogin/{login}")
    Call<DonneesSociales> getUserConnecte(@Path("login") String login);



    @PUT("Profil")
    Call<String> modifierProfil(@Body DonneesSociales donneesSociales);

    @GET("Patient/PatientByID/{id}")
    Call<DonneesSociales> getPatientById(@Query("id") int id);
}
