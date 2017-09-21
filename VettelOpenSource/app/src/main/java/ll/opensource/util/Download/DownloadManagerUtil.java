package ll.opensource.util.Download;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;

/**
 * Created by ZhangPeng on 9-21-0021.
 */

//使用DownloadManger下载文件，配合InstallReceiver下载apk后可以自动安装
public class DownloadManagerUtil {
    private String mPath;
    private Context mContext;

    public DownloadManagerUtil(Context context, String path) {
        mContext = context;
        mPath = path;
    }

    //使用DownloadManger下载文件
    public void startDownload() {
        Uri mUri = Uri.parse(mPath);
        // create request
        DownloadManager.Request r = new DownloadManager.Request(mUri);
        // set request property
        String apkName = "test.apk";
        // set 下载路径
        r.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, apkName);
        // set Notification
        r.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        // create manager
        DownloadManager dm = (DownloadManager)mContext.getSystemService(Context.DOWNLOAD_SERVICE);
        // key code, set mine type
        r.setMimeType("application/vnd.android.package-archive");
        // add to queue
        dm.enqueue(r);
    }
}
