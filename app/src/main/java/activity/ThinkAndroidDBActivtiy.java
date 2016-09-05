package activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ta.annotation.TAInjectView;
import com.ta.util.db.TASQLiteDatabase;
import com.thinkandroiddemo.ganjian.thinkandroiddemo.R;

import java.util.Date;
import java.util.List;

import entity.TestDataEntity;

/**
 * Created by ganjian on 2016/8/22.
 */
public class ThinkAndroidDBActivtiy extends ThinkAndroidBaseActivity {
    @TAInjectView(id = R.id.insert_data)
    Button insertdataButton;
    @TAInjectView(id = R.id.select_data)
    Button selectdataButton;
    @TAInjectView(id = R.id.update_data)
    Button updatedataButton;
    @TAInjectView(id = R.id.delete_data)
    Button deletedataButton;
    @TAInjectView(id = R.id.show_data)
    TextView showdataTextView;
    @TAInjectView(id=R.id.delete_all)
    Button deleteallButton;

    private TASQLiteDatabase tasqLiteDatabase;
    @Override
    protected void onAfterOnCreate(Bundle savedInstanceState) {
        super.onAfterOnCreate(savedInstanceState);
        setTitle(R.string.thinkandroid_db_title);
        setContentView(R.layout.thinkandroiddb);
        createdataBase();
    }
    private void createdataBase()
    {
        tasqLiteDatabase=getTAApplication().getSQLiteDatabasePool().getSQLiteDatabase();
        if(tasqLiteDatabase!=null)
        {
            if(tasqLiteDatabase.hasTable(TestDataEntity.class))
            {
                tasqLiteDatabase.dropTable(TestDataEntity.class);
            }
            tasqLiteDatabase.creatTable(TestDataEntity.class);
        }
    }
    private void insertData()
    {
        TestDataEntity testDataEntity=new TestDataEntity();
        testDataEntity.setName("Think Android ADD");
        testDataEntity.setB(true);
        Character c1=new Character('c');
        testDataEntity.setC(c1);
        testDataEntity.setD(10);
        testDataEntity.setDate(new Date());
        testDataEntity.setF(2f);
        testDataEntity.setI(123);
        tasqLiteDatabase.insert(testDataEntity);
        showData();
    }
    private void showData()
    {
        String showString="";
        List<TestDataEntity>list=tasqLiteDatabase.query(TestDataEntity.class,false,null,null,null,null,null);
        for(int i=0;i<list.size();i++)
        {
            TestDataEntity testDataEntity=list.get(i);
            showString+=showString+testDataEntity.toString()+"~~";
        }
        showdataTextView.setText(showString);
    }

    private void updateData()
    {
        TestDataEntity testDataEntity=new TestDataEntity();
        testDataEntity.setName("Think Android update");
        testDataEntity.setB(true);
        Character c1=new Character('c');
        testDataEntity.setC(c1);
        testDataEntity.setD(10);
        testDataEntity.setDate(new Date());
        testDataEntity.setF(2f);
        testDataEntity.setI(123);
        tasqLiteDatabase.update(testDataEntity,"username='Think Android ADD'");
        showData();
    }

    private void deleteData()
    {
        tasqLiteDatabase.delete(TestDataEntity.class,"i=123");
        showData();
    }

    private void deleteALL()
    {
        tasqLiteDatabase.delete(TestDataEntity.class,"username='Think Android ADD'");
    }

    @Override
    protected void onAfterSetContentView() {
        super.onAfterSetContentView();
        View.OnClickListener onClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId())
                {
                    case R.id.insert_data:
                        insertData();
                        break;
                    case R.id.update_data:
                        updateData();
                        break;
                    case R.id.select_data:
                        showData();
                        break;
                    case R.id.delete_data:
                        deleteData();
                        break;
                    case R.id.delete_all:
                        deleteALL();
                        break;
                }
            }
        };
        insertdataButton.setOnClickListener(onClickListener);
        updatedataButton.setOnClickListener(onClickListener);
        deletedataButton.setOnClickListener(onClickListener);
        selectdataButton.setOnClickListener(onClickListener);
        deleteallButton.setOnClickListener(onClickListener);

    }
}
