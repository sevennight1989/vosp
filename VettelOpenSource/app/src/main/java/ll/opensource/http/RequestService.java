package ll.opensource.http;


import java.util.List;
import java.util.Map;

import ll.opensource.Bean.BaseBean;
import ll.opensource.Bean.ImageDataBean;
import ll.opensource.Bean.Person;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Percy on 11-2 0002.
 */

public interface RequestService {
    @FormUrlEncoded
    @POST("common/getInfo.do")
    Observable<BaseBean<List<Person>>> getInfo(@FieldMap Map<String,String> map);

    @POST("img/getImageData.do")
    Observable<ImageDataBean> getImageData();

}
