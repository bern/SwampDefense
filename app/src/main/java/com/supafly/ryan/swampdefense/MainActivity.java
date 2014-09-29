package com.supafly.ryan.swampdefense;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    public static GameController gameController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TopFragment topFragment = (TopFragment)getFragmentManager().findFragmentById(R.id.fragment_top);
        final PlayFragment playFragment = (PlayFragment)getFragmentManager().findFragmentById(R.id.fragment_play);
        final InfoFragment infoFragment = (InfoFragment)getFragmentManager().findFragmentById(R.id.fragment_info);
        final BannerFragment bannerFragment = (BannerFragment)getFragmentManager().findFragmentById(R.id.fragment_banner);

        gameController = new GameController();
    }



}
