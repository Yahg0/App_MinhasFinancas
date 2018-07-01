package up.edu.br.minhasfinancas;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContaAdapter extends BaseAdapter {
    // Extends = Classe abstrata
    // Essa classe mostra todos os itens do listview na tela


    private List<Conta> contas;

    Activity act;

    //Construtor
    public ContaAdapter(List<Conta> contas, Activity act){

        this.contas = contas;
        this.act = act;
    }

    @Override
    public int getCount() {
        //Retorna o tamanho da lista que passamos acima
        return this.contas.size();
    }

    @Override
    public Object getItem(int i) {
        //Retorna o contato em determinada posição
        return this.contas.get(i);
    }

    @Override
    public long getItemId(int i) {
        //Pega o id de determinado objeto
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        //Carrega o layout que o ArrayAdapter vai mostrar
        //Para cada item criado no list de contato, ele chama essa função

        View v = act.getLayoutInflater().inflate(R.layout.conta_adapter, viewGroup, false);

        //Traz os dados da textview pelo ID
        TextView textView = v.findViewById(R.id.txtUsuario);
        TextView textView2 = v.findViewById(R.id.txtSaldo);
        ImageView imageView = v.findViewById(R.id.imageViewListConta);


        //Spinner spTipo = v.findViewById(R.id.spTipo);

        Conta c = contas.get(i);

        //Pega as duas text view do contato
        textView.setText(c.getUsuario());





        //Altera a imagem do imageView
        //imageView.setImageResource(R.drawable.ic_launcher_foreground);


        if (c.getTipoDespesa().equals("Lazer")){

            imageView.setImageResource(R.drawable.giftbox);

        }else{

            if(c.getTipoDespesa().equals("Comida")){

                imageView.setImageResource(R.drawable.food);

            }else {

                if(c.getTipoDespesa().equals("Medicamento")){

                    imageView.setImageResource(R.drawable.pill);

                }else{

                    if (c.getTipoDespesa().equals("Contas")){

                        imageView.setImageResource(R.drawable.checklist);

                    }else{

                        if (c.getTipoDespesa().equals("Combustivel")){

                            imageView.setImageResource(R.drawable.speedometer);

                        }else{

                            if (c.getTipoDespesa().equals("Outros")){

                                imageView.setImageResource(R.drawable.money);
                            }

                        }

                    }

                }

            }



        }

        return v;
    }

    public void remove(Conta conta){
        this.contas.remove(conta);

    }

}
