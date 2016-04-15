package br.com.managersystems.guardasaude.login;

import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.managersystems.guardasaude.ui.LoginActivity;

/**
 * Created by Jan on 14/04/2016.
 */
public class LoginPresenter implements ILoginPresenter, OnDomainRetrievedListener, OnLoginFinishedListener {

    ILoginView loginActivity;
    LoginInteractor loginInteractor;
    DomainInteractor domainInteractor;

    private final String SUCCESMESSAGE = "Succes!";
    private final String FAILEDMESSAGE = "Failed Login.";


    public LoginPresenter(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
        loginInteractor = new LoginInteractor();
        domainInteractor = new DomainInteractor(new ArrayList<AccessDomain>());
    }

    @Override
    public void authorizeLogin(String email, String password) {
        Log.d(this.getClass().getSimpleName(), "Presenter received loginRequest -- Forwarding to Interactor");
        loginInteractor.validateCredentials(this, email, password);


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
