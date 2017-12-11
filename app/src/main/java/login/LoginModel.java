package login;

/**
 * Created by akshay on 12/10/17.
 */

public class LoginModel implements LoginActivityMVP.Model {

    LoginRepository repository;

    public LoginModel(LoginRepository repository){
        this.repository = repository;
    }

    @Override
    public void createUser(String fname, String lname) {
        repository.saveUser(new User(fname,lname));
    }

    @Override
    public User getUser() {
        return repository.getUser();
    }
}
