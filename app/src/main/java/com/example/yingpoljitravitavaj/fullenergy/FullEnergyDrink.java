/*Create by Yingpol Jitravitavaj 57070503457 25/05/2560*/

package com.example.yingpoljitravitavaj.fullenergy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

import static android.R.attr.button;

public class FullEnergyDrink extends AppCompatActivity {

    TextView textView;
    TextView textView1;
    TextView textView2;
    int Drinked;
    //Button btnAddWater1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_energy_drink);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        Drinked = Integer.parseInt(message);
        textView = (TextView) findViewById(R.id.txtAmountGoal);
        textView.setText("2000 ml.");
        textView1 = (TextView) findViewById(R.id.txtAmountDrinked);
        textView1.setText(Drinked+ " ml.");
        textView2 = (TextView) findViewById(R.id.txtAmountRemaining);
        textView2.setText("0 ml.");
        if(Drinked>2000){
            TextView tv = (TextView)((TextView) findViewById(R.id.txtAmountGoal));
            tv.setText("");
            tv = (TextView)((TextView) findViewById(R.id.txtAmountofWaterRemaining));
            tv.setText("");
            tv = (TextView)((TextView) findViewById(R.id.txtDash));
            tv.setText("");
            tv = (TextView)((TextView) findViewById(R.id.txtRemaining));
            tv.setText("");
            tv = (TextView)((TextView) findViewById(R.id.txtGoal));
            tv.setText("");
            textView2.setText("Done!");
        }

        final Button button = (Button) findViewById(R.id.btnAddWater);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String[] line = textView.getText().toString().split(" ");
                String[] line1 = textView1.getText().toString().split(" ");
                int Amount = 2000;//Integer.valueOf(line[0])-200;
                Drinked = Integer.valueOf(line1[0])+200;
                if(Drinked<2000){
                    //textView.setText(Integer.toString(Amount)+" ml.");
                    textView2.setText(Integer.toString(Amount-Drinked)+" ml.");
                }
                else {
                    TextView tv = (TextView)((TextView) findViewById(R.id.txtAmountGoal));
                    tv.setText("");
                    tv = (TextView)((TextView) findViewById(R.id.txtAmountofWaterRemaining));
                    tv.setText("");
                    tv = (TextView)((TextView) findViewById(R.id.txtDash));
                    tv.setText("");
                    tv = (TextView)((TextView) findViewById(R.id.txtRemaining));
                    tv.setText("");
                    tv = (TextView)((TextView) findViewById(R.id.txtGoal));
                    tv.setText("");
                    textView2.setText("Done!");
                }
                textView1.setText(Integer.toString(Drinked)+" ml.");
            }
        });
    }

    /*@Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.ECLAIR
                && keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
            Intent intent = new Intent();
            intent.putExtra("editTextValue", Integer.toString(Drinked));
            setResult(RESULT_OK, intent);
            finish();
            onBackPressed();
        }

        return super.onKeyDown(keyCode, event);
    }*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent();
                intent.putExtra("editTextValue", Integer.toString(Drinked));
                setResult(RESULT_OK, intent);
                finish();
                break;
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("editTextValue", Integer.toString(Drinked));
        setResult(RESULT_OK, intent);
        finish();
    }
}
