package cn.edu.gdmec.android.myapplication.activity;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.RecyclerView;

import cn.edu.gdmec.android.myapplication.R;

public class CourseActivity extends Activity  {

    private RecyclerView rvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_course);

        rvList = (RecyclerView) findViewById(R.id.rv_list);
    }

}
