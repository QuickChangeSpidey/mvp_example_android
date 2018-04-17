package login;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.akshay.mvp_example_android.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import root.App;

public class LoginActivity extends Activity implements LoginActivityMVP.View {

    @Inject
    LoginActivityMVP.Presenter presenter;

    @BindView(R.id.firstname)
    EditText fname;
    @BindView(R.id.lastname)
    EditText lname;
    @BindView(R.id.login_btn)
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        ((App)getApplication()).getApplicationComponent().inject(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loginbuttonClicked();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.getCurrentUser();
    }

    @Override
    public String getFirstName() {
        return fname.getText().toString();
    }

    @Override
    public String getLastName() {
        return lname.getText().toString();
    }

    @Override
    public void setFirstName(String firstName) {
        fname.setText(firstName);
    }

    @Override
    public void setLastName(String lastName) {
        lname.setText(lastName);
    }

    @Override
    public void showUserNotAvailable() {
        Toast.makeText(this, "User Not available",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showUserAdded() {
        Toast.makeText(this, "User added",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showInputError() {
        Toast.makeText(this, "First name and Last name cannot be empty",Toast.LENGTH_LONG).show();
    }
}
