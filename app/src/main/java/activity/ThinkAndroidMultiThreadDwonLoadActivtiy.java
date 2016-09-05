package activity;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Button;
import android.widget.ListView;

import com.ta.annotation.TAInjectView;
import com.ta.util.download.DownloadManager;
import com.ta.util.download.IDownloadService;
import com.thinkandroiddemo.ganjian.thinkandroiddemo.R;

/**
 * Created by ganjian on 2016/8/22.
 */
public class ThinkAndroidMultiThreadDwonLoadActivtiy extends ThinkAndroidBaseActivity {
    @TAInjectView(id = R.id.listview)
    ListView listView;
    @TAInjectView(id = R.id.add)
    Button addbutton;
     private DownloadManager downloadManager;
    private IDownloadService iDownloadService;
    private
    ServiceConnection serviceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iDownloadService=(IDownloadService) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    @Override
    protected void onAfterOnCreate(Bundle savedInstanceState) {
        super.onAfterOnCreate(savedInstanceState);
        setTitle(R.string.thinkandroid_download_title);
        setContentView(R.layout.thinkandroidmultihreaddownload);
    }

    @Override
    protected void onAfterSetContentView() {
        super.onAfterSetContentView();

    }
}
