package activity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import com.ta.TAApplication;
import com.ta.util.cache.TAFileCache;
import com.thinkandroiddemo.ganjian.thinkandroiddemo.R;

import command.TestMVCCommand;

/**
 * Created by ganjian on 2016/8/18.
 */
public class SplashActivity extends ThinkAndroidBaseActivity {
    private static final String SYSTEMCACHE = "thinkandroiddemo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = View.inflate(this, R.layout.splash, null);
        setContentView(view);
        AlphaAnimation animation = new AlphaAnimation(0.1f, 1.0f);
        animation.setDuration(3000);
        view.setAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                goTomain();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @Override
    protected void onPreOnCreate(Bundle savedInstanceState) {
        super.onPreOnCreate(savedInstanceState);
        TAApplication application = (TAApplication) getApplication();
        // 配置系统的缓存,可以选择性的配置
        TAFileCache.TACacheParams cacheParams = new TAFileCache.TACacheParams(this, SYSTEMCACHE);
        TAFileCache fileCache = new TAFileCache(cacheParams);
        application.setFileCache(fileCache);

        //注册好command的activitity
        getTAApplication().registerCommand(R.string.testmvccommand, TestMVCCommand.class);

        //注册第一个页面。首页
        getTAApplication().registerActivity(R.string.thinkandroidmainactivity, ThinkAndroidMainActivity.class);
        getTAApplication().registerActivity(R.string.thinkandroiddbactivtiy, ThinkAndroidDBActivtiy.class);
        getTAApplication().registerActivity(R.string.thinkandroidcacheactivtiy,ThinkAndroidCacheActivtiy.class);
        getTAApplication().registerActivity(R.string.thinkandroidimagecacheactivtiy,ThinkAndroidImageCacheActivtiy.class);
        getTAApplication().registerActivity(R.string.thinkandroiddwonloadactivtiy,ThinkAndroidDwonLoadActivtiy.class);//下载主页面
        getTAApplication().registerActivity(R.string.thinkandroidsimpledwonloadactivtiy,ThinkAndroidSimpleDwonLoadActivtiy.class);//单线程可断点下载
        getTAApplication().registerActivity(R.string.thinkandroidsimpletwodwonloadactivtiy,ThinkAndroidSimpleTwoDwonLoadActivtiy.class);

    }

    private void goTomain() {
        doActivity(R.string.thinkandroidmainactivity);
    }
}
