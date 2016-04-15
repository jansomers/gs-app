package br.com.managersystems.guardasaude.login;

import java.util.ArrayList;

/**
 * Created by Jan on 14/04/2016.
 */
public interface ILoginView {
    void navigateToOverviewActivity();

    void showServerOptionDialog();

    void domainRetrievedSuccesfully(ArrayList<AccessDomain> accessDomainArrayList);

    void loginSuccess(boolean manager);

    void loginFailed();

    void domainRetrievedFailed();
}
