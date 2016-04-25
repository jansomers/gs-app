package br.com.managersystems.guardasaude.login;

import java.util.ArrayList;

import br.com.managersystems.guardasaude.login.domain.MobileToken;

public interface OnLoginFinishedListener {

    void onHandleRequestLoginAttemptFailure();
    void onAuthorizeFailure(String code);
    void onAuthorizeSuccess(ArrayList<String> roles, MobileToken token);
}
