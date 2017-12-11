package login;

/**
 * Created by akshay on 12/10/17.
 */

public interface LoginRepository {

    User getUser();
    void saveUser();
}
