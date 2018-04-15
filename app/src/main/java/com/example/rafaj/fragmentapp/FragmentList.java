package com.example.rafaj.fragmentapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;


public class FragmentList extends ListFragment implements AdapterView.OnItemClickListener {

    Planet sol;
    Planet mercurio;
    Planet venus;
    Planet tierra;
    Planet marte;
    Planet jupiter;
    Planet saturno;
    Planet urano;
    Planet neptuno;

    ArrayList<Planet> planetas = new ArrayList<Planet>();

    public void insertPlanets() {
        sol = new Planet("Sol", R.drawable.sol, "7500", "80000");
        mercurio = new Planet("mercurio", R.drawable.sol, "12345", "65000");
        venus = new Planet("venus", R.drawable.venus, "6300", "75000");
        tierra = new Planet("Tierra", R.drawable.tierra, "3000", "4000");
        marte = new Planet("marte", R.drawable.marte, "12000", "45000");
        jupiter = new Planet("jupiter", R.drawable.jupiter, "70325", "12345");
        saturno = new Planet("saturno", R.drawable.saturno, "25230", "83450");
        urano = new Planet("urano", R.drawable.urano, "48274", "38472");
        neptuno = new Planet("neptuno", R.drawable.neptuno, "38472", "34872");

        planetas.add(0, sol);
        planetas.add(1, mercurio);
        planetas.add(2, venus);
        planetas.add(3, tierra);
        planetas.add(4, marte);
        planetas.add(5, jupiter);
        planetas.add(6, saturno);
        planetas.add(7, urano);
        planetas.add(8, neptuno);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.Planets, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
        insertPlanets();
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            Intent newIntent = new Intent(getActivity().getApplicationContext(), Main2Activity.class);
            newIntent.setAction(Intent.ACTION_SEND);
            newIntent.setType("text/plain");
            newIntent.putExtra(Intent.EXTRA_TEXT, adapterView.getItemAtPosition(i).toString());//
            Bundle bun = new Bundle();
            bun.putString("llave", planetas.get(i).getPlanetas());
            bun.putInt("llave2", planetas.get(i).getImagen());
            bun.putString("llave3", planetas.get(i).getEdad());
            bun.putString("llave4", planetas.get(i).getTamaño());
            newIntent.putExtras(bun);
            startActivity(newIntent);
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(getActivity(), "Item: " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();

            Bundle bundle = new Bundle();
            bundle.putString("KEY", planetas.get(i).getPlanetas());
            bundle.putInt("KEY2", planetas.get(i).getImagen());
            bundle.putString("grav", planetas.get(i).getEdad());
            bundle.putString("acele", planetas.get(i).getTamaño());
            FragmentViewer frag = new FragmentViewer();
            frag.setArguments(bundle);

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.viewer, frag);
            fragmentTransaction.commit();
        }
    }
}
