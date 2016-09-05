package activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ta.annotation.TAInjectView;
import com.ta.util.download.DownLoadCallback;
import com.ta.util.download.DownloadManager;
import com.thinkandroiddemo.ganjian.thinkandroiddemo.R;

/**
 * Created by ganjian on 2016/8/22.
 */
public class ThinkAndroidSimpleTwoDwonLoadActivtiy extends ThinkAndroidBaseActivity {
    @TAInjectView(id = R.id.start)
    Button startbuttn;
    @TAInjectView(id = R.id.stop)
    Button stopbutton;
    @TAInjectView(id = R.id.textview)
    TextView textView;
    @Override
    protected void onAfterOnCreate(Bundle savedInstanceState) {
        super.onAfterOnCreate(savedInstanceState);
        setTitle(R.string.thinkandroid_simple_two_download_title);
        setContentView(R.layout.simple_download);
    }

    @Override
    protected void onAfterSetContentView() {
        super.onAfterSetContentView();
        final DownloadManager downloadManager=DownloadManager.getDownloadManager();
        View.OnClickListener onClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId())
                {
                    case R.id.start:
                        startDownload();
                        break;
                    case R.id.stop:
                        stopDownload();
                        break;
                }
            }
            private void startDownload()
            {
                downloadManager.addHandler("http://img.yingyonghui.com/apk/16457/com.rovio.angrybirdsspace.ads.1332528395706.apk");
                downloadManager.setDownLoadCallback(new DownLoadCallback()
                {
                    @Override
                    public void onLoading(String url, long totalSize, long currentSize, long speed) {
                        super.onLoading(url, totalSize, currentSize, speed);
                        textView.setText(currentSize*100/totalSize+":"+speed+"kbs");

                    }

                    @Override
                    public void onSuccess(String url) {
                        super.onSuccess(url);
                        textView.setText("下载成功");
                    }

                    @Override
                    public void onFailure(String url, String strMsg) {
                        super.onFailure(url, strMsg);
                    }

                    @Override
                    public void onFinish(String url) {
                        super.onFinish(url);
                        textView.setText("下载失败");

                    }

                    @Override
                    public void onStop() {
                        super.onStop();
                    }

                    @Override
                    public void onStart() {
                        super.onStart();
                    }
                });
            }
            private void stopDownload(){
                downloadManager.pauseHandler("http://img.yingyonghui.com/apk/16457/com.rovio.angrybirdsspace.ads.1332528395706.apk");
            }
        };
startbuttn.setOnClickListener(onClickListener);
        stopbutton.setOnClickListener(onClickListener);
    }

    /**
     * Perform any final cleanup before an activity is destroyed.  This can
     * happen either because the activity is finishing (someone called
     * {@link #finish} on it, or because the system is temporarily destroying
     * this instance of the activity to save space.  You can distinguish
     * between these two scenarios with the {@link #isFinishing} method.
     * <p/>
     * <p><em>Note: do not count on this method being called as a place for
     * saving data! For example, if an activity is editing data in a content
     * provider, those edits should be committed in either {@link #onPause} or
     * {@link #onSaveInstanceState}, not here.</em> This method is usually implemented to
     * free resources like threads that are associated with an activity, so
     * that a destroyed activity does not leave such things around while the
     * rest of its application is still running.  There are situations where
     * the system will simply kill the activity's hosting process without
     * calling this method (or any others) in it, so it should not be used to
     * do things that are intended to remain around after the process goes
     * away.
     * <p/>
     * <p><em>Derived classes must call through to the super class's
     * implementation of this method.  If they do not, an exception will be
     * thrown.</em></p>
     *
     * @see #onPause
     * @see #onStop
     * @see #finish
     * @see #isFinishing
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
