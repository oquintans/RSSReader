package com.example.android.rssreader;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by oquintansocampo on 18/11/15.
 */
public class DetailFragment extends Fragment {

    private OnOkSelectedListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rssitem_detail,
                container, false);

        Button button_ok = (Button) view.findViewById(R.id.button_ok);
        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rdy();
            }
        });
        return view;
    }

    public interface OnOkSelectedListener {
        public void onRssOkSelected(String link);

    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        if (context instanceof OnOkSelectedListener) {
            listener = (OnOkSelectedListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement MyListFragment.OnItemSelectedListener");
        }
    }

    public void setText(String url) {
        TextView view = (TextView) getView().findViewById(R.id.detailsText);
        view.setText(url);
    }

    public void rdy() {
        listener.onRssOkSelected("Listo");
    }
}