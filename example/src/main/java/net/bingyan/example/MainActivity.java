package net.bingyan.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import net.bingyan.logger.BLogger;
import net.bingyan.logger.Setting;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BLogger.v("da");
        BLogger.getSetting().disable(Setting.WhichLevel.ERROR);
        BLogger.e("dadf");
        BLogger.getSetting().enable(Setting.WhichLevel.ERROR);
        BLogger.v("fsafdsf");


    }
}
