package adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ta.TAApplication;
import com.ta.util.cache.TAFileCacheWork;
import com.thinkandroiddemo.ganjian.thinkandroiddemo.R;

import data.StringUrls;
import stringcache.TAProcessStringHandler;
import stringcache.TAStringCallBackHandler;

/**
 * Created by ganjian on 2016/8/23.
 */
public class StringAdapter extends BaseAdapter {

    private TAFileCacheWork<TextView> taFileCacheWork;
    private Context mContext;
    public StringAdapter(Context context, TAApplication application)
    {
        taFileCacheWork=new TAFileCacheWork<TextView>();
        taFileCacheWork.setCallBackHandler(new TAStringCallBackHandler());
        taFileCacheWork.setProcessDataHandler(new TAProcessStringHandler());
        taFileCacheWork.setFileCache(application.getFileCache());
        this.mContext=context;
    }
    @Override
    public int getCount() {
        return StringUrls.STRINGS.length;
    }

    @Override
    public Object getItem(int position) {
        return StringUrls.STRINGS[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.string_cache_item,null);
        final TextView textView=(TextView) view.findViewById(R.id.textview);
        taFileCacheWork.loadFormCache(getItem(position),textView);
        return view;
    }
}
