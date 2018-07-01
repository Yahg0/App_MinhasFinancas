package up.edu.br.minhasfinancas;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //new Conexao(getApplicationContext(), "MinhasFinancas.db", null, 1);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it = new Intent(MainActivity.this, ContaActivity.class);
                startActivity(it);

                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //      .setAction("Action", null).show();
            }
        });

        // Lista as contas
        ListView listaContas = (ListView) findViewById(R.id.listaContas);

        ContaAdapter contaAdapter = new ContaAdapter(new ContaDAO().listar(), this);

        listaContas.setAdapter(contaAdapter);

        listaContas.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Conta c = (Conta) parent.getItemAtPosition(position);

                //Mostra o nome da conta clicada na tela
                Toast.makeText(MainActivity.this, "Conta: " + c.getUsuario(), Toast.LENGTH_SHORT).show();

                //Usado para alterar a intention = navegar para a tela de cadastro da conta
                Intent it = new Intent(MainActivity.this, ContaActivity.class);

                //Carrega o objeto nos campos da intention aberta
                // Conceito de serializable: tranforma em uma suposta "string" para poder passar o objeto
                it.putExtra("conta", c);

                startActivity(it);
            }
        }

        );

        //Excluir
        listaContas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> parent, View view, final int position, long id) {

                Conta conta = (Conta) parent.getItemAtPosition(position);

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setMessage("Deseja realmente excluir?");
                alert.setCancelable(false);
                alert.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Conta conta = (Conta) parent.getItemAtPosition(position);

                        new ContaDAO().excluir(conta);

                        //Remove da lista
                        ((ContaAdapter) parent.getAdapter()).remove(conta);
                        ((ContaAdapter) parent.getAdapter()).notifyDataSetChanged();
                    }
                });
                alert.setNegativeButton("Não", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                });

                alert.show();

                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
