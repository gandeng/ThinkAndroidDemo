package activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ta.annotation.TAInjectView;
import com.thinkandroiddemo.ganjian.thinkandroiddemo.R;

/**
 * Created by ganjian on 2016/8/22.
 */
public class ThinkAndroidDwonLoadActivtiy extends ThinkAndroidBaseActivity {
    @TAInjectView(id = R.id.test_simple_download)
    Button testdownload;
    @TAInjectView(id = R.id.test_simple_download2)
    Button testdownload2;
    @TAInjectView(id = R.id.test_multi_download)
    Button testmuldownload;
    @Override
    protected void onAfterOnCreate(Bundle savedInstanceState) {
        super.onAfterOnCreate(savedInstanceState);
        setTitle(R.string.thinkandroid_download_title);
        setContentView(R.layout.thinkandoriddownload);
    }

    @Override
    protected void onAfterSetContentView() {
        super.onAfterSetContentView();
        View.OnClickListener onClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch ((v.getId()))
                {
                    case  R.id.test_simple_download:
                        doActivity(R.string.thinkandroidsimpledwonloadactivtiy);
                        break;
                    case R.id.test_simple_download2:
                        doActivity(R.string.thinkandroidsimpletwodwonloadactivtiy);
                        break;
                    case R.id.test_multi_download:
                        doActivity(R.string.thinkandroidmultithreaddwonloadactivtiy);
                        break;
                }
            }
        };
        testdownload.setOnClickListener(onClickListener);
        testdownload2.setOnClickListener(onClickListener);
        testmuldownload.setOnClickListener(onClickListener);
    }
}
