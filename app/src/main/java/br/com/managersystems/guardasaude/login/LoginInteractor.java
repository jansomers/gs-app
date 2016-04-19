package br.com.managersystems.guardasaude.login;

import android.os.Handler;
import android.util.Log;

import br.com.managersystems.guardasaude.login.domain.WebResponse;
import br.com.managersystems.guardasaude.util.AuthenticationApi;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jan on 15/04/2016.
 */
public class LoginInteractor implements ILoginInteractor {

    OkHttpClient okHttpClient = new OkHttpClient();
    private final String BASE_URL= "https://demo.guardasaude.com.br/";
    private AuthenticationApi client;

    public LoginInteractor() {
        client = initiateRetrofit();           }




    private AuthenticationApi initiateRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(AuthenticationApi.class);
    }


    @Override
    public void validateCredentials(final OnLoginFinishedListener listener, final String email, final String password) {
        //TODO Remove because only for testing
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (client == null) {
                    initiateRetrofit();
                }
                Call<WebResponse> call = client.authenticateUser(email,password);
                call.enqueue(new Callback<WebResponse>() {
                    @Override
                    public void onResponse(Call<WebResponse> call, Response<WebResponse> response) {
                        Log.d(this.getClass().getSimpleName(),"IN ONRESPONSE CALL");
                        listener.onSuccess(false);
                    }

                    @Override
                    public void onFailure(Call<WebResponse> call, Throwable t) {
                        Log.d(this.getClass().getSimpleName(),"IN ONFAILURE CALL", t.getCause());

                        listener.onFailure();
                    }
                });


            }
        }, 2000);

    }

}
