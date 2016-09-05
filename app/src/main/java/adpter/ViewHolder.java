package adpter;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ta.common.TAStringUtils;
import com.thinkandroiddemo.ganjian.thinkandroiddemo.R;

import java.util.HashMap;

/**
 * Created by ganjian on 2016/8/29.
 */
public class ViewHolder {
    public static final int KEY_URL = 0;
    public static final int KEY_SPEED = 1;
    public static final int KEY_PROGRESS = 2;
    public static final int KEY_IS_PAUSE = 3;

    private TextView title;
    private ProgressBar progressBar;
    private Button startButton;
    private Button pauseButton;
    private Button deleteButton;
    private TextView speedText;
    private boolean isInited = false;

    public ViewHolder(View parentView) {
        if (parentView != null) {
            title = (TextView) parentView.findViewById(R.id.title_text);
            speedText = (TextView) parentView.findViewById(R.id.speed_text);
            progressBar = (ProgressBar) parentView.findViewById(R.id.progress_bar);
            startButton = (Button) parentView.findViewById(R.id.start);
            pauseButton = (Button) parentView.findViewById(R.id.pause);
            deleteButton = (Button) parentView.findViewById(R.id.delete);
            isInited = true;
        }
    }

    public static HashMap<Integer, String> getItemMap(String url, String speed, String progress, String isPaused) {
        HashMap<Integer, String> item = new HashMap<Integer, String>();
        item.put(KEY_URL, url);
        item.put(KEY_SPEED, speed);
        item.put(KEY_PROGRESS, progress);
        item.put(KEY_IS_PAUSE, isPaused);
        return item;
    }

    public void setData(HashMap<Integer, String> item) {
        if (isInited) {
            title.setText(TAStringUtils.getFileNameFromUrl(item.get(KEY_URL)));
            speedText.setText(item.get(KEY_SPEED));
            String progress = item.get(KEY_PROGRESS);
            if (TextUtils.isEmpty(progress)) {
                progressBar.setProgress(0);
            } else {
                progressBar.setProgress(Integer.parseInt(progress));
            }
            if (Boolean.getBoolean(item.get(KEY_IS_PAUSE))) {
                onPause();
            }
        }
    }

    public void onPause() {
        if (isInited) {
            pauseButton.setVisibility(View.GONE);
            startButton.setVisibility(View.VISIBLE);
        }
    }

    public void setData(String url, String speed, String progress) {
        setData(url, speed, progress, false + "");
    }

    public void setData(String url, String speed, String progress, String isPaused) {
        if (isInited) {
            HashMap<Integer, String> item = getItemMap(url, speed, progress, isPaused);
            title.setText(TAStringUtils.getFileNameFromUrl(item.get(KEY_URL)));
            speedText.setText(item.get(KEY_SPEED));
            if(TextUtils.isEmpty(item.get(KEY_PROGRESS)))
            {
                progressBar.setProgress(0);
            }else {
                progressBar.setProgress(Integer.parseInt(item.get(KEY_PROGRESS)));
            }

        }
    }

}
