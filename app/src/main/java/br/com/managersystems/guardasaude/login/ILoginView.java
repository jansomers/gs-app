package br.com.managersystems.guardasaude.login;

/**
 * Created by Jan on 14/04/2016.
 */
public interface ILoginView {
    void navigateToOverviewActivity();
    void loginSucces();
    void loginFailed();
    void loginManager();
}
