package ll.vettelopensource;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import ll.vettelopensource.view.TextLimitEditText;

public class MainActivity extends AppCompatActivity {
    TextLimitEditText mTLet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mTLet = (TextLimitEditText) findViewById(R.id.tvLimit);
        mTLet.setLimitCount(12);
        mTLet.setILimit(new TextLimitEditText.ILimit() {
            @Override
            public void onTextLimitNotify(final int count) {
                        Snackbar.make(mTLet, "不能超过"+count+"个字符", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
        });

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
}
