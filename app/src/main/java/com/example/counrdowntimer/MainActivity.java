package com.example.counrdowntimer;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int countDown =99;
    private static final String CURRENT_COUNTER ="counter";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null){
            countDown=savedInstanceState.getInt(CURRENT_COUNTER);
        }

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
                countDown--;
                handler.postDelayed(this,1000
                );

            }
        });


    }
}
