package br.com.managersystems.guardasaude.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.managersystems.guardasaude.R;
import br.com.managersystems.guardasaude.login.AccessDomain;
import br.com.managersystems.guardasaude.login.DummyLogin;
import br.com.managersystems.guardasaude.login.ILoginView;
import br.com.managersystems.guardasaude.login.LoginPresenter;
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
    ImageView authenticatingFinishedImageView;

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
        init(VALIDCREDENTIALS, authenticatingProgressBar, authenticatingProgressText, authenticatingFinishedImageView);


    }

    private void init(boolean validcredentials, ProgressBar authenticatingProgressBar, TextView authenticatingProgressText, ImageView authenticatingSuccesImageView) {
        activateLogo();
        instantiateDummyData(!validcredentials);
        instantiateProgressBar();
    }

    private void activateLogo() {
        Animation logoAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slow_fade_in_animation);
        gsLogo.setVisibility(View.VISIBLE);
        gsLogo.startAnimation(logoAnimation);
    }

    private void instantiateProgressBar() {
        authenticatingProgressBar.setVisibility(View.GONE);
        authenticatingProgressText.setVisibility(View.GONE);
        authenticatingFinishedImageView.setVisibility(View.GONE);
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
            gsUsernameEditText.setText(DummyLogin.getDummyManagerUsername());
            gsPasswordEditText.setText(DummyLogin.getDummymanagerpasword());
        }
    }

    @OnClick(R.id.gs_login_btn)
    public void loginClicked(View view) {
        Log.d("LoginActivity: ", "Login button was clicked");
        showAuthenticatingProgress();
        String email = gsUsernameEditText.getText().toString();
        String password = gsPasswordEditText.getText().toString();
        presenter.authorizeLogin(email, password);
    }

    private void showAuthenticatingProgress() {
        authenticatingProgressBar.setVisibility(View.VISIBLE);
        authenticatingProgressText.setText(getResources().getText(R.string.Authenticating));
        authenticatingProgressText.setTextColor(ContextCompat.getColor(this, R.color.colorAccent300));
        authenticatingProgressText.setVisibility(View.VISIBLE);
        authenticatingFinishedImageView.setVisibility(View.GONE);

    }

    @Override
    public void navigateToOverviewActivity() {
        Intent intent = new Intent(this, MainTabActivity.class);
        startActivity(intent);


    }

    @Override
    public void showServerOptionDialog() {
        presenter.retrieveDomains();

    }

    @Override
    public void domainRetrievedSuccesfully(ArrayList<AccessDomain> accessDomainArrayList) {
        String domains[] = new String[accessDomainArrayList.size()];
        int placeCounter = 0;
        for (AccessDomain domain : accessDomainArrayList) {
            domains[placeCounter] = domain.getTagName();
            placeCounter++;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //builder.setTitle(getResources().getText(R.string.choose_domain));
        builder.setCustomTitle(getLayoutInflater().inflate(R.layout.domain_dialog_title, null));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.domain_dialog,domains);

        builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //TODO ADD event
            }
        });
        AlertDialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.white_dialog_window);

        dialog.show();

    }

    @Override
    public void loginSuccess(boolean manager) {
        hideProgressBar();
        showSuccessfulLogin(manager);
        if (!manager) {
            navigateToOverviewActivity();
        }
        else {
            showServerOptionDialog();
        }
    }



    @Override
    public void loginFailed() {
        hideProgressBar();
        showFailedLogin();

    }

    @Override
    public void domainRetrievedFailed() {

    }

    private void showFailedLogin() {
        authenticatingFinishedImageView.setImageResource(R.drawable.ic_error_36dp);
        authenticatingFinishedImageView.setVisibility(View.VISIBLE);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in_animation);
        authenticatingFinishedImageView.startAnimation(animation);
        authenticatingProgressText.setTextColor(ContextCompat.getColor(this, R.color.colorError));
        authenticatingProgressText.setText(getResources().getText(R.string.login_failed));
    }


    private void hideProgressBar() {
        authenticatingProgressBar.setVisibility(View.GONE);
    }

    private void showSuccessfulLogin(boolean manager) {
        if (manager) {
            authenticatingFinishedImageView.setImageResource(R.drawable.ic_fingerprint);
            authenticatingProgressText.setText(getResources().getText(R.string.login_manager));
        }
        else {
            authenticatingFinishedImageView.setImageResource(R.drawable.ic_check_circle_36dp);
            authenticatingProgressText.setText(getResources().getText(R.string.login_succes));
        }
        authenticatingFinishedImageView.setVisibility(View.VISIBLE);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in_animation);
        authenticatingFinishedImageView.startAnimation(animation);
        authenticatingProgressText.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));

    }
}
