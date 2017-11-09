package ll.opensource.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;


import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import ll.opensource.Bean.ImageDataBean;
import ll.opensource.Bean.PreviewImageBean;
import ll.opensource.MultiGridAdapter;
import ll.opensource.R;
import ll.opensource.http.RequestService;
import ll.opensource.util.TypeIdToTypeNameUtil;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


public class ImageQueryActivity extends AppCompatActivity {
    private String BASE_URL = "http://192.168.1.75:8080/SpringMVC_Spring_mybatis/";
    private String TAG = "PengLog";
    @BindView(R.id.rv)
    RecyclerView mRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_query);
        ButterKnife.bind(this);
        mRv.setHasFixedSize(true);
        mRv.setLayoutManager(new GridLayoutManager(this,3));



        getRequest().getImageData()
        .observeOn(Schedulers.io()).map(new Func1<ImageDataBean, List<PreviewImageBean>>() {
            @Override
            public List<PreviewImageBean> call(ImageDataBean imageDataBean) {
                return getParams(imageDataBean);
            }
        })
        .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Subscriber<List<PreviewImageBean>>() {
            @Override
            public void onCompleted() {
                Log.d(TAG,"onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG,"onError " + e.toString());
            }

            @Override
            public void onNext(List<PreviewImageBean> previewImageBeans) {
                mRv.setAdapter(new MultiGridAdapter(previewImageBeans,ImageQueryActivity.this));
                Gson gson = new Gson();
                String json = gson.toJson(previewImageBeans);
                Log.d(TAG,json);
            }
        });
    }

    private RequestService getRequest() {
        Retrofit builder = new Retrofit.Builder().baseUrl(BASE_URL)
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create()).build();
        return builder.create(RequestService.class);
    }

    private List<PreviewImageBean> getParams(ImageDataBean imageDataBean) {
        Map<String, String> tempMap = new HashMap<>();
        List<ImageDataBean.DataBean> data = imageDataBean.getData();
        List<PreviewImageBean> list = new ArrayList<>();

        for (ImageDataBean.DataBean md : data) {
            if (tempMap.get(md.getFiletypeid()) == null) {
                PreviewImageBean previewImageBean = new PreviewImageBean();
                tempMap.put(md.getFiletypeid(), md.getFiletypeid());
                previewImageBean.setType("type_text");
                previewImageBean.setContent(TypeIdToTypeNameUtil.typeIdToNameMap.get(md.getFiletypeid()));
                list.add(previewImageBean);
                previewImageBean = new PreviewImageBean();
                previewImageBean.setType("type_image");
                previewImageBean.setContent(md.getPadocId());
                list.add(previewImageBean);
            } else {
                PreviewImageBean previewImageBean = new PreviewImageBean();
                previewImageBean.setType("type_image");
                previewImageBean.setContent(md.getPadocId());
                list.add(previewImageBean);
            }
        }
        return list;
    }
}
