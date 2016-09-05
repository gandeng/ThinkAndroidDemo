package stringcache;

import com.ta.TASyncHttpClient;
import com.ta.util.cache.TAProcessDataHandler;

import java.io.UnsupportedEncodingException;

/**
 * Created by ganjian on 2016/8/23.
 */
public class TAProcessStringHandler extends TAProcessDataHandler {
    public TAProcessStringHandler() {
        super();
    }

    @Override
    public byte[] processData(Object data) {
        TASyncHttpClient client=new TASyncHttpClient();
        String resunt=client.get(data.toString());
        if(resunt==null||resunt.equalsIgnoreCase(""))
        {
            return null;
        }
        byte[] bytes=null;
        try {
            bytes=resunt.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return bytes;
    }



}
