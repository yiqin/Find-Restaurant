package gerber.uchicago.edu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

import gerber.uchicago.edu.R;

/**
 * Created by Edwin on 15/02/2015.
 */
public class Tab1 extends Fragment {

    ToggleButton mToggleButton;
    LinearLayout mLinearLayoutDetails;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.activity_edit_resto,container,false);
        mToggleButton = (ToggleButton) v.findViewById(R.id.toggle_btn);
        mLinearLayoutDetails = (LinearLayout) v.findViewById(R.id.details_layout);


        mToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animation anim;
                if (mToggleButton.isChecked()) {

                   anim = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_down);
                    anim.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            mLinearLayoutDetails.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    if(anim != null){
                        anim.reset();
                        mLinearLayoutDetails.clearAnimation();
                        mLinearLayoutDetails.startAnimation(anim);

                    }

                } else {

                    anim = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_up);
                    anim.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            mLinearLayoutDetails.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    if(anim != null){
                        anim.reset();
                        mLinearLayoutDetails.clearAnimation();
                        mLinearLayoutDetails.startAnimation(anim);

                    }



                }
            }
        });
        return v;
    }





}
