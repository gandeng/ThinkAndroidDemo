package activity;

import android.os.Bundle;
import android.widget.GridView;

import com.ta.TAApplication;
import com.ta.annotation.TAInjectView;
import com.thinkandroiddemo.ganjian.thinkandroiddemo.R;

import adpter.ImageAdapter;

/**
 * Created by ganjian on 2016/8/22.
 */
public class ThinkAndroidImageCacheActivtiy extends ThinkAndroidBaseActivity {
    @TAInjectView(id = R.id.gridview)
    GridView gridView;
    @Override
    protected void onAfterOnCreate(Bundle savedInstanceState) {
        super.onAfterOnCreate(savedInstanceState);
        setTitle(R.string.thinkandroid_image_cache_title);
        ImageAdapter adapter=new ImageAdapter(this, TAApplication.getApplication());
        gridView.setAdapter(adapter);
    }
}
