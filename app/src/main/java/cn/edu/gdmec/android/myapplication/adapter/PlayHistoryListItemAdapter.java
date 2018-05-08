package cn.edu.gdmec.android.myapplication.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import cn.edu.gdmec.android.myapplication.R;
import cn.edu.gdmec.android.myapplication.bean.VideoBean;

public class PlayHistoryListItemAdapter extends BaseAdapter {

    private List<VideoBean> objects = new ArrayList<VideoBean>();

    private Context context;
    private LayoutInflater layoutInflater;

    public PlayHistoryListItemAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void setData(List<VideoBean>vbl){
        this.objects = vbl;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public VideoBean getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.play_history_list_item, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((VideoBean)getItem(position), (ViewHolder) convertView.getTag(),convertView);
        return convertView;
    }

    private void initializeViews(VideoBean object, ViewHolder holder, View convertView) {
        if (object != null){
            holder.tvAdapterTitle.setText(object.title);
            holder.tvVideoTitle.setText(object.secondTitle);
            switch (object.chapterId){
                case 1:
                    holder.ivVideoPlayIcon2.setImageResource(R.drawable.video_play_icon1);
                    break;
                case 2:
                    holder.ivVideoPlayIcon2.setImageResource(R.drawable.video_play_icon2);
                    break;
                case 3:
                    holder.ivVideoPlayIcon2.setImageResource(R.drawable.video_play_icon3);
                    break;
                case 4:
                    holder.ivVideoPlayIcon2.setImageResource(R.drawable.video_play_icon4);
                    break;
                case 5:
                    holder.ivVideoPlayIcon2.setImageResource(R.drawable.video_play_icon5);
                    break;
                case 6:
                    holder.ivVideoPlayIcon2.setImageResource(R.drawable.video_play_icon6);
                    break;
                case 7:
                    holder.ivVideoPlayIcon2.setImageResource(R.drawable.video_play_icon7);
                    break;
                case 8:
                    holder.ivVideoPlayIcon2.setImageResource(R.drawable.video_play_icon8);
                    break;
                case 9:
                    holder.ivVideoPlayIcon2.setImageResource(R.drawable.video_play_icon9);
                    break;
                case 10:
                    holder.ivVideoPlayIcon2.setImageResource(R.drawable.video_play_icon10);
                    break;
                    default:
                        holder.ivVideoPlayIcon2.setImageResource(R.drawable.video_play_icon1);
            }
        }
    }

    protected class ViewHolder {
        private ImageView ivVideoPlayIcon2;
        private TextView tvAdapterTitle;
        private TextView tvVideoTitle;

        public ViewHolder(View view) {
            ivVideoPlayIcon2 = (ImageView) view.findViewById(R.id.iv_video_play_icon2);
            tvAdapterTitle = (TextView) view.findViewById(R.id.tv_adapter_title);
            tvVideoTitle = (TextView) view.findViewById(R.id.tv_video_title);
        }
    }
}
