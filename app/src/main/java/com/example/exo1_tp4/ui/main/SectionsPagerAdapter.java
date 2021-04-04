package com.example.exo1_tp4.ui.main;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.widget.ImageView;

import com.example.exo1_tp4.R;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import java.util.Locale;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    ImageView image1,image2,image3,image4;

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        // return PlaceholderFragment.newInstance(position + 1);
        switch ( position ) {
            case 0 :
                return NatureFragment.newInstance( 0 , mContext.getString(R.string.titre_section0),R.drawable.printemps);
            case 1 :
                return NatureFragment.newInstance( 1 , mContext.getString(R.string.titre_section1),R.drawable.ete);
            case 2 :
                return NatureFragment.newInstance( 2 , mContext.getString(R.string.titre_section2),R.drawable.automne);
            case 3 :
                return NatureFragment.newInstance( 3, mContext.getString(R.string.titre_section3),R.drawable.hiver);
            case 4 :
                return SaisonFragment.newInstance(mContext.getString(R.string.titre_section4));


        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        // return mContext.getResources().getString(TAB_TITLES[position]);

        Locale l = Locale.getDefault();
        String titre="";
        Drawable icone=null;
        switch (position) {
            case 0:
                titre = mContext.getString(R.string.titre_section0).toUpperCase(l);
                icone = mContext.getResources().getDrawable(R.drawable.icon_printemps);

                break;
            case 1:
                titre = mContext.getString(R.string.titre_section1).toUpperCase(l);
                icone = mContext.getResources().getDrawable(R.drawable.icon_ete);

                break;
            case 2:
                titre = mContext.getString(R.string.titre_section2).toUpperCase(l);
                icone = mContext.getResources().getDrawable(R.drawable.icon_autumn);

                break;
            case 3:
                titre = mContext.getString(R.string.titre_section3).toUpperCase(l);
                icone = mContext.getResources().getDrawable(R.drawable.icon_hiver);

                break;
            case 4:
                titre = mContext.getString(R.string.titre_section4).toUpperCase(l);
                icone = mContext.getResources().getDrawable(R.drawable.icon_saison);
                break;
        }
        SpannableString sb = new SpannableString(" " + titre);
// un espace est ajouté pour séparer le texte de l'image

        icone.setBounds(0, 0, icone.getIntrinsicWidth(), icone.getIntrinsicHeight());
        ImageSpan span = new ImageSpan(icone, ImageSpan.ALIGN_BASELINE);
        sb.setSpan(span,0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return sb;
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 5;
    }
}