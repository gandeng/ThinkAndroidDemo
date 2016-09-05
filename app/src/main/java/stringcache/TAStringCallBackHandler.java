package stringcache;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ta.common.TAStringUtils;
import com.ta.util.cache.TACallBackHandler;
import com.thinkandroiddemo.ganjian.thinkandroiddemo.R;

import java.io.UnsupportedEncodingException;

/**
 * Created by ganjian on 2016/8/23.
 */
public class TAStringCallBackHandler extends TACallBackHandler<TextView> {
    public TAStringCallBackHandler() {
        super();
    }

    @Override
    public void onStart(TextView textView, Object data) {
        super.onStart(textView, data);
    }

    @Override
    public void onSuccess(TextView textView, Object data, byte[] buffer) {
        super.onSuccess(textView, data, buffer);
        FrameLayout layout=(FrameLayout)textView.getParent();
        ProgressBar progressBar=(ProgressBar) layout.findViewById(R.id.progressbar);
        progressBar.setVisibility(View.GONE);
        String content=new String(buffer);
        try {
            content=new String(buffer,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        textView.setText(TAStringUtils.delHTMLTag(content));
    }

    @Override
    public void onFailure(TextView textView, Object data) {
        super.onFailure(textView, data);
    }
}
