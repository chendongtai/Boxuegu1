package cn.edu.gdmec.android.myapplication.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.gdmec.android.myapplication.adapter.PlayHistoryListItemAdapter;
import cn.edu.gdmec.android.myapplication.R;
import cn.edu.gdmec.android.myapplication.bean.VideoBean;
import cn.edu.gdmec.android.myapplication.utils.AnalysisUtils;
import cn.edu.gdmec.android.myapplication.utils.DBUtils;

public class PlayHistoryActivity extends Activity  {

    private ListView lvList;
    private TextView tv_none,tv_main_title,tv_save,tv_back;
    private RelativeLayout rl_title_bar;
    private List<VideoBean> vbl;
    private DBUtils db;
    private PlayHistoryListItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_history);

        db = DBUtils.getInstance(this);
        vbl = new ArrayList<VideoBean>();
        vbl = db.getVideoHistory(AnalysisUtils.readLoginUserName(this));
        initView();

    }
    private void initView(){
        tv_back = findViewById(R.id.tv_back);
        tv_main_title = findViewById(R.id.tv_main_title);
        tv_main_title.setText("播放记录");
        tv_save = findViewById(R.id.tv_save);
        rl_title_bar = findViewById(R.id.rl_title_bar);
        lvList = (ListView) findViewById(R.id.lv_list);
        tv_none = (TextView) findViewById(R.id.tv_none);
        rl_title_bar.setBackgroundColor(Color.parseColor("#30B4FF"));

        if (vbl.size() == 0){
            tv_none.setVisibility(View.VISIBLE);
        }
        adapter = new PlayHistoryListItemAdapter(this);
        adapter.setData(vbl);
        Log.i("vbl",vbl.size()+"");
        lvList.setAdapter(adapter);
        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlayHistoryActivity.this.finish();
            }
        });
    }

}
