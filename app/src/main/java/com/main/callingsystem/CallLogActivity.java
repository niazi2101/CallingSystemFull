package com.main.callingsystem;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.main.callingsystem.database.DBhandler;

public class CallLogActivity extends Activity {

    DBhandler handler;

    int callID;
    TextView tv2;

    String data;

    String remoteID, dateTime, duration, endCause;
    Cursor rs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_log);

        callID = 1;
        tv2 = (TextView) findViewById(R.id.textView2);

        handler = new DBhandler(this);

        data = "\n ";
      /*
        try {


            if (callID > 0) {
                Cursor rs = handler.getCallLog(callID);

                rs.moveToFirst();
                remoteID = rs.getString(rs.getColumnIndex(handler.CALLOG_COLUMN_CALLEE_NAME));
                dateTime = rs.getString(rs.getColumnIndex(handler.CALLOG_COLUMN_DATETIME));
                duration = rs.getString(rs.getColumnIndex(handler.CALLOG_COLUMN_DURATION));
                endCause = rs.getString(rs.getColumnIndex(handler.CALLOG_COLUMN_ENDCAUSE));

                if (!rs.isClosed()) {
                    rs.close();
                }

                try {
                    while (rs.moveToNext()) {
                        remoteID = rs.getString(rs.getColumnIndex(handler.CALLOG_COLUMN_CALLEE_NAME));
                        dateTime = rs.getString(rs.getColumnIndex(handler.CALLOG_COLUMN_DATETIME));
                        duration = rs.getString(rs.getColumnIndex(handler.CALLOG_COLUMN_DURATION));
                        endCause = rs.getString(rs.getColumnIndex(handler.CALLOG_COLUMN_ENDCAUSE));

                    }
                } finally {
                    cursor.close();
                }

                data = remoteID + "\n Time: " + dateTime + "\n Duration: " + "\n End Cause:" + endCause;

                tv2.setText(data);

            }
        } catch (Exception e) {
            Log.e("SQL", "ERROR INSERTING DATA: " + e.getMessage().toString());
        }
    */

        //Cursor rs = handler.getCallLog(callID);

        try
    {
        rs = handler.getAllCallLogs();
        rs.moveToFirst();


        if (rs.moveToFirst()) {
            do {
                // do what you need with the cursor here
                remoteID = rs.getString(rs.getColumnIndex(handler.CALLOG_COLUMN_CALLEE_NAME));
                dateTime = rs.getString(rs.getColumnIndex(handler.CALLOG_COLUMN_DATETIME));
                duration = rs.getString(rs.getColumnIndex(handler.CALLOG_COLUMN_DURATION));
                endCause = rs.getString(rs.getColumnIndex(handler.CALLOG_COLUMN_ENDCAUSE));

                data = remoteID + "\n Time: " + dateTime + "\n Duration: " +duration
                +"\n End Cause:" + endCause;


            } while (rs.moveToNext());
        }
    }
    catch(Exception f)
    {
        Log.e("SQL", "ERROR INSERTING DATA: " + f.getMessage().toString());
    }finally {
        if (!rs.isClosed()) {
            rs.close();
        }
    }

        tv2.setText(data);
}
}
