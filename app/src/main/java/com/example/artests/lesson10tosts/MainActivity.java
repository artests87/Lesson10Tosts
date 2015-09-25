package com.example.artests.lesson10tosts;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showToast(View view) {
        Toast toast=Toast.makeText(getApplicationContext(), R.string.button1Toast, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        LinearLayout linearLayout=(LinearLayout)toast.getView();
        ImageView imageView=new ImageView(getApplicationContext());
        imageView.setImageResource(R.drawable.ic_launcher);
        linearLayout.addView(imageView, 0);
        toast.show();

    }

    public void showToastProgram(View view){
        LayoutInflater inflater=getLayoutInflater();
        View layout=inflater.inflate(R.layout.custom_layout, (ViewGroup) findViewById(R.id.custom_layout));
        Toast toast=new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
    public void showToastProgramNewThread(View view){
        mainProcessing();
    }
    private void mainProcessing() {
        Thread thread = new Thread(doBackgroundThreadProcessing);
        thread.start();
    }

    private Runnable doBackgroundThreadProcessing = new Runnable() {
        public void run() {
            backgroundThreadProcessing();
        }
    };

    private void backgroundThreadProcessing() {
        handler.post(doUpdateGUI);
    }

    // Объект Runnable, который вызывает метод из потока GUI
    private Runnable doUpdateGUI = new Runnable() {
        public void run() {
            Context context = getApplicationContext();
            String msg = "To open mobile development!";
            int duration = Toast.LENGTH_SHORT;
            Toast.makeText(context, msg, duration).show();
        }
    };

}
