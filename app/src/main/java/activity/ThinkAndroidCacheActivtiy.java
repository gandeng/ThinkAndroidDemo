package activity;

import android.os.Bundle;
import android.widget.ListView;

import com.ta.annotation.TAInjectView;
import com.thinkandroiddemo.ganjian.thinkandroiddemo.R;

import adpter.StringAdapter;

/**
 * Created by ganjian on 2016/8/22.
 */
public class ThinkAndroidCacheActivtiy extends ThinkAndroidBaseActivity {
    @TAInjectView(id = R.id.listview)
    ListView listView;
    @Override
    protected void onAfterOnCreate(Bundle savedInstanceState) {
        super.onAfterOnCreate(savedInstanceState);
    }

    @Override
    protected void onAfterSetContentView() {
        StringAdapter adapter=new StringAdapter(this,getTAApplication());
        listView.setAdapter(adapter);
        super.onAfterSetContentView();
    }
}
