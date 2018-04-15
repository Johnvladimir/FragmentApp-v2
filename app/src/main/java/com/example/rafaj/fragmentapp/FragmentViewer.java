package com.example.rafaj.fragmentapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class FragmentViewer extends Fragment {
    TextView text;
    ImageView imagen;
    TextView gravedad;
    TextView escapar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viewer_fragment, container, false);

        text = view.findViewById(R.id.textId);
        imagen = view.findViewById(R.id.planetas);
        gravedad = view.findViewById(R.id.gravedad);
        escapar = view.findViewById(R.id.escapar);
        Bundle bundle = this.getArguments();

        if (bundle != null) {
            text.setText(bundle.getString("KEY"));
            imagen.setImageResource(bundle.getInt("KEY2"));
            gravedad.setText(bundle.getString("grav"));
            escapar.setText(bundle.getString("acele"));
        }

        return view;
    }


}
