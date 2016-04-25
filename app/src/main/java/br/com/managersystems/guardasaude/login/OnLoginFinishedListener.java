package br.com.managersystems.guardasaude.login;

/**
 * Created by Jan on 14/04/2016.
 */
public interface OnLoginFinishedListener {

    void onHandleRequestLoginAttemptFailure();
    void onAuthorizeFailure(String code);
    void onAuthorizeSuccess(ArrayList<String> roles, MobileToken token);
}
