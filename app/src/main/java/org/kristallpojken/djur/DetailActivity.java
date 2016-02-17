package org.kristallpojken.djur;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    /*-------------------------------------------------*/
        Intent intent = getIntent();
        String animalKey=intent.getStringExtra("animal");
        TextView animalDescription=(TextView)findViewById(R.id.detailText);
        animalDescription.setText(animalKey);
        //animalDescription.setText();
    }
}
