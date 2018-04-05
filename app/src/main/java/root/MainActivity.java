package root;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.akshay.mvp_example_android.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((App)getApplication()).getApplicationComponent().inject(this);
    }
}
