package br.com.managersystems.guardasaude.login;

/**
 * Created by Jan on 15/04/2016.
 */
public interface ILoginInteractor {
    void validateCredentials(OnLoginFinishedListener listener, String email, String password);

}
