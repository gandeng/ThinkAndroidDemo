package activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ta.annotation.TAInjectView;
import com.thinkandroiddemo.ganjian.thinkandroiddemo.R;

/**
 * Created by ganjian on 2016/8/22.
 */
public class ThinkAndroidMainActivity extends ThinkAndroidBaseActivity {
    @TAInjectView(id = R.id.test_db)
    Button testdbButton;
    @TAInjectView(id = R.id.test_cache)
    Button testCacheButton;
    @TAInjectView(id = R.id.test_download)
    Button testDownloadButton;
    @TAInjectView(id = R.id.test_http)
    Button testHttpButton;
    @TAInjectView(id = R.id.test_image_cache)
    Button testImageCacheButton;
    @TAInjectView(id = R.id.test_mvc)
    Button testMVCButton;
    @TAInjectView(id = R.id.test_other)
    Button testOtherButton;
    @TAInjectView(id = R.id.test_exit)
    Button exitAPPButton;

    @Override
    protected void onAfterOnCreate(Bundle savedInstanceState) {
        super.onAfterOnCreate(savedInstanceState);
        setTitle(R.string.thinkandroid_main_title);
        //setContentView(R.layout.thinkandroidmain);
    }

    @Override
    protected void onAfterSetContentView() {
        super.onAfterSetContentView();
        View.OnClickListener onClickListene = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.test_db:
                        doActivity(R.string.thinkandroiddbactivtiy);
                        break;
                    case R.id.test_cache:
                        doActivity(R.string.thinkandroidcacheactivtiy);
                        break;
                    case R.id.test_image_cache:
                        doActivity(R.string.thinkandroidimagecacheactivtiy);
                        break;
                    case R.id.test_download:
                        doActivity(R.string.thinkandroiddwonloadactivtiy);
                        break;
                    case R.id.test_http:
                        doActivity(R.string.thinkandroidhttpactivtiy);
                        break;
                    case R.id.test_mvc:
                        doActivity(R.string.thinkandroidmvcactivtiy);
                        break;
                    case R.id.test_other:
                        doActivity(R.string.thinkandroidotheractivtiy);
                        break;
                    case R.id.test_exit:
                        ThinkAndroidMainActivity.this
                                .exitApp();
                }
            }
        };
        testdbButton.setOnClickListener(onClickListene);
        testCacheButton.setOnClickListener(onClickListene);
        testDownloadButton.setOnClickListener(onClickListene);
        testHttpButton.setOnClickListener(onClickListene);
        testImageCacheButton.setOnClickListener(onClickListene);
        testMVCButton.setOnClickListener(onClickListene);
        testOtherButton.setOnClickListener(onClickListene);
    }
}
