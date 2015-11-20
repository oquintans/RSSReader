package com.example.android.rssreader;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MyListFragment extends Fragment {

    private OnItemSelectedListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rsslist_overview,
                container, false);
        Button button = (Button) view.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail("fake");

            }
        });
        Button button2 = (Button) view.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clean();
            }
        });

        return view;
    }

    public interface OnItemSelectedListener {
        public void onRssItemSelected(String link);

    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        if (context instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement MyListFragment.OnItemSelectedListener");
        }
    }

    // triggers update of the details fragment
    public void updateDetail(String uri) {
        // create fake data
        String newTime = String.valueOf(System.currentTimeMillis());
        // send data to activity
        listener.onRssItemSelected(newTime);
        TextView view = (TextView) getView().findViewById(R.id.rdy_text);
        view.setText("");
    }

    public void clean() {
        listener.onRssItemSelected("");
    }

    public void setTexto(String url) {
        TextView view = (TextView) getView().findViewById(R.id.rdy_text);
        view.setText(url);
    }
}


