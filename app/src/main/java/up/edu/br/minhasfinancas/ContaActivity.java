package up.edu.br.minhasfinancas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ContaActivity extends AppCompatActivity {

    Conta conta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conta);

        //Preenche a textbox com o parametro nome do objeto Contato
        EditText txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        EditText txtSaldo = (EditText) findViewById(R.id.txtSaldo);
        EditText txtPoupanca = (EditText) findViewById(R.id.txtPoupanca);

        EditText txtDespesa = (EditText) findViewById(R.id.txtDespesa);

        //Capturar a intention(tela)
        Intent it = getIntent();

        if (it != null && it.hasExtra("contato")) {

            //Captura o objeto vindo serializado
            conta = (Conta) it.getSerializableExtra("conta");

            Spinner spTipoDespesa = (Spinner) findViewById(R.id.spTipoDespesa);

            txtUsuario.setText(conta.getUsuario());
            txtSaldo.setText(conta.getSaldo());
            txtPoupanca.setText(conta.getPoupanca());
            txtDespesa.setText(conta.getDespesa());

            spTipoDespesa.setSelection(((ArrayAdapter) spTipoDespesa.getAdapter()).getPosition(conta.getTipoDespesa()));

        }

    }

    // Adiciona o menu do contato
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_conta, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.save) {

            // Pega a referencia
            EditText txtUsuario = findViewById(R.id.txtUsuario);
            EditText txtSaldo = findViewById(R.id.txtSaldo);
            EditText txtPoupanca = findViewById(R.id.txtPoupanca);
            EditText txtDespesa = findViewById(R.id.txtDespesa);

            Spinner spTipoDespesa = (Spinner) findViewById(R.id.spTipoDespesa);


            if (conta == null) {
                conta = new Conta();
            }

            //Seta os novos valores
            conta.setUsuario(txtUsuario.getText().toString());
            conta.setSaldo(txtSaldo.getText().toString());
            conta.setPoupanca(txtPoupanca.getText().toString());
            conta.setTipoDespesa(spTipoDespesa.getSelectedItem().toString());
            conta.setDespesa(txtDespesa.getText().toString());

            new ContaDAO().salvar(conta);
            conta = null;

            // Mensagem ao clicar no icone do menu
            Toast.makeText(getApplicationContext(), "Salvo com sucesso !",
                    Toast.LENGTH_SHORT).show();

            Intent it = new Intent(ContaActivity.this, MainActivity.class);

            startActivity(it);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
