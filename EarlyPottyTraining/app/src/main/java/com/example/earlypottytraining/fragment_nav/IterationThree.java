package com.example.earlypottytraining.fragment_nav;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.earlypottytraining.R;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link IterationThree.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link IterationThree#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IterationThree extends Fragment {
    TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_iteration_three, container, false);
        textView = view.findViewById(R.id.tv);
        return view;
    }


}
