package ll.opensource.test;

import android.content.Context;

/**
 * Created by Percy on 10-31 0031.
 */

public class UserInfoBean {
    private static UserInfoBean userInfoBean;

    private Context mContext;

    private UserInfoBean(Context context) {
        this.mContext = context;
    }

    public static UserInfoBean getUserInfoBean(Context context) {
        if (userInfoBean == null) {
            synchronized (UserInfoBean.class) {
                if (userInfoBean == null) {
                    userInfoBean = new UserInfoBean(context);
                }
            }
        }
        return userInfoBean;
    }
}
