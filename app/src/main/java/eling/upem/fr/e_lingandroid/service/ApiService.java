package eling.upem.fr.e_lingandroid.service;

import android.os.AsyncTask;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eling.upem.fr.e_lingandroid.ConnexionActivity;
import eling.upem.fr.e_lingandroid.model.CompteAphp;
import eling.upem.fr.e_lingandroid.model.DonneesSociales;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    // on remplace localhost par son adresse ip
    public static String apiUrl ="http://192.168.1.11:8080/Patient-1.0-SNAPSHOT/rs/";

    private ApiServiceInterface service;

    private String token = null;

    public ApiService() {
        try {
            token = ConnexionActivity.cm.getCookieStore().getCookies().get(0).getValue();
        }catch (Exception e) {
            e.printStackTrace();
        }
         OkHttpClient.Builder httpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
             @Override
             public okhttp3.Response intercept(Chain chain) throws IOException {
                 Request newRequest  = chain.request().newBuilder()
                         .addHeader("Authorization", "Bearer " + token)
                         .build();
                 return chain.proceed(newRequest);
             }
         });

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(apiUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build())
                .build();

        service = retrofit.create(ApiServiceInterface.class);


    }

    public ApiServiceInterface getService() {
        return service;
    }





}
