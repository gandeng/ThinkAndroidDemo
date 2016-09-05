package activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ta.annotation.TAInjectView;
import com.ta.util.cache.TAExternalOverFroyoUtils;
import com.ta.util.http.AsyncHttpClient;
import com.ta.util.http.FileHttpResponseHandler;
import com.thinkandroiddemo.ganjian.thinkandroiddemo.R;

/**
 * Created by ganjian on 2016/8/22.
 */
public class ThinkAndroidSimpleDwonLoadActivtiy extends ThinkAndroidBaseActivity {
    final static String DOWNLOAD_DIR="download";
    @TAInjectView(id = R.id.start)
    Button startbuton;
    @TAInjectView(id = R.id.stop)
    Button stopbutton;
    @TAInjectView(id = R.id.textview)
    TextView textView;
    @TAInjectView(id = R.id.prograssbar)
    ProgressBar progressBar;
    @Override
    protected void onAfterOnCreate(Bundle savedInstanceState) {
        super.onAfterOnCreate(savedInstanceState);
        setTitle(R.string.thinkandroid_simple_download_title);
        setContentView(R.layout.simple_download);
    }

    @Override
    protected void onAfterSetContentView() {
        super.onAfterSetContentView();
        final AsyncHttpClient asyncHttpClient=new AsyncHttpClient();
        final FileHttpResponseHandler fileHttpResponseHandler=new FileHttpResponseHandler(
                TAExternalOverFroyoUtils.getDiskCacheDir(ThinkAndroidSimpleDwonLoadActivtiy.this,DOWNLOAD_DIR).getAbsolutePath())
        {
            @Override
            public void onProgress(long totalSize, long currentSize, long speed) {
                super.onProgress(totalSize, currentSize, speed);
                long downloadPercent=currentSize*100/totalSize;
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setProgress(100*progressBar.getProgress());
                textView.setText(downloadPercent+":"+speed+"kbs");
            }

            @Override
            public void onFailure(Throwable error, byte[] binaryData) {
                super.onFailure(error, binaryData);
                textView.setText("x下载失败");
            }

            @Override
            public void onSuccess(byte[] binaryData) {
                super.onSuccess(binaryData);
                textView.setText("下载成功");
            }
        };
        View.OnClickListener onClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId())
                {
                    case  R.id.start:
                        startDownload();
                        break;
                    case R.id.stop:
                        stopDownload();
                }
            }
            private void startDownload()
            {
                fileHttpResponseHandler.setInterrupt(false);
                asyncHttpClient.download("http://static.qiyi.com/ext/common/iQIYI/QIYImedia_4_01.exe",fileHttpResponseHandler);
            }
            private void stopDownload(){
                fileHttpResponseHandler.setInterrupt(true);//设置暂停
            }
        };
        startbuton.setOnClickListener(onClickListener);
        stopbutton.setOnClickListener(onClickListener);
    }

}
