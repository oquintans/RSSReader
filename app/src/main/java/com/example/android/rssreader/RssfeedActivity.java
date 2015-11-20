package com.example.android.rssreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class RssfeedActivity extends AppCompatActivity implements MyListFragment.OnItemSelectedListener, DetailFragment.OnOkSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rssfeed);
    }

    @Override
    public void onRssItemSelected(String link) {
        DetailFragment fragment = (DetailFragment) getFragmentManager()
                .findFragmentById(R.id.detailFragment);
        fragment.setText(link);
    }

    @Override
    public void onRssOkSelected(String link) {
        MyListFragment fragment = (MyListFragment) getFragmentManager()
                .findFragmentById(R.id.listFragment);
        fragment.setTexto(link);
    }
}

