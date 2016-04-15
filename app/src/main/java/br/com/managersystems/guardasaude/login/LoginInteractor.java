package br.com.managersystems.guardasaude.login;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;

/**
 * Created by Jan on 15/04/2016.
 */
public class LoginInteractor implements ILoginInteractor {


    private final String MANAGER_DOMAIN= "managersystems.com.br";
    @Override
    public void validateCredentials(final OnLoginFinishedListener listener, final String email, final String password) {
        //TODO Remove because only for testing
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                if (isValidEmail(email)) {
                    Log.d(LoginInteractor.class.getSimpleName(), "Email is VALID");
                    if (isCorrectPassword(password)) {
                        Log.d(LoginInteractor.class.getSimpleName(), "Password is VALID");
                        if (isManager(email)) {
                            Log.d(LoginInteractor.class.getSimpleName(), "Authenticated manager account");
                            listener.onSuccess(true);
                        }
                        else {
                            Log.d(LoginInteractor.class.getSimpleName(), "Authenticated user account");
                            listener.onSuccess(false);
                        }
                    }
                    else {
                        Log.d(LoginInteractor.class.getSimpleName(), "Password is INVALID");
                        listener.onFailure();
                    }


                } else {
                    Log.d(LoginInteractor.class.getSimpleName(), "Email is INVALID");
                    listener.onFailure();
                }
            }
        }, 2000);

    }


    private boolean isCorrectPassword(String password) {
        Log.d(LoginInteractor.class.getSimpleName(), "Validating password...");
        return password.equals(DummyLogin.getDummyPassword());
    }

    private boolean isManager(String email) {
        Log.d(LoginInteractor.class.getSimpleName(), "Validating manager...");
        String domain = email.split("@")[1];
        return domain.equals(MANAGER_DOMAIN);
    }

    private boolean isValidEmail(String email) {
        Log.d(LoginInteractor.class.getSimpleName(), "Validating email...");
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
