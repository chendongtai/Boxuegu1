package cn.edu.gdmec.android.myapplication.bean;


public class VideoBean {
    public int chapterId;
    public int videoId;
    public String title;
    public String secondTitle;
    public String videoPath;

    @Override
    public String toString() {
        return "VideoBean{" +
                "chapterId=" + chapterId +
                ", videoId=" + videoId +
                ", title='" + title + '\'' +
                ", secondTitle='" + secondTitle + '\'' +
                ", videoPath='" + videoPath + '\'' +
                '}';
    }
}
