package ll.opensource;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import ll.opensource.util.Download.DownloadManagerUtil;
import ll.opensource.view.TextLimitEditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextLimitEditText mTLet;
    private Button mDownloadBT;
    private String downladUrl = "http://imtt.dd.qq.com/16891/A92A3D6A0D992208886066A332A67EC8.apk?" +
            "fsname=com.kingsoft_9.0_164.apk&csr=2097&_track_d99957f7=4cfcb27c-aab2-4c6a-9c3b-2806e0badeb5";
    private DownloadManagerUtil dMUtil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dMUtil = new DownloadManagerUtil(this, downladUrl);
        mTLet = (TextLimitEditText) findViewById(R.id.tvLimit);
        mTLet.setLimitCount(12);
        mTLet.setILimit(new TextLimitEditText.ILimit() {
            @Override
            public void onTextLimitNotify(final int count) {
                Snackbar.make(mTLet, "不能超过" + count + "个字符", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        mDownloadBT = (Button) findViewById(R.id.startDownload);
        mDownloadBT.setOnClickListener(this);

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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.startDownload:
//                dMUtil.startDownload();
                break;
        }
    }


}
