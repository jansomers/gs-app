package br.com.managersystems.guardasaude.login;

import android.content.SharedPreferences;
import android.os.Handler;
import android.util.Log;

import java.util.ArrayList;

import br.com.managersystems.guardasaude.login.domain.AuthorisationResult;
import br.com.managersystems.guardasaude.login.domain.BaseUser;
import br.com.managersystems.guardasaude.login.domain.MobileToken;
import br.com.managersystems.guardasaude.util.AuthenticationApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LoginInteractor implements ILoginInteractor {

    private final String BASE_URL= "https://guardasaude.com.br/";
    private AuthenticationApi client;

    public LoginInteractor() {
        client = initiateRetrofit();
    }




    private AuthenticationApi initiateRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(AuthenticationApi.class);
    }


    @Override
    public void handleRequestLoginAttempt(final OnLoginFinishedListener listener, final String email64, final String password64) {
        //TODO Remove because only for testing
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (client == null) {
                    initiateRetrofit();
                }
                Call<AuthorisationResult> call = client.authenticateUser(email64, password64);
                call.enqueue(new Callback<AuthorisationResult>() {
                    @Override
                    public void onResponse(Call<AuthorisationResult> call, Response<AuthorisationResult> response) {
                        if (response.body() == null) {
                            Log.d(this.getClass().getSimpleName(), "Response has an empty body, unauthorizing");
                            listener.onHandleRequestLoginAttemptFailure();
                        }
                        else {
                            AuthorisationResult authorisationResult = response.body();
                            //TODO listener aanspreken
                            listener.onHandleRequestLoginAttemptSuccess(listener, authorisationResult, email64, password64);

                        }
                    }

                    @Override
                    public void onFailure(Call<AuthorisationResult> call, Throwable t) {
                        Log.d(this.getClass().getSimpleName(),"IN ONFAILURE CALL", t.getCause());

                        listener.onHandleRequestLoginAttemptFailure();
                    }
                });


            }
        }, 2000);

    }

    @Override
    public void handleAuthorisationResult(OnLoginFinishedListener listener, AuthorisationResult authorisationResult, String email64, String password64) {

        if (authorisationResult.getSuccess().equals("false"))
            listener.onAuthorizeFailure(authorisationResult.getCode());
        else {
            // Setting the BaseUser
            BaseUser.getInstance().setIdentifierB64(email64);
            // Generating the new Token
            MobileToken token = new MobileToken(BaseUser.getInstance(), authorisationResult.getToken());
            // Letting the presenter know we have a succesful authentication
            listener.onAuthorizeSuccess((ArrayList<String>) authorisationResult.getRoles(), token);
        }
    }

    @Override
    public void saveUserInfo(SharedPreferences.Editor editor) {
        Log.d(this.getClass().getSimpleName(), "Successful Authorization... Saving token, user, expiredate");
        editor.putString("token", MobileToken.getToken());
        editor.putString("user", MobileToken.getBaseUser().getIdentifierB64());
        editor.putString("expires", String.valueOf(MobileToken.getEndDate()));
    }

}
