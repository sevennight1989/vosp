package ll.opensource.util;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import com.zxy.tiny.Tiny;
import com.zxy.tiny.callback.FileCallback;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by Percy on 11-8 0008.
 * 图片压缩工具类
 */

public class ImageUtils {

    private String TAG = "PengLog";
    //查询图片
    private void queryImage(Context context,Uri mUri) {
        Cursor mCursor = context.getContentResolver().query(mUri, null,
        null, null, MediaStore.Images.Media.DATE_MODIFIED);
        if (mCursor == null) {
            Log.d(TAG, "图片不存在");
            return;
        }
        while (mCursor.moveToNext()) {
            //获取图片的路径
            String path = mCursor.getString(mCursor
            .getColumnIndex(MediaStore.Images.Media.DATA));
            Log.d(TAG,"--> "+path);
        }
    }

    //删除图片
    private void deleteImage(Context context,Uri mUri){
        try {
            context.getContentResolver().delete(mUri,null,null);
            Log.d(TAG,"Delete img success");
        }catch (Exception e){
            Log.d(TAG,e.getMessage());
        }

    }

    private Uri uti = Uri.parse("content://media/external/images/media/31110");

    //通过生成缩略图的方式压缩图片
    private void zoomImage2(Context context,String sourceImgPath) {
        File file = new File(sourceImgPath);
        if (!file.exists()) {
            Log.d(TAG, "图片不存在");
        }
        try {
            Log.d(TAG,file.getAbsolutePath()+"   " + file.getName());
            String imgUri = MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getAbsolutePath(), "20171102_190344.jpg", null);
            Log.d(TAG, "imgUri : " + imgUri);
            Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            intent.setData(Uri.parse(imgUri));
            context.sendBroadcast(intent);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //调用三方框架压缩图片
    private void zoomImage(final Context context, String sourceImgPath) {
        Tiny.FileCompressOptions options = new Tiny.FileCompressOptions();
        options.outfile = "/sdcard/carLoan/aaa.jpg";
        options.quality = 90;
        File file = new File(sourceImgPath);
        if (!file.exists()) {
            Log.d(TAG, "图片不存在");
        }
        Tiny.getInstance().source(sourceImgPath).asFile().withOptions(options).compress(new FileCallback() {
            @Override
            public void callback(boolean isSuccess, String outfile, Throwable t) {
                if (isSuccess) {
                    Log.d(TAG, "outfile " + outfile);
                    Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                    intent.setData(Uri.fromFile(new File(outfile)));
                    context.sendBroadcast(intent);
                } else {
                    Log.d(TAG, t.getMessage());
                }

            }
        });
    }
}
