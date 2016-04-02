package hb.halla;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    private boolean mIsBackButtonPressed;
    private static final int SPLASH_DURATION = 2000; // 2 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handler = new Handler();

        //run a thread after 2 seconds to start the home screen
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //make sure we close the splash screen so the user won't come back when pressing back key
                finish();

                if (!mIsBackButtonPressed) {
                    //start the home screen if the back button wasn't pressed already
                    Intent intent = new Intent(SplashScreen.this, MenuActivity.class);
                    SplashScreen.this.startActivity(intent);
                }
            }
        }, SPLASH_DURATION);


    }

    @Override
    public void onBackPressed() {

        //set the flag to true so the next activity won't start up
        mIsBackButtonPressed = true;
        super.onBackPressed();

    }

}
