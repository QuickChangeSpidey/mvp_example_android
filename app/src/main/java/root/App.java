package root;

import android.app.Application;

import com.example.akshay.mvp_example_android.DaggerApplicationComponent;

/**
 * Created by akshay on 12/10/17.
 */

public class App extends Application {


    private ApplicationComponent component;


    @Override
    public void onCreate() {
        super.onCreate();


        component = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();

    }


   public ApplicationComponent getApplicationComponent(){

       return  component;

   }


}
