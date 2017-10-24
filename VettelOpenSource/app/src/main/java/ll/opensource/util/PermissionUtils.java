package ll.opensource.util;

/**
 * Created by Percy on 10-15 0015.
 */

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.PermissionChecker;

/**
 * 权限工具类
 */
public class PermissionUtils {

    //适用于targetSdkVersion < 23
    public static boolean isPermissionGranted(Context context, String permission) {
        return PermissionChecker.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED;
    }

    //适用于targetSdkVersion >=23
    public static boolean isPermissionGranted23Up(Context context, String permission) {
        return ActivityCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED;
    }
}
