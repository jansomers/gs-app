package br.com.managersystems.guardasaude.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import br.com.managersystems.guardasaude.login.DummyLogin;
import br.com.managersystems.guardasaude.login.LoginPresenter;
import br.com.managersystems.guardasaude.R;
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

    @Bind(R.id.gs_login_succes_imageview)
    ImageView authenticatingSuccesImageView;

    @Bind(R.id.gs_login_logo)
    ImageView gsLogo;

    private LoginPresenter presenter;


    private final boolean VALIDCREDENTIALS = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        presenter = new LoginPresenter(this);
        init(VALIDCREDENTIALS, authenticatingProgressBar, authenticatingProgressText, authenticatingSuccesImageView);


    }

    private void init(boolean validcredentials, ProgressBar authenticatingProgressBar, TextView authenticatingProgressText, ImageView authenticatingSuccesImageView) {
        activateLogo();
        instantiateDummyData(validcredentials);
        instantiateProgressBar(authenticatingProgressBar, authenticatingProgressText);
    }

    private void activateLogo() {
        Animation logoAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slow_fade_in_animation);
        gsLogo.setVisibility(View.VISIBLE);
        gsLogo.startAnimation(logoAnimation);
    }

    private void instantiateProgressBar(ProgressBar authenticatingProgressBar, TextView authenticatingProgressText) {
        authenticatingProgressBar.setVisibility(View.GONE);
        authenticatingProgressText.setVisibility(View.GONE);
        authenticatingSuccesImageView.setVisibility(View.GONE);
    }

    /**
     * This method is used to instantiate dummy data while under development
     * TODO Remove this class when no longer needed
     *
     * @param type receives the type of the login. Either valid (true) or fake (false)
     */
    private void instantiateDummyData(boolean type) {

        if (type) {
            gsUsernameEditText.setText(DummyLogin.getDummyUserName());
            gsPasswordEditText.setText(DummyLogin.getDummyPassword());
        } else {
            gsUsernameEditText.setText(DummyLogin.getDummyFakeUsername());
            gsPasswordEditText.setText(DummyLogin.getDummyFakePassword());
        }
    }

    @OnClick(R.id.gs_login_btn)
    public void loginClicked(View view) {
        authenticatingProgressBar.setVisibility(View.VISIBLE);
        authenticatingProgressText.setVisibility(View.VISIBLE);
        String email = gsUsernameEditText.getText().toString();

        presenter.authorizeLogin();
        //TODO Remove because only for testing purposes

        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(final Void... params) {
                // Do your loading here. Don't touch any views from here, and then return null
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }


            @Override
            protected void onPostExecute(final Void result) {
                // Update your views here
                authenticatingProgressBar.setVisibility(View.GONE);
                authenticatingSuccesImageView.setVisibility(View.VISIBLE);
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in_animation);
                authenticatingSuccesImageView.startAnimation(animation);
                authenticatingProgressText.setText(getResources().getText(R.string.login_succes));
            }
        }.execute();


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
