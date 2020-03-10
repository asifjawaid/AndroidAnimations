package com.cs.androidanimations.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.cs.androidanimations.R;
import com.cs.androidanimations.adapter.CommentArrayAdapter;
import com.cs.androidanimations.model.CardData;
import com.cs.androidanimations.model.ExampleDataset;
import com.ramotion.expandingcollection.ECBackgroundSwitcherView;
import com.ramotion.expandingcollection.ECCardData;
import com.ramotion.expandingcollection.ECPagerView;
import com.ramotion.expandingcollection.ECPagerViewAdapter;

public class ExpandingCollActivity extends Activity {

    private ECPagerView ecPagerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expanding_coll);

        // Get pager from layout
        ecPagerView = (ECPagerView) findViewById(R.id.ec_pager_element);

        // Implement pager adapter and attach it to pager view
        ECPagerViewAdapter adapter = new ECPagerViewAdapter(this, new ExampleDataset().getDataset()) {
            @Override
            public void instantiateCard(LayoutInflater inflaterService, ViewGroup head, final ListView list, ECCardData data) {
                final CardData cardData = (CardData) data;

                // Create adapter for list inside a card and set adapter to card content
                CommentArrayAdapter commentArrayAdapter = new CommentArrayAdapter(getApplicationContext(), cardData.getListItems());
                list.setAdapter(commentArrayAdapter);
                list.setDivider(getResources().getDrawable(R.drawable.list_divider));
                list.setDividerHeight((int) pxFromDp(getApplicationContext(), 0.5f));
                list.setSelector(R.color.transparent);
                list.setBackgroundColor(Color.WHITE);
                list.setCacheColorHint(Color.TRANSPARENT);

                // Add gradient to root header view
                View gradient = new View(getApplicationContext());
                gradient.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.MATCH_PARENT));
                gradient.setBackgroundDrawable(getResources().getDrawable(R.drawable.card_head_gradient));
                head.addView(gradient);

                // Inflate main header layout and attach it to header root view
                inflaterService.inflate(R.layout.simple_head, head);

                // Set header data from data object
                TextView title = (TextView) head.findViewById(R.id.title);
                title.setText(cardData.getHeadTitle());
                ImageView avatar = (ImageView) head.findViewById(R.id.avatar);
                avatar.setImageResource(cardData.getPersonPictureResource());
                TextView name = (TextView) head.findViewById(R.id.name);
                name.setText(cardData.getPersonName() + ":");
                TextView message = (TextView) head.findViewById(R.id.message);
                message.setText(cardData.getPersonMessage());
                TextView viewsCount = (TextView) head.findViewById(R.id.socialViewsCount);
                viewsCount.setText(" " + cardData.getPersonViewsCount());
                TextView likesCount = (TextView) head.findViewById(R.id.socialLikesCount);
                likesCount.setText(" " + cardData.getPersonLikesCount());
                TextView commentsCount = (TextView) head.findViewById(R.id.socialCommentsCount);
                commentsCount.setText(" " + cardData.getPersonCommentsCount());

                // Add onclick listener to card header for toggle card state
                head.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        ecPagerView.toggle();
                    }
                });
            }
        };
        ecPagerView.setPagerViewAdapter(adapter);
        // Add background switcher to pager view
        ecPagerView.setBackgroundSwitcherView((ECBackgroundSwitcherView) findViewById(R.id.ec_bg_switcher_element));
        adapter.notifyDataSetChanged();

    }

    public static float dpFromPx(final Context context, final float px) {
        return px / context.getResources().getDisplayMetrics().density;
    }

    public static float pxFromDp(final Context context, final float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }
    // Card collapse on back pressed
    @Override
    public void onBackPressed() {
        if (!ecPagerView.collapse())
            super.onBackPressed();
    }

}