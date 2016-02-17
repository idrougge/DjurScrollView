package org.kristallpojken.djur;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        /* ------------------------------------------------------------------------------*/
        Animal lo=new Animal("lo","Ett kattdjur");
        TextView textruta = (TextView) findViewById(R.id.scrollText);
        textruta.setText(lo.name);
        LinearLayout scrollContent = (LinearLayout) findViewById(R.id.scrollContent);
        TextView bla=new TextView(this);
        bla.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        bla.setText("hej");
        scrollContent.addView(bla);
        Zoo zoo=new Zoo();
        bla.setText(zoo.getFirstAnimal().name);
        Animal animal;
        while( ( animal=zoo.getNextAnimal() ) != null )
        {
            TextView animalTextView=new TextView(this);
            animalTextView.setLayoutParams(new LinearLayout.LayoutParams(
                                           LinearLayout.LayoutParams.MATCH_PARENT,
                                           ViewGroup.LayoutParams.WRAP_CONTENT));
            animalTextView.setPadding(16, 16, 16, 16);
            animalTextView.setAllCaps(true);
            animalTextView.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    TextView text = (TextView) v; // Att casta om till ett typdefinierat objekt verkar nödvändigt
                    Intent intent = new Intent(ScrollingActivity.this, DetailActivity.class); // Behövs .this?
                    intent.putExtra("animal",text.getText()); // Lägg in extrafält i intentionen med djurets namn
                    text.setText("klick");
                    startActivity(intent);                    // Aktivera intentionen
                }
            });
            animalTextView.setText(animal.name);              // Lägg in djurets namn
            // Kan man lägga in djurets namn som id istället mha SetId()?
            scrollContent.addView(animalTextView);
        }

        ImageView bild=new ImageView(this);
        bild.setImageDrawable(getDrawable(R.drawable.iggy));
        scrollContent.addView(bild);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
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
}
