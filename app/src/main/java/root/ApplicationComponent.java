package root;

import javax.inject.Singleton;

import dagger.Component;
import login.LoginActivity;
import login.LoginModule;

/**
 * Created by akshay on 12/10/17.
 */


@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class})
public interface ApplicationComponent {


    void inject(MainActivity target);
    void inject(LoginActivity target);

}
