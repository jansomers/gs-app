package br.com.managersystems.guardasaude;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import br.com.managersystems.guardasaude.login.ILoginView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    @Bind(R.id.gs_login_username)
    EditText gsUsernameEditText;

    @Bind(R.id.gs_login_password)
    EditText gsPasswordEditText;

    @Bind(R.id.gs_login_progressbar)
    ProgressBar authenticatingProgressBar;

    @Bind(R.id.gs_login_progress_text)
    TextView authenticatingProgressText;

    private LoginPresenter presenter;


    private final boolean VALIDCREDENTIALS=true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        presenter = new LoginPresenter(this);

        init(VALIDCREDENTIALS, authenticatingProgressBar, authenticatingProgressText);


    }

    private void init(boolean validcredentials, ProgressBar authenticatingProgressBar, TextView authenticatingProgressText) {
        instantiateDummyData(validcredentials);
        instantiateProgressBar(authenticatingProgressBar, authenticatingProgressText);
    }

    private void instantiateProgressBar(ProgressBar authenticatingProgressBar, TextView authenticatingProgressText) {
        authenticatingProgressBar.setVisibility(View.GONE);
        authenticatingProgressText.setVisibility(View.GONE);
    }

    /**
     * This method is used to instantiate dummy data while under development
     * TODO Remove this class when no longer needed
     * @param type receives the type of the login. Either valid (true) or fake (false)
     *
     */
    private void instantiateDummyData(boolean type) {

        if (type) {
            gsUsernameEditText.setText(DummyLogin.getDummyUserName());
            gsPasswordEditText.setText(DummyLogin.getDummyPassword());
        }
        else {
            gsUsernameEditText.setText(DummyLogin.getDummyFakeUsername());
            gsPasswordEditText.setText(DummyLogin.getDummyFakePassword());
        }
    }

    @OnClick(R.id.gs_login_btn)
    public void loginClicked(View view){
        authenticatingProgressBar.setVisibility(View.VISIBLE);
        authenticatingProgressText.setVisibility(View.VISIBLE);

    }

    @Override
    public void navigateToOverviewActivity() {

    }

    @Override
    public void loginSucces() {

    }

    @Override
    public void loginFailed() {

    }

    @Override
    public void loginManager() {

    }
}
