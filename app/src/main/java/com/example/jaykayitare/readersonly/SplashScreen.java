package com.example.jaykayitare.readersonly;

import android.app.Activity;
import android.content.Intent;
import android.provider.SyncStateContract;

import com.badoo.mobile.util.WeakHandler;
import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;


/**
 * Created by varsovski on 28-Sep-15.
 */
public class SplashScreen extends AwesomeSplash {


        //DO NOT OVERRIDE onCreate()!
        //if you need to start some services do it in initSplash()!


        @Override
        public void initSplash(ConfigSplash configSplash) {

        /* you don't have to override every property */

            //Customize Circular Reveal
            configSplash.setBackgroundColor(R.color.colorPrimary); //any color you want form colors.xml
            configSplash.setAnimCircularRevealDuration(2000); //int ms
            configSplash.setRevealFlagX(Flags.REVEAL_RIGHT);  //or Flags.REVEAL_LEFT
            configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM); //or Flags.REVEAL_TOP

            //Choose LOGO OR PATH; if you don't provide String value for path it's logo by default

            //Customize Logo
            configSplash.setLogoSplash(R.mipmap.logo); //or any other drawable
            configSplash.setAnimLogoSplashDuration(2000); //int ms
            configSplash.setAnimLogoSplashTechnique(Techniques.Bounce); //choose one form Techniques (ref: https://github.com/daimajia/AndroidViewAnimations)


            //Customize Path
            //configSplash.setPathSplash(Constants.DROID_LOGO); //set path String
            configSplash.setOriginalHeight(400); //in relation to your svg (path) resource
            configSplash.setOriginalWidth(400); //in relation to your svg (path) resource
            configSplash.setAnimPathStrokeDrawingDuration(3000);
            configSplash.setPathSplashStrokeSize(3); //I advise value be <5
            configSplash.setPathSplashStrokeColor(R.color.colorAccent); //any color you want form colors.xml
            configSplash.setAnimPathFillingDuration(3000);
            configSplash.setPathSplashFillColor(R.color.colorPrimary); //path object filling color


            //Customize Title
            configSplash.setTitleSplash("My Awesome App");
            configSplash.setTitleTextColor(R.color.colorAccent);
            configSplash.setTitleTextSize(30f); //float value
            configSplash.setAnimTitleDuration(3000);
            configSplash.setAnimTitleTechnique(Techniques.FlipInX);
            configSplash.setTitleFont("fonts/myfont.ttf"); //provide string to your font located in assets/fonts/

        }

    @Override
    public void animationsFinished() {

        //transit to another activity the activity here
        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
//                    Intent intent = new Intent(SplashScreen.this,App_Activity.class);
//                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }
    @Override
    public void onStop(){
        super.onStop();
        Intent intent = new Intent(getApplicationContext(),App_Activity.class);
        startActivity(intent);
    }

}
