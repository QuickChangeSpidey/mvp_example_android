package login;

/**
 * Created by akshay on 12/10/17.
 */

public class MemoryRepository implements LoginRepository {

    User user;

    @Override
    public User getUser() {

        if(user==null){
            User user = new User("Fox", "Muler");
            user.setId(0);
            return user;
        }

        else{
            return user;
        }
    }

    @Override
    public void saveUser(User user) {

        if(user == null){
            user = getUser();
        }

        this.user = user;

    }
}
