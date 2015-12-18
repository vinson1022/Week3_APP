package com.example.vinson_chen.week3_app;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Fragment fragment_content;
    Button button_img,button_math,button_about;
    public Button button_math_ans;


    private View.OnClickListener Button_Listener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v) {
            if(v.getId() == button_img.getId()){
                Fragment_Img fragment1 = new Fragment_Img();
                getFragmentManager().beginTransaction().replace(R.id.fragment_content, fragment1).commit();
            }
            else if(v.getId() == button_math.getId()){
                Fragment_Math fragment1 = new Fragment_Math();
                getFragmentManager().beginTransaction().replace(R.id.fragment_content, fragment1).commit();
            }
            else if(v.getId() == button_about.getId()){
                Fragment_About fragment1 = new Fragment_About();
                getFragmentManager().beginTransaction().replace(R.id.fragment_content, fragment1).commit();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setView();
        setListener();

    }

    public void setView(){

        Fragment_Img fragment1 = new Fragment_Img();
        getFragmentManager().beginTransaction().replace(R.id.fragment_content, fragment1).commit();

        button_img = (Button)findViewById(R.id.button);
        button_math = (Button)findViewById(R.id.button2);
        button_about = (Button)findViewById(R.id.button3);

    }

    public void setListener(){

        button_img.setOnClickListener(Button_Listener);
        button_math.setOnClickListener(Button_Listener);
        button_about.setOnClickListener(Button_Listener);


    }

    public static class Fragment_Img extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_img, container, false);
        }
    }

    public static class Fragment_About extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.layout_fragment_about, container, false);
        }
    }

    @SuppressLint("ValidFragment")
    public class Fragment_Math extends Fragment implements View.OnClickListener {

        Button button_math_ans;
        TextView textView_math;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment

            View view = inflater.inflate(R.layout.layout_fragment_math_question, container, false);

            textView_math = (TextView)view.findViewById(R.id.textView_math_question);
            textView_math.setText(R.string.math_question);
            button_math_ans = (Button) view.findViewById(R.id.button_math_ans);
            button_math_ans.setOnClickListener(this);

            return view;
        }

        @Override
        public void onClick(View v) {
            textView_math.setText(R.string.math_answer);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.layout_activity_main_landscape);
            setView();
            setListener();

        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_main);
            setView();
            setListener();
        }
    }

}
