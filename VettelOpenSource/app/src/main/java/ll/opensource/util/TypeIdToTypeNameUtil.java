package ll.opensource.util;

import java.util.HashMap;

import ll.opensource.MainApplication;
import ll.opensource.R;

/**
 * Created by EX_WLJR_ZHANGPENG on 2017/11/9.
 */
public class TypeIdToTypeNameUtil {
  public static final HashMap<String, String> typeIdToNameMap = new HashMap<>();

  static {
    if (MainApplication.getInstance() != null) {
      String[] typeIdArr = MainApplication.getInstance().getResources().getStringArray(R.array.file_type_id);
      String[] typeNameArr = MainApplication.getInstance().getResources().getStringArray(R.array.file_type_name);
      for (int i = 0; i < typeIdArr.length; i++) {
        typeIdToNameMap.put(typeIdArr[i], typeNameArr[i]);
      }
    }
  }
}