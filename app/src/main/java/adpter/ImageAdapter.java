package adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.ta.TAApplication;
import com.ta.util.bitmap.TABitmapCacheWork;
import com.ta.util.bitmap.TABitmapCallBackHanlder;
import com.ta.util.bitmap.TADownloadBitmapHandler;
import com.ta.util.extend.draw.DensityUtils;
import com.thinkandroiddemo.ganjian.thinkandroiddemo.R;

import data.ImagesUrls;


/**
 * Created by ganjian on 2016/8/25.
 */
public class ImageAdapter extends BaseAdapter {
    private final Context mContext;
    private int mNumColumns = 0;//列数
    private TABitmapCacheWork taBitmapCacheWork;


    public ImageAdapter(Context context, TAApplication application) {
        TADownloadBitmapHandler downloadBitmapHandler = new TADownloadBitmapHandler(context, DensityUtils.dipTopx(context, 128), DensityUtils.dipTopx(context, 128));
        TABitmapCallBackHanlder taBitmapCallBackHanlder = new TABitmapCallBackHanlder();
        taBitmapCallBackHanlder.setLoadingImage(context, R.drawable.empty_photo);//初始化一张图
        taBitmapCacheWork = new TABitmapCacheWork(context);
        taBitmapCacheWork.setProcessDataHandler(downloadBitmapHandler);//进度条
        taBitmapCacheWork.setCallBackHandler(taBitmapCallBackHanlder);//设置bitmap回调handler
        taBitmapCacheWork.setFileCache(application.getFileCache());//设置缓存路径
        mContext = context;
    }

    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of items.
     */
    @Override
    public int getCount() {
        return ImagesUrls.imagesUrls.length + mNumColumns;
    }

    /**
     * Get the data item associated with the specified position in the data set.
     *
     * @param position Position of the item whose data we want within the adapter's
     *                 data set.
     * @return The data at the specified position.
     */
    @Override
    public Object getItem(int position) {
        return position < mNumColumns ? null : ImagesUrls.imagesUrls[position - mNumColumns];
    }

    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
    @Override
    public long getItemId(int position) {
        return position < mNumColumns ? 0 : position - mNumColumns;
    }

    /**
     * Get a View that displays the data at the specified position in the data set. You can either
     * create a View manually or inflate it from an XML layout file. When the View is inflated, the
     * parent View (GridView, ListView...) will apply default layout parameters unless you use
     * {@link LayoutInflater#inflate(int, ViewGroup, boolean)}
     * to specify a root view and to prevent attachment to the root.
     *
     * @param position    The position of the item within the adapter's data set of the item whose view
     *                    we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view
     *                    is non-null and of an appropriate type before using. If it is not possible to convert
     *                    this view to display the correct data, this method can create a new view.
     *                    Heterogeneous lists can specify their number of view types, so that this View is
     *                    always of the right type (see {@link #getViewTypeCount()} and
     *                    {@link #getItemViewType(int)}).
     * @param parent      The parent that this view will eventually be attached to
     * @return A View corresponding to the data at the specified position.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      ImageView imageView;
        if (convertView == null) {
            imageView=new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(600, 600));
            imageView.setEnabled(true);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            imageView = (ImageView) convertView;
        }
        taBitmapCacheWork.loadFormCache(ImagesUrls.imagesUrls[position - mNumColumns], imageView);
        return imageView;
    }

    public void setmNumColumns(int numColumns) {
        mNumColumns = numColumns;
    }

    public int getmNumColumns() {
        return mNumColumns;
    }
}
