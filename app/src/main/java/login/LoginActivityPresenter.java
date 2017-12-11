package login;

import android.support.annotation.Nullable;

/**
 * Created by akshay on 12/10/17.
 */

public class LoginActivityPresenter implements LoginActivityMVP.Presenter {

    @Nullable
    private LoginActivityMVP.View view;
    private LoginActivityMVP.Model model;

    public LoginActivityPresenter(LoginActivityMVP.Model model){
        this.model = model;
    }


    @Override
    public void setView(LoginActivityMVP.View view) {

        this.view = view;

    }

    @Override
    public void loginbuttonClicked() {

        if(view != null){


        }


    }

    @Override
    public void getCurrentUser() {

    }
}
