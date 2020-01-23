package com.mukesh.viewpager2.utils;

import androidx.viewpager2.widget.ViewPager2;

import com.mukesh.viewpager2.utils.transformation.AntiClockSpinTransformation;
import com.mukesh.viewpager2.utils.transformation.ClockSpinTransformation;
import com.mukesh.viewpager2.utils.transformation.CubeInDepthTransformation;
import com.mukesh.viewpager2.utils.transformation.CubeInRotationTransformation;
import com.mukesh.viewpager2.utils.transformation.CubeOutDepthTransformation;
import com.mukesh.viewpager2.utils.transformation.CubeOutRotationTransformation;
import com.mukesh.viewpager2.utils.transformation.CubeOutScalingTransformation;
import com.mukesh.viewpager2.utils.transformation.DepthPageTransformer;
import com.mukesh.viewpager2.utils.transformation.DepthTransformation;
import com.mukesh.viewpager2.utils.transformation.FadeOutTransformation;
import com.mukesh.viewpager2.utils.transformation.FanTransformation;
import com.mukesh.viewpager2.utils.transformation.FidgetSpinTransformation;
import com.mukesh.viewpager2.utils.transformation.GateTransformation;
import com.mukesh.viewpager2.utils.transformation.HingeTransformation;
import com.mukesh.viewpager2.utils.transformation.HorizontalFlipTransformation;
import com.mukesh.viewpager2.utils.transformation.PopTransformation;
import com.mukesh.viewpager2.utils.transformation.SimpleTransformation;
import com.mukesh.viewpager2.utils.transformation.SpinnerTransformation;
import com.mukesh.viewpager2.utils.transformation.TossTransformation;
import com.mukesh.viewpager2.utils.transformation.VerticalFlipTransformation;
import com.mukesh.viewpager2.utils.transformation.VerticalShutTransformation;
import com.mukesh.viewpager2.utils.transformation.ZoomOutPageTransformer;


public class Utils {
    public static ViewPager2.PageTransformer getTransformer(int position) {

        switch (position) {
            case 2:
                return new AntiClockSpinTransformation();
            case 3:
                return new ClockSpinTransformation();
            case 4:
                return new CubeInDepthTransformation();
            case 5:
                return new CubeInRotationTransformation();
            case 6:
                return new CubeOutDepthTransformation();
            case 7:
                return new CubeOutRotationTransformation();
            case 8:
                return new CubeOutScalingTransformation();
            case 9:
                return new DepthPageTransformer();
            case 10:
                return new DepthTransformation();
            case 11:
                return new FadeOutTransformation();
            case 12:
                return new FanTransformation();
            case  13:
                return new FidgetSpinTransformation();
            case 14:
                return new GateTransformation();
            case 15:
                return new HingeTransformation();
            case 16:
                return new HorizontalFlipTransformation();
            case 17:
                return new PopTransformation();
            case 18:
                return new SimpleTransformation();
            case 19:
                return new SpinnerTransformation();
            case 20:
                return new TossTransformation();
            case 21:
                return new VerticalFlipTransformation();
            case 22:
                return new VerticalShutTransformation();
            case 23:
                return new ZoomOutPageTransformer();
        }
        return null;
    }
}
