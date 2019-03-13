package com.example.counrdowntimer;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int countDown =99;
    private static final String CURRENT_COUNTER ="counter";
    private boolean wasRunning=false;
    private boolean running=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null){
            countDown=savedInstanceState.getInt(CURRENT_COUNTER);
        }
        //Running true  (this statement auto runs the app )
        countDown();
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(CURRENT_COUNTER,countDown);

    }

    private void countDown(){

        final Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                final TextView textView2 =findViewById(R.id.textView2);
                textView2.setText(Integer.toString(countDown));
                //Reset the counter to avoid getting minus numbers
                if(countDown == 0){
                    countDown = 99;
                }
                if(running) {
                    countDown--;
                }
                handler.postDelayed(this,1000);

            }
        });


    }

    protected  void startCounter(View view){
        running = true;
    }

    protected  void StopCounter(View view){
        running = false;
    }


    @Override
    public  void onPause(){
        super.onPause();
    }


    //these two methods are used to keep going the calculations as it is when going back and comming front
    @Override
    public void onRestart(){
        super.onRestart();
        running = true;
    }

    @Override
    public void  onStop(){
        super.onStop();
            running =false;
    }
}
