package com.via.boleto.grafica;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class DinheiroFragment extends Fragment {


    public DinheiroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((PrincipalActivity)getActivity()).setActionBarTitle(getString(R.string.tela_principal_vendas_por_dinheiro_label));
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dinheiro, container, false);
    }

}
