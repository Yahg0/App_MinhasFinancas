package up.edu.br.minhasfinancas;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class ContaAdapter extends BaseAdapter {
    // Extends = Classe abstrata
    // Essa classe mostra todos os itens do listview na tela


    private List<Conta> contas;

    Activity act;

    public ContaAdapter(List<Conta> contas, Activity act){

        this.contas = contas;
        this.act = act;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
