package ll.opensource;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerViewAccessibilityDelegate;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import ll.opensource.Bean.PreviewImageBean;

/**
 * Created by Percy on 11-9 0009.
 */

public class MultiGridAdapter extends RecyclerView.Adapter {
    private String imgUri = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1510200242711&di=0968ca3c8e24ea54efccc82270443b08&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01027957a93b4a0000018c1b628e6f.jpg%401280w_1l_2o_100sh.jpg";
    private String imgUri2 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1510229419753&di=d7271d8f3084a6af4fb1bbf7f9b1e290&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fd788d43f8794a4c2d72fce7105f41bd5ad6e395f.jpg";
    private String imgUri3 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1510229576940&di=f5d2821249f94e948c3803ce89e0a222&imgtype=0&src=http%3A%2F%2Fd.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fd439b6003af33a871a1f6a5dcd5c10385343b503.jpg";
    private String TAG = "PengLog";
    private List<PreviewImageBean> list;
    private Context mContext;
    private static final int TYPE_ITME_1 = 1;
    private static final int TYPE_ITME_2 = 2;
    public static final String TYPE_IMAGE = "type_image";
    public static final String TYPE_TEXT = "type_text";
    public LayoutInflater inflater;

    public MultiGridAdapter(List<PreviewImageBean> list, Context context) {
        this.list = list;
        mContext = context;
        inflater = LayoutInflater.from(mContext);
//        for(PreviewImageBean previewImageBean :list){
//            Log.d(TAG,previewImageBean.getType());
//        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITME_1) {
            return new ImageViewHolder(inflater.inflate(R.layout.item_img, parent, false));
        } else {
            return new TextViewHolder(inflater.inflate(R.layout.item_text, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ImageViewHolder) {
            ImageViewHolder imageViewHolder = (ImageViewHolder) holder;
            Glide.with(mContext).load(imgUri2).apply(new RequestOptions().placeholder(R.mipmap.ic_launcher_round).error(R.mipmap.ic_launcher)).into(imageViewHolder.imageView);
        } else if (holder instanceof TextViewHolder) {
            TextViewHolder textViewHolder = (TextViewHolder) holder;
            textViewHolder.textView.setText(list.get(position).getContent());
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) manager;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    int type = getItemViewType(position);
                    switch (type) {
                        case TYPE_ITME_1:
                            return 1;
                        case TYPE_ITME_2:
                            return 3;
                    }
                    return 3;
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        String type = list.get(position).getType();
        switch (type) {
            case TYPE_IMAGE:
                return TYPE_ITME_1;
            case TYPE_TEXT:
                return TYPE_ITME_2;
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ImageViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image_type);
        }
    }

    public class TextViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public TextViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text_type);
        }
    }

}
