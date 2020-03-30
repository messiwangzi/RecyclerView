package com.view.recyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerItemDecoration extends RecyclerView.ItemDecoration
{
    //属性
    private static final int[] attrs = new int[]{
            android.R.attr.listDivider
    };

    //用于绘制分界线
    private Drawable divider;

    //设置分解线的方向
    private int orientation = LinearLayoutManager.VERTICAL;

    public RecyclerItemDecoration(Context context)
    {
        super();
        final TypedArray a = context.obtainStyledAttributes(attrs);
        divider = a.getDrawable(0);
        a.recycle();
    }

    public void setOrientation(int orientation)
    {
        if (orientation != LinearLayoutManager.HORIZONTAL && orientation != LinearLayoutManager.VERTICAL)
        {
            throw new IllegalArgumentException("invalid orientation");
        }
        this.orientation = orientation;
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state)
    {
        super.onDraw(c, parent, state);
        if (orientation == LinearLayoutManager.VERTICAL)
        {
            drawVertical(c, parent);
        } else
        {
            drawHorizontal(c, parent);
        }
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state)
    {
        super.getItemOffsets(outRect, view, parent, state);
        if (orientation == LinearLayoutManager.VERTICAL)
        {
            outRect.set(0, 0, 0, divider.getIntrinsicHeight());
        } else
        {
            outRect.set(0, 0, divider.getIntrinsicWidth(), 0);
        }
    }

    /**
     * 绘制间隔
     */
    private void drawVertical(Canvas c, RecyclerView parent)
    {
        final int left = parent.getPaddingLeft();
        final int right = parent.getWidth() - parent.getPaddingRight();
        final int childCount = parent.getChildCount();
        // 遍历
        for (int i = 0; i < childCount; i++)
        {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin +
                    Math.round(ViewCompat.getTranslationY(child));
            final int bottom = top + divider.getIntrinsicHeight();
            divider.setBounds(left, top, right, bottom);
            divider.draw(c);
        }
    }

    /**
     * 绘制间隔
     */
    private void drawHorizontal(Canvas c, RecyclerView parent)
    {
        final int top = parent.getPaddingTop();
        final int bottom = parent.getHeight() - parent.getPaddingBottom();
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++)
        {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int left = child.getRight() + params.rightMargin +
                    Math.round(ViewCompat.getTranslationZ(child));
            final int right = left + divider.getIntrinsicHeight();
            divider.setBounds(left, top, right, bottom);
            divider.draw(c);
        }
    }
}
