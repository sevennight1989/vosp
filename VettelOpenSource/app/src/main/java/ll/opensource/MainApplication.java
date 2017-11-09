package ll.opensource;


import android.app.Application;
import android.content.Context;

//import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Percy on 10-31 0031.
 */

public class MainApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            // This process is dedicated to LeakCanary for heap analysis.
//            // You should not init your app in this process.
//            return;
//        }
//        LeakCanary.install(this);
    }

    public static Context getInstance() {
        return mContext;
    }
}
