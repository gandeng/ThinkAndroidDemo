package command;

import android.util.Log;

import com.ta.mvc.command.TACommand;
import com.ta.mvc.common.TARequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import entity.StudyEntity;

/**
 * Created by ganjian on 2016/8/22.
 */
public class TestMVCCommand extends TACommand {
    @Override
    protected void executeCommand() {
        TARequest request=getRequest();
        String strJson=(String)request.getData();
        ArrayList<StudyEntity> arrayList=new ArrayList<StudyEntity>();

        try {
            JSONObject jsonObject=new JSONObject(strJson);
            JSONArray jsonArray=(JSONArray)jsonObject.get("students");
            for(int i=0;i<jsonArray.length();i++)
            {
                JSONObject o=(JSONObject) jsonArray.get(i);
StudyEntity studyEntity=new StudyEntity();
                studyEntity.setAge(o.getInt("age"));
                studyEntity.setName(o.getString("name"));
                arrayList.add(studyEntity);
                Log.d("get json",studyEntity.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }finally {
            sendSuccessMessage(arrayList);
        }
    }
}
