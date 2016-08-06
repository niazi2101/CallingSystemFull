package com.main.callingsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CallDetail extends Activity {

    TextView tvCallDetail;
    Button btnCallLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_detail);

    tvCallDetail = (TextView) findViewById(R.id.textViewCallDetail);
    btnCallLog = (Button) findViewById(R.id.buttonCallLog);

    String msg = getIntent().getStringExtra("MSG");

        tvCallDetail.setText(msg);
    }

    public void CallLog(View view) {

        Intent intent = new Intent(getApplicationContext(), CallLogActivity.class);

        //intent.putExtra("MSG", msg);
        startActivity(intent);

    }
}
