package sg.edu.rp.c347.id19023980.demoexplicitintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int requestCodeForSupermanStats = 1;
    int requestCOdeForBatmanStats = 2;
    TextView tvSuperman, tvBatman;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSuperman = findViewById(R.id.textViewSuperman);
        tvBatman = findViewById(R.id.textViewBatman);

        tvSuperman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hero superman = new Hero("Superman",100,60);
                Intent i = new Intent(MainActivity.this,HeroStatsActivity.class);

                i.putExtra("hero", superman);
                startActivityForResult(i, requestCodeForSupermanStats);

            }
        });

        tvBatman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hero Batman = new Hero("Batman",60,90);
                Intent i = new Intent(MainActivity.this,HeroStatsActivity.class);
                i.putExtra("hero", Batman);
                startActivityForResult(i,requestCOdeForBatmanStats);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            if(data != null){
                String like = data.getStringExtra("like");
                String statement = "";

                if (requestCode == requestCodeForSupermanStats){
                    statement = "You " + like + " Superman";
                }
                if(requestCode == requestCOdeForBatmanStats){
                    statement = "You " + like + " Batman";
                }
                Toast.makeText(MainActivity.this, statement,Toast.LENGTH_LONG).show();
            }
        }
    }
}
