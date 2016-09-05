package activity;

import android.os.Bundle;

import com.ta.TAActivity;
import com.ta.util.netstate.TANetWorkUtil;

/**
 * Created by ganjian on 2016/8/18.
 */
public class ThinkAndroidBaseActivity extends TAActivity {
    @Override
    protected void onPreOnCreate(Bundle savedInstanceState) {
        super.onPreOnCreate(savedInstanceState);
    }

    @Override
    public void onConnect(TANetWorkUtil.netType type) {
        super.onConnect(type);
    }

    @Override
    public void onDisConnect() {
        super.onDisConnect();
    }
}
