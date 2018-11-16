package win.prashant.progressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    ProgressBar pgbr;
    SeekBar skbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.buttonClickprogress);
        pgbr = findViewById(R.id.progressBar);
        skbar = findViewById(R.id.seekBar);
       skbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           @Override
           public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
               Toast.makeText(getApplicationContext(),"SeekBar Progress:"+progress,Toast.LENGTH_SHORT).show();
           }

           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(),"SeekBar Touch Started",Toast.LENGTH_SHORT).show();
           }

           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(),"SeekBar Touch Stopped" ,Toast.LENGTH_SHORT).show();
           }
       });
    }

    public  void onBtnClick(View v){
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                for (int i =0; i<=100;){
                    try {
                        sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    pgbr.setProgress(i);
                    i = i+ 10;
                }
            }
        };
        thread.start();
    }

}
