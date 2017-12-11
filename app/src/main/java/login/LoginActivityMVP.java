package login;

/**
 * Created by akshay on 12/10/17.
 */

public interface LoginActivityMVP {

    interface View{

        String getFirstName();
        String getLastName();

        void setFirstName(String firstName);
        void setLastName(String lastName);

        void showUserNotAvailable();
        void showUserAdded();
        void showInputError();

    }

    interface Presenter{

        void setView(LoginActivityMVP.View view);
        void loginbuttonClicked();
        void getCurrentUser();

    }

    interface Model{

        void createUser(String fname, String lname);
        User getUser();


    }
}
