package com.yy.android.myapplicationaaq.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class MyViewGroup extends ViewGroup {
    public MyViewGroup(Context context) {
        super(context);
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec,heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int childCount = getChildCount();
        if (childCount == 0) {
            setMeasuredDimension(0,0);
        } else {
            // if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
            //     int height = getTotalHeight();
            //     int width = getMaxChildWidth();
            //     setMeasuredDimension(width,height);
            // } else if (heightMode == MeasureSpec.AT_MOST) {
            //     setMeasuredDimension(widthSize, getTotalHeight());
            // } else if (widthMode == MeasureSpec.AT_MOST) {
            //     setMeasuredDimension(getMaxChildWidth(),heightSize);
            // }
            if (heightMode == MeasureSpec.AT_MOST) {
                setMeasuredDimension(widthSize,getNeedHeight(widthSize));
            }
        }

    }

    private int getNeedHeight(int width) {
        int childCount = getChildCount();
        int height = 0;
        int curMaxHeight = 0;
        int curWidth = 0;
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            if (curWidth + childView.getMeasuredWidth() > width) {
                height += curMaxHeight;
                i--;
                curWidth = 0;
            } else {
                curWidth += childView.getMeasuredWidth();
                curMaxHeight = Math.max(curMaxHeight,childView.getMeasuredHeight());
            }
        }
        height += curMaxHeight;
        System.out.println("AAAAA   !@"+height);
        return height;
    }

    private int getMaxChildWidth() {
        int childCount = getChildCount();
        int maxWidth = 0;
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            if (childView.getMeasuredWidth() > maxWidth) {
                maxWidth = childView.getMeasuredWidth();
            }
        }
        return maxWidth;
    }

    private int getTotalHeight() {
        int childCount = getChildCount();
        int totalHeight = 0;
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            totalHeight += childView.getMeasuredWidth();
            System.out.println(totalHeight+"           aSD");
        }

        return totalHeight;
    }

    // @Override
    // protected void onLayout(boolean changed, int l, int t, int r, int b) {
    //     int count = getChildCount();
    //     int curHeight = t;
    //     for (int i = 0; i < count; i++) {
    //         View child = getChildAt(i);
    //         int height = child.getMeasuredHeight();
    //         int width = child.getMeasuredWidth();
    //         child.layout(l,curHeight,l+width,curHeight+height);
    //         curHeight += height;
    //     }
    // }
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int count = getChildCount();
        int curHight = t;
        int maxHeight = 0;
        int curWidth = l;
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            int height = child.getMeasuredHeight();
            System.out.println("AAAAAAAAAA    "+height);
            int width = child.getMeasuredWidth();
            maxHeight = Math.max(maxHeight, height);
            if (curWidth + width > r) {
                curWidth = l;
                curHight += maxHeight;
                System.out.println("AAAAA    @@@"+curHight);
            }
            int left = child.getPaddingLeft();
            int top = child.getPaddingTop();
            int right = child.getPaddingRight();
            int bottom = child.getPaddingBottom();
            System.out.println( "AAAAA   !#"+left+"   "+top+"   "+right+"   "+bottom);
            System.out.println(
                    "AAAAA   !" + curWidth + "     " + curHight + "     " + (curWidth+width) + "   " +
                            (curHight + height));
            child.layout(curWidth+left,curHight+top,curWidth+width-right,curHight+height-bottom);
            curWidth += width;
        }
    }
}
