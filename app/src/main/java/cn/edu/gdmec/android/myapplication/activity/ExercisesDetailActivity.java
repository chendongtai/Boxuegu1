package cn.edu.gdmec.android.myapplication.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import cn.edu.gdmec.android.myapplication.adapter.ExercisesDetailListItemAdapter;
import cn.edu.gdmec.android.myapplication.R;
import cn.edu.gdmec.android.myapplication.bean.ExercisesBean;
import cn.edu.gdmec.android.myapplication.utils.AnalysisUtils;

public class ExercisesDetailActivity extends Activity  {

    private TextView tv_back,tv_main_title;
    private RecyclerView rv_list;
    private TextView tvDibu;
    private int id;
    private String title;
    private List<ExercisesBean> ebl;
    private ExercisesDetailListItemAdapter adapter;
    private RelativeLayout rl_title_bar;

    //  当前答题数
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exerecises_detail);
        id = getIntent().getIntExtra("id",0);
        title = getIntent().getStringExtra("title");
        ebl = new ArrayList<ExercisesBean>();
        initData();
        initView();

    }
    private void initData(){
        try {
            InputStream is = getResources().getAssets().open("chapter" + id + ".xml");
            ebl = AnalysisUtils.getExercisesInfos(is);
            Log.i("ebl",ebl.size()+"");

        }catch (IOException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void initView(){
        tv_back = findViewById(R.id.tv_back);
        tv_main_title = findViewById(R.id.tv_main_title);
        rl_title_bar = findViewById(R.id.rl_title_bar);
        rl_title_bar.setBackgroundColor(Color.parseColor("#30B4FF"));
        tv_main_title.setText(title);
        tvDibu = (TextView) findViewById(R.id.tv_dibu);
        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExercisesDetailActivity.this.finish();
            }
        });

        adapter = new ExercisesDetailListItemAdapter(ExercisesDetailActivity.this, new ExercisesDetailListItemAdapter.OnSelectListener() {
            @Override
            public void onSelectA(int position, ImageView iv_a, ImageView iv_b, ImageView iv_c, ImageView iv_d) {
                if (ebl.get(position).answer != 1){
                    ebl.get(position).select = 1;
                }else{
                    ebl.get(position).select = 0;
                }
                switch (ebl.get(position).answer){
                    case 1:
                        iv_a.setImageResource(R.drawable.exercises_right_icon);
                        break;

                    case 2:
                        iv_b.setImageResource(R.drawable.exercises_right_icon);
                        iv_a.setImageResource(R.drawable.exercises_error_icon);
                        break;
                    case 3:
                        iv_c.setImageResource(R.drawable.exercises_right_icon);
                        iv_a.setImageResource(R.drawable.exercises_error_icon);
                        break;
                    case 4:
                        iv_a.setImageResource(R.drawable.exercises_right_icon);
                        iv_d.setImageResource(R.drawable.exercises_error_icon);
                        break;
                }
                AnalysisUtils.setABCDEnable(false,iv_a,iv_b,iv_c,iv_d);

//              /*  count++;
//                showCount(position,ebl.size());*/

            }

            @Override
            public void onSelectB(int position, ImageView iv_a, ImageView iv_b, ImageView iv_c, ImageView iv_d) {
                if (ebl.get(position).answer != 2){
                    ebl.get(position).select = 2;
                }else{
                    ebl.get(position).select = 0;
                }
                switch (ebl.get(position).answer){
                    case 1:
                        iv_a.setImageResource(R.drawable.exercises_right_icon);
                        iv_b.setImageResource(R.drawable.exercises_error_icon);
                        break;
                    case 2:
                        iv_b.setImageResource(R.drawable.exercises_right_icon);
                        break;
                    case 3:
                        iv_c.setImageResource(R.drawable.exercises_right_icon);
                        iv_b.setImageResource(R.drawable.exercises_error_icon);
                        break;
                    case 4:
                        iv_b.setImageResource(R.drawable.exercises_error_icon);
                        iv_d.setImageResource(R.drawable.exercises_right_icon);
                        break;
                }
                AnalysisUtils.setABCDEnable(false,iv_a,iv_b,iv_c,iv_d);

            /*    count++;
                showCount(position,ebl.size());*/

            }

            @Override
            public void onSelectC(int position, ImageView iv_a, ImageView iv_b, ImageView iv_c, ImageView iv_d) {
                if (ebl.get(position).answer != 3){
                    ebl.get(position).select = 3;
                }else{
                    ebl.get(position).select = 0;
                }
                switch (ebl.get(position).answer){
                    case 1:
                        iv_a.setImageResource(R.drawable.exercises_right_icon);
                        iv_c.setImageResource(R.drawable.exercises_error_icon);
                        break;
                    case 2:
                        iv_b.setImageResource(R.drawable.exercises_right_icon);
                        iv_c.setImageResource(R.drawable.exercises_error_icon);
                        break;
                    case 3:
                        iv_c.setImageResource(R.drawable.exercises_right_icon);
                        break;
                    case 4:
                        iv_c.setImageResource(R.drawable.exercises_error_icon);
                        iv_d.setImageResource(R.drawable.exercises_right_icon);
                        break;
                }
                AnalysisUtils.setABCDEnable(false,iv_a,iv_b,iv_c,iv_d);

             /*   count++;
                showCount(position,ebl.size());*/

            }

            @Override
            public void onSelectD(int position, ImageView iv_a, ImageView iv_b, ImageView iv_c, ImageView iv_d) {
                if (ebl.get(position).answer != 4){
                    ebl.get(position).select = 4;
                }else{
                    ebl.get(position).select = 0;
                }
                switch (ebl.get(position).answer){
                    case 1:
                        iv_a.setImageResource(R.drawable.exercises_right_icon);
                        iv_d.setImageResource(R.drawable.exercises_error_icon);
                        break;
                    case 2:
                        iv_b.setImageResource(R.drawable.exercises_right_icon);
                        iv_d.setImageResource(R.drawable.exercises_error_icon);
                        break;
                    case 3:
                        iv_c.setImageResource(R.drawable.exercises_right_icon);
                        iv_d.setImageResource(R.drawable.exercises_error_icon);
                        break;
                    case 4:
                        iv_d.setImageResource(R.drawable.exercises_right_icon);
                        break;
                }
                AnalysisUtils.setABCDEnable(false,iv_a,iv_b,iv_c,iv_d);

             /*   count++;
                showCount(position,ebl.size());*/

            }
        });
        adapter.setData(ebl);
        rv_list = findViewById(R.id.rv_list);
        rv_list.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rv_list.setHorizontalScrollBarEnabled(true);


        rv_list.addItemDecoration(new DividerItemDecoration(this, 1));

        rv_list.setSaveFromParentEnabled(true);

        adapter.setItemListener(new ExercisesDetailListItemAdapter.ItemListener() {

            @Override

            public void onItemClick(View view, int position) {

                count++;

                tvDibu.setText("第"+(position+1)+"题完成，共"+adapter.getItemCount()+"题");

                Log.i("exercises",count+"");

                Log.i("id",id+"");

                if (count==5){

                    AnalysisUtils.saveExercisesStatus(ExercisesDetailActivity.this,id);

                    setResult(RESULT_OK);

                }

            }

        });

        rv_list.setAdapter(adapter);

    }

    /*private void showCount(int count, int size) {
        ++count;
        if (size != 0) {
            tvDibu.setText("第"+count+"题完成,共"+size+"题");
        }

    }
*/
    /*@Override
    protected void onDestroy() {
        super.onDestroy();
        if (count == ebl.size()) {
            SharedPreferences sp = getSharedPreferences("content.sp", MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean(title, true);
            editor.apply();
            setResult(10086,null);
            finish();

        }

    }*/
}
