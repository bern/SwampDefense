package com.supafly.ryan.swampdefense;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Timer;
import android.os.Handler;

/**
 * Created by Ryan on 9/20/2014.
 */
public class PlayFragment extends Fragment {
    //TODO: Implement lifecycle methods and ImageViews

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_play, container, false);

        final CharacterDrawer characterDrawer = new CharacterDrawer(this.getActivity());
        final EnemyFactory enemyFactory = new EnemyFactory(this.getActivity(), GameController.difficulty);
        final PlayerCharacter albert = new PlayerCharacter(this.getActivity());

        characterDrawer.update();
        rootView.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, final MotionEvent event) {

                characterDrawer.update();
                enemyFactory.moveEnemies();

                if(event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
                    albert.onTouchEvent(event);

                }
                return true;
            }

        });

        return rootView;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


}
