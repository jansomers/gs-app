package br.com.managersystems.guardasaude.login;

/**
 * Created by Jan on 14/04/2016.
 */
public interface OnLoginFinishedListener {
    void onSuccess(boolean manager);
    void onFailure();
}
