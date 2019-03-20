package eling.upem.fr.e_lingandroid.service;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class JwtInterceptor implements Interceptor {

    private String sessionToken;

    public JwtInterceptor(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        Request.Builder requestBuilder = request.newBuilder();

        if (request.header("Authorization") == null) {
            // needs credentials
            if (sessionToken == null) {
              //  throw new RuntimeException("Session token should be defined for auth apis");
            } else {
                requestBuilder.addHeader("Cookie", sessionToken);
                requestBuilder.addHeader("Authorization", "Bearer " + sessionToken);
            }
        }

        return chain.proceed(requestBuilder.build());
    }


}
