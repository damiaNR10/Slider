package com.example.damia.slider;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.zip.Inflater;

public class SlideAdapter extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    //list of images
    public int[] list_Images = {R.drawable.image_1, R.drawable.image_2, R.drawable.image_3, R.drawable.image_4};

    //list of titles
    public String[] list_titles = {"COSMONAUT", "SATELITE", "GALAXY", "ROCKET"};

    //list of descriptions
    public String[] list_descriptions = {"Description 1", "Description 2", "Description 3", "Description 4"};

    //list of background color
    public int[] list_colors = {Color.rgb(55,55,55),Color.rgb(239,85,85),Color.rgb(110,49,89),Color.rgb(1,188,212),};

    public SlideAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return list_titles.length; //number of pages (slides)
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view == (LinearLayout) o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide, container, false);
        LinearLayout slideLayout = (LinearLayout) view.findViewById(R.id.slideLinearLayout);
        ImageView imgSlide = (ImageView) view.findViewById(R.id.slideImg);
        TextView txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        TextView txtDescription = (TextView) view.findViewById(R.id.txtDescription);
        slideLayout.setBackgroundColor(list_colors[position]);
        imgSlide.setImageResource(list_Images[position]);
        txtTitle.setText(list_titles[position]);
        txtDescription.setText(list_descriptions[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }
}
