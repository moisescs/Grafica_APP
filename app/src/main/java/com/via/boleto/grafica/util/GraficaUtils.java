package com.via.boleto.grafica.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.widget.Toast;

import com.via.boleto.grafica.R;
import com.via.boleto.grafica.dao.BaseLocalDAO;
import com.via.boleto.grafica.model.ProdutoTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LucasOliveira on 10/03/2018.
 */

public class GraficaUtils {

    public static boolean notNullNotBlank(String texto){

        return (texto.trim().length() !=0 && texto != null);
    }

    public static boolean verificaConexao(Context context) {

        ConnectivityManager conectivtyManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conectivtyManager.getActiveNetworkInfo() != null
                && conectivtyManager.getActiveNetworkInfo().isAvailable()
                && conectivtyManager.getActiveNetworkInfo().isConnected()) {
            return true;
        }
        return false;
    }

    public static void salvarListaProduto(Context context){

       final BaseLocalDAO baseLocalDAO = new BaseLocalDAO(context);


        baseLocalDAO.apagarConteudoTabela("produto");
        iRetrofit retrofit = iRetrofit.retrofit.create(iRetrofit.class);
        final Call<List<ProdutoTO>> call = retrofit.getProduto();

        call.enqueue(new Callback<List<ProdutoTO>>() {
            @Override
            public void onResponse(Call<List<ProdutoTO>> call, Response<List<ProdutoTO>> response) {
                int code = response.code();
                if (code == 200){
                    List<ProdutoTO> listaProdutos = response.body();
                        salvarListaProduto(listaProdutos, baseLocalDAO);

                }
            }

            @Override
            public void onFailure(Call<List<ProdutoTO>> call, Throwable t) {
            }
        });


    }

    private static void salvarListaProduto(List<ProdutoTO> listaProdutos, BaseLocalDAO baseLocalDAO){
        for(ProdutoTO produtoDaVez: listaProdutos){
            baseLocalDAO.salvarProduto(produtoDaVez);
        }
    }
}


