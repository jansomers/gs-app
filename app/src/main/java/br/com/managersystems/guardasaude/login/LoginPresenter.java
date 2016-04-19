package br.com.managersystems.guardasaude.login;

import android.util.Log;

import java.util.ArrayList;

import br.com.managersystems.guardasaude.ui.LoginActivity;
import br.com.managersystems.guardasaude.util.Base64Interactor;

/**
 * Created by Jan on 14/04/2016.
 */
public class LoginPresenter implements ILoginPresenter, OnDomainRetrievedListener, OnLoginFinishedListener {

    ILoginView loginActivity;
    LoginInteractor loginInteractor;
    DomainInteractor domainInteractor;
    Base64Interactor base64Interactor;

    public LoginPresenter(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
        loginInteractor = new LoginInteractor();
        domainInteractor = new DomainInteractor(new ArrayList<AccessDomain>());
        base64Interactor = new Base64Interactor();
    }

    @Override
    public void authorizeLogin(String email, String password) {
        Log.d(this.getClass().getSimpleName(), "Presenter received loginRequest -- Forwarding to Encoder");
        String[] encodedLogin = encodeLogin(email,password);
        Log.d(this.getClass().getSimpleName(), "Presenter received encoded login -- Forwarding to Validation");
        Log.d(this.getClass().getSimpleName(), "Encoded login: " + encodedLogin[0] + "// password: " + encodedLogin[1]);
        loginInteractor.validateCredentials(this, encodedLogin[0], encodedLogin[1]);


    }

    @Override
    public String[] encodeLogin(String email, String password) {
        return new String[]{base64Interactor.encodeStringToBase64(email), base64Interactor.encodeStringToBase64(password)};
    }

    @Override
    public void retrieveDomains() {
        domainInteractor.getDomains(this);

    }

    @Override
    public void onSuccess(boolean manager) {
        loginActivity.loginSuccess(manager);
    }

    @Override
    public void onFailure() {
        loginActivity.loginFailed();

    }

    @Override
    public void onDomainRetrieved(ArrayList<AccessDomain> domainList) {
        loginActivity.domainRetrievedSuccesfully(domainList);
    }

    @Override
    public void onDomainFailed() {
        loginActivity.domainRetrievedFailed();
    }
}
