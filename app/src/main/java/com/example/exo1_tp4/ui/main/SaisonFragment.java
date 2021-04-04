package com.example.exo1_tp4.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exo1_tp4.MainActivity;
import com.example.exo1_tp4.R;

import androidx.fragment.app.Fragment;

public class SaisonFragment extends Fragment
{
    // Les champs utilisés par chaque Fragment
    //Ils sont distincts pour chaque NatureFragment instancié
    private String title;

    /**
     * Pour la sauvegarde et la récupération des données
     * dans un Bundle
     */

    private static final String ARG_SECTION_TITLE = "titre_page";





    /**
     * Retourne une nouvelle instance de ce fragment
     * pour le numéro de section donné.
     */
    public static SaisonFragment newInstance(String title) {
        SaisonFragment fragment = new SaisonFragment();

        Bundle args = new Bundle();

        args.putString(ARG_SECTION_TITLE, title);

        fragment.setArguments(args);
        return fragment;
    }



    // retrouver les valeurs des champs à partir du bundle
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = getArguments().getString(ARG_SECTION_TITLE);



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.saison_main, container, false);
        TextView tvLabel = (TextView) view.findViewById(R.id.saison_label);
        tvLabel.setText(" -- " + title);
        MainActivity activity = (MainActivity)getActivity();
        ImageView imageView = (ImageView) view.findViewById(R.id.imageviewautomne);
        imageView.setImageResource(R.drawable.icon_autumn);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                activity.viewPager.setCurrentItem(2);
                Toast.makeText(activity,activity.viewPager.toString(),Toast.LENGTH_LONG).show();

            }
        });

        ImageView imageView1 = (ImageView) view.findViewById(R.id.imageviewete);
        imageView1.setImageResource(R.drawable.icon_ete);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.viewPager.setCurrentItem(1);
            }
        });

        ImageView imageView2 = (ImageView) view.findViewById(R.id.imageviewhivers);
        imageView2.setImageResource(R.drawable.icon_hiver);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.viewPager.setCurrentItem(3);
            }
        });

        ImageView imageView3 = (ImageView) view.findViewById(R.id.imageviewprintemps);
        imageView3.setImageResource(R.drawable.icon_printemps);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.viewPager.setCurrentItem(0);

            }
        });

        return view;
    }


}
