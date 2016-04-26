package br.com.managersystems.guardasaude.login;

import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;

import br.com.managersystems.guardasaude.login.domain.MobileToken;
import br.com.managersystems.guardasaude.login.domain.UserRoleEnum;
import br.com.managersystems.guardasaude.ui.LoginActivity;
import br.com.managersystems.guardasaude.util.Base64Interactor;

/**
 * Created by Jan on 14/04/2016.
 */
public class LoginPresenter implements ILoginPresenter, OnDomainRetrievedListener, OnLoginFinishedListener {

    ILoginView loginActivity;
    SharedPreferences sp;
    LoginInteractor loginInteractor;
    DomainInteractor domainInteractor;
    Base64Interactor base64Interactor;
    SharedPreferences.Editor editor;

    public LoginPresenter(LoginActivity loginActivity, SharedPreferences sp) {
        this.loginActivity = loginActivity;
        this.sp = sp;
        editor = sp.edit();
        loginInteractor = new LoginInteractor();
        domainInteractor = new DomainInteractor(new ArrayList<AccessDomain>());
        base64Interactor = new Base64Interactor();
    }

    @Override
    public void authorizeLogin(String email, String password) {
        Log.d(this.getClass().getSimpleName(), "Presenter received loginRequest -- Forwarding to Encoder");
        String[] encodedLogin = encodeLogin(email, password);
        Log.d(this.getClass().getSimpleName(), "Presenter received encoded login -- Forwarding to Validation");
        Log.d(this.getClass().getSimpleName(), "Encoded login: " + encodedLogin[0] + "// password: " + encodedLogin[1]);
        loginInteractor.handleRequestLoginAttempt(this, encodedLogin[0], encodedLogin[1]);


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
    public void onHandleRequestLoginAttemptFailure() {
        loginActivity.requestFailed();

    }

    @Override
    public void onAuthorizeFailure(String code) {
        loginActivity.loginFailed(code);

    }
    @Override
    public void onAuthorizeSuccess(ArrayList<String> roles, MobileToken token) {
        if (roles.isEmpty()) {
            Log.d(this.getClass().getSimpleName(),"No roles identified for User! Failing login");
            loginActivity.loginFailed();
        }
        else if (roles.size() > 1) {
            Log.d(this.getClass().getSimpleName(), "Multiple roles identified for User! Forwarding");
            loginActivity.showRoleOptionDialog(roles);
        }
        else {
            //TODO try to do in interactor
            saveInfo();
            if (roles.get(0).equals(UserRoleEnum.ROLE_HEALTH_PROFESSIONAL.toString())) {
                Log.d(this.getClass().getSimpleName(), "Health Professional Identified! Forwarding to view!");
                loginActivity.loginSuccess(false);
            }
            else if (roles.get(0).equals(UserRoleEnum.ROLE_PATIENT.toString())) {
                Log.d(this.getClass().getSimpleName(), "Health Professional Identified! Forwarding to view!");
                loginActivity.loginSuccess(true);
            }
        }
    }

    private void saveInfo() {
        Log.d(this.getClass().getSimpleName(), "Succesful Auhorization... Saving token, user, expiredate");
        editor.putString("token", MobileToken.getToken());
        editor.putString("user", MobileToken.getBaseUser().getIdentifierB64());
        editor.putString("expires", String.valueOf(MobileToken.getEndDate()));
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
