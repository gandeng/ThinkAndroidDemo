package adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.ta.util.download.DownLoadCallback;
import com.ta.util.download.DownloadManager;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ganjian on 2016/8/29.
 */
public class DownloadListAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<HashMap<Integer,String>> datalist;
    private DownloadManager downloadManager;
    private ListView downloadListview;
   public DownloadListAdapter(Context context, ListView listView)
   {
       mContext=context;
       listView=listView;
       datalist=new ArrayList<HashMap<Integer, String>>();
       downloadManager=DownloadManager.getDownloadManager();
       downloadManager.setDownLoadCallback(new DownLoadCallback()
       {
           @Override
           public void onSuccess(String url) {

               super.onSuccess(url);
               Toast("下载成功");
               removeItem(url);
           }

           @Override
           public void onLoading(String url, long totalSize, long currentSize, long speed) {
               super.onLoading(url, totalSize, currentSize, speed);
               long downloadPercent=currentSize*100/totalSize;
               View view=downloadListview.findViewWithTag(url);
               ViewHolder viewHolder=new ViewHolder(view);
           }

           @Override
           public void onStart() {
               super.onStart();
           }

           @Override
           public void onFailure(String url, String strMsg) {
               super.onFailure(url, strMsg);
           }

           @Override
           public void onFinish(String url) {
               super.onFinish(url);
           }

           @Override
           public void onStop() {
               super.onStop();
           }

           @Override
           public void onAdd(String url, Boolean isInterrupt) {
               super.onAdd(url, isInterrupt);
               addItem(url,isInterrupt);
           }
       });
   }
    private void addItem(String _url,boolean isPaused)
    {
        HashMap<Integer,String> item=new HashMap<Integer, String>();
        item.put(ViewHolder.KEY_URL,_url);
        datalist.add(item);
        this.notifyDataSetChanged();
    }
    private void removeItem(String _url)
    {
        String temp;
        for(int i=0;i<datalist.size();i++)
        {
            temp=datalist.get(i).get(ViewHolder.KEY_URL);
            if(temp.equals(_url))
            {
                datalist.remove(i);
                this.notifyDataSetChanged();
            }
        }
    }
    private void Toast(String _msg)
    {
        Toast.makeText(mContext,_msg,Toast.LENGTH_LONG).show();
    }
    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of items.
     */
    @Override
    public int getCount() {
        return 0;
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
        return null;
    }

    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
    @Override
    public long getItemId(int position) {
        return 0;
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
        return null;
    }
}
