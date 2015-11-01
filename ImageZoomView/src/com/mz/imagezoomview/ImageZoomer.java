package com.mz.imagezoomview;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class ImageZoomer extends RelativeLayout {

	ZoomImageView imageView;
	 ImageView ZoomIcon;
	 
	public ImageZoomer(Context context) {
		super(context);
		 init(context);
		
		// TODO Auto-generat§ed constructor stub
	}
	
	public ImageZoomer(Context context, AttributeSet attrs) {
	    super(context, attrs);
	    init(context);
	}

	public ImageZoomer(Context context, AttributeSet attrs, int defStyle) {
	    super(context, attrs, defStyle);
	    init(context);
	}
	private void init(Context context) {
	    //do stuff that was in your original constructor...
		
		imageView = new ZoomImageView(getContext());
		imageView.setLayoutParams(new ViewGroup.LayoutParams(
	            ViewGroup.LayoutParams.WRAP_CONTENT,
	            ViewGroup.LayoutParams.WRAP_CONTENT));
		
		setURL("http://zalih.com/images/avatar.png","http://zalih.com/images/avatar.jpg");

	}
	public void setURL(String Url){
		Picasso.with(getContext()).load(Url).into(imageView);
	}
	public void setURL(String Url,final String zoomedImageUrl) {
		Picasso.with(getContext()).load(Url).into(imageView,new Callback() {
			
			@Override
			public void onSuccess() {
				// TODO Auto-generated method stub
				setZommImageUrl(zoomedImageUrl);
			}
			
			@Override
			public void onError() {
				// TODO Auto-generated method stub
				
			}
		});
			  
		addView(imageView);
		
	}
	
	public void setZommImageUrl(String zoomedImageUrl) {
		imageView.setZoomImageUrl(zoomedImageUrl);
		ZoomIcon = new ImageView(getContext());
		ZoomIcon.setImageResource(android.R.drawable.ic_menu_search);
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
	            ViewGroup.LayoutParams.WRAP_CONTENT,
	            ViewGroup.LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.ALIGN_LEFT);
		//params.addRule(RelativeLayout.LEFT_OF, R.id.id_to_be_left_of);
		addView(ZoomIcon);
		ZoomIcon.setLayoutParams(params); 

	}

}
