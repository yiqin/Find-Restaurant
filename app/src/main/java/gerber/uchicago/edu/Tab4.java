package gerber.uchicago.edu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Edwin on 15/02/2015.
 */
public class Tab4 extends Fragment {

//    ToggleButton mToggleButton;
//    LinearLayout mLinearLayoutDetails;


//    private RadioGroup mRadioGroup;
//    private FragmentTransaction mFragmentTransaction;
//    private FragmentManager mFragmentManager;



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.frag_scroll_layout_new,container,false);

//        btnTabEdit = (RadioButton) v.findViewById(R.id.btn_tab_edit);
//        btnTabNew = (RadioButton) v.findViewById(R.id.btn_tab_new);
//
//        mRadioGroup = (RadioGroup) v.findViewById(R.id.rdogrp);
//        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if (checkedId == R.id.btn_tab_edit){
//
//                    mFragmentManager =
//                            getActivity().getSupportFragmentManager();
//                    mFragmentTransaction = mFragmentManager.beginTransaction();
//
//                    Bundle bundle  =new Bundle();
//                    bundle.putInt(ScrollFrag.LAYOUT_KEY, R.layout.frag_scroll_layout_edit);
//                    ScrollFrag frag = ScrollFrag.getInstance(bundle);
//
////                    ScrollFrag oldFrag= StateMgr.getInstance().get(R.layout.frag_scroll_layout_new_1);
////
////                    mFragmentTransaction.replace(R.id.data_root_view_group, oldFrag, String.valueOf(R.layout.frag_scroll_layout_new_1))
////                            .addToBackStack(String.valueOf(R.layout.frag_scroll_layout_edit)).commit();
//
//                    mFragmentTransaction.replace(R.id.data_root_view_group, frag);
//                    mFragmentTransaction.addToBackStack(null);
//                    mFragmentTransaction.commit();
//
//                }
//                //new is clicked
//                else {
//
//                    mFragmentManager =
//                            getActivity().getSupportFragmentManager();
//                    mFragmentTransaction = mFragmentManager.beginTransaction();
//
//                    Bundle bundle  =new Bundle();
//                    bundle.putInt(ScrollFrag.LAYOUT_KEY, R.layout.frag_scroll_layout_new_1);
//                    ScrollFrag frag = ScrollFrag.getInstance(bundle);
//
//                  //  mFragmentTransaction.replace(R.id.data_root_view_group, frag);
////                    ScrollFrag oldFrag= StateMgr.getInstance().get(R.layout.frag_scroll_layout_edit);
////
////                    mFragmentTransaction.replace(R.id.data_root_view_group,frag,String.valueOf(R.layout.frag_scroll_layout_edit))
////                            .addToBackStack(String.valueOf(R.layout.frag_scroll_layout_new_1)).commit();
//                    mFragmentTransaction.replace(R.id.data_root_view_group, frag);
//                    mFragmentTransaction.addToBackStack(null);
//                    mFragmentTransaction.commit();
//
//
//
//                }
//
////                ScrollFrag oldFragment = (ScrollFrag) mFragmentManager.findFragmentByTag(R.id.data_root_view_group);
////                mFragmentTransaction.addToBackStack(null);
////                mFragmentTransaction.commit();
//
//
//
//            }
//        });
//

//        mToggleButton = (ToggleButton) v.findViewById(R.id.toggle_btn);
//        mLinearLayoutDetails = (LinearLayout) v.findViewById(R.id.details_layout);
//
//
//        mToggleButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Animation anim;
//                if (mToggleButton.isChecked()) {
//
//                   anim = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_down);
//                    anim.setAnimationListener(new Animation.AnimationListener() {
//                        @Override
//                        public void onAnimationStart(Animation animation) {
//                            mLinearLayoutDetails.setVisibility(View.VISIBLE);
//                        }
//
//                        @Override
//                        public void onAnimationEnd(Animation animation) {
//
//                        }
//
//                        @Override
//                        public void onAnimationRepeat(Animation animation) {
//
//                        }
//                    });
//                    if(anim != null){
//                        anim.reset();
//                        mLinearLayoutDetails.clearAnimation();
//                        mLinearLayoutDetails.startAnimation(anim);
//
//                    }
//
//                } else {
//
//                    anim = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_up);
//                    anim.setAnimationListener(new Animation.AnimationListener() {
//                        @Override
//                        public void onAnimationStart(Animation animation) {
//
//                        }
//
//                        @Override
//                        public void onAnimationEnd(Animation animation) {
//                            mLinearLayoutDetails.setVisibility(View.GONE);
//                        }
//
//                        @Override
//                        public void onAnimationRepeat(Animation animation) {
//
//                        }
//                    });
//                    if(anim != null){
//                        anim.reset();
//                        mLinearLayoutDetails.clearAnimation();
//                        mLinearLayoutDetails.startAnimation(anim);
//
//                    }
//
//
//
//                }
//            }
//        });
        return v;
    }





}
