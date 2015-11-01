package com.mz.imagezoomview;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

public class ZoomImageView extends ImageView{
	String zoomImageUrl;  
	Activity baseActivity;
	public String getZoomImageUrl() {
		return zoomImageUrl;
	}

	public void setZoomImageUrl(String zoomImageUrl) {
		this.zoomImageUrl = zoomImageUrl;
	}

	public ZoomImageView(Context context) {
		super(context);
		init(context);
		// TODO Auto-generated constructor stub
	}

	public ZoomImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
		// TODO Auto-generated constructor stub
		
	}
	public void addZoom(){
		
	}
	
	@Override
	public void setOnClickListener(OnClickListener l) {
		// TODO Auto-generated method stub
		super.setOnClickListener(l);
	}
	
	private void init(Context context){
setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			 showZoom(getContext());
			}
		});
	}

	
	public void showZoom(Context ctx){
		if(zoomImageUrl != null){
			 
		// custom dialog
		final Dialog dialog = new Dialog(baseActivity);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		LinearLayout view  = new LinearLayout(getContext());
		final ScaleImageView image = new ScaleImageView(getContext());
			image.setLayoutParams(getLayoutParams());
			image.getLayoutParams().height=300;
			image.getLayoutParams().width=300;
			image.setBackgroundColor(Color.TRANSPARENT);
			System.out.println(zoomImageUrl);
						Picasso.with(getContext()).
			load(zoomImageUrl).
			placeholder(getDrawable()).
			into(image);
		view.addView(image);
		dialog.setContentView(view);		 
		dialog.show();
	
		}
	}
}
