package ll.opensource.util.Download;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;

import java.io.File;

/**
 * Created by ZhangPeng on 9-21-0021.
 */

//下载完成之后自动安装apk
public class InstallReceiver extends BroadcastReceiver {
    private static final String TAG = "InstallReceiver";

    // 安装下载接收器
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(DownloadManager.ACTION_DOWNLOAD_COMPLETE)) {
            //安装之前可以通过记录sp的值来确定是否是本应用的下载，安装完成之后重置sp的值，以防监听DownloadManager被其他应用下载完成之后安装
            installApk(context);
        }
    }

    // 安装Apk
    private void installApk(Context context) {

        try {
            Intent i = new Intent(Intent.ACTION_VIEW);
            String filePath = Environment.getExternalStorageDirectory().getPath() + File.separator + Environment.DIRECTORY_DOWNLOADS
                    + File.separator + "test.apk";
            i.setDataAndType(Uri.parse("file://" + filePath), "application/vnd.android.package-archive");
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
