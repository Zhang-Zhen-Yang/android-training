package com.example.asus.androidtraining;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.session.MediaController;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class MediaPlayerActivity extends AppCompatActivity {

    VideoView mediaPlayerVideoView;
    MediaController mediaCtrl;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);
        initView();

    }

    @Override
    protected void onResume() {
        super.onResume();
        bindAction();
    }

    private void bindAction() {
        //mediaPlayerVideoView.setMediaController(mediaCtrl);
        mediaPlayerVideoView.setVideoURI(Uri.parse("http://github.liaoxuefeng.com/sinaweibopy/video/git-diff-status.mp4"));
        mediaPlayerVideoView.requestFocus();
        mediaPlayerVideoView.start();
    }

    private void initView() {
        mediaPlayerVideoView = (VideoView) findViewById(R.id.mediaPlayerVideoView);
        //mediaCtrl = new MediaController(context);
    }
}
