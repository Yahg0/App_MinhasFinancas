package up.edu.br.minhasfinancas;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ContaDAO {

    public void salvar(Conta conta){

        SQLiteDatabase conn =  Conexao.getInstance().getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("usuario", conta.getUsuario());
        values.put("saldo", conta.getSaldo());
        values.put("poupanca", conta.getPoupanca());
        values.put("tipoDespesa", conta.getTipoDespesa());
        values.put("despesa", conta.getDespesa());

        if (conta.getId() == null){
            conn.insert("contato", null, values);
        }else{
            conn.update("usuario", values, "id = ?", new String []{conta.getId().toString()});
        }

    }

    public List<Conta> listar(){

        SQLiteDatabase conn =  Conexao.getInstance().getReadableDatabase();

        Cursor c = conn.query("conta", new String[] {"id", "usuario", "saldo", "poupanca", "tipoDespesa", "despesa"}, null,null,
                null, null, "nome");

        ArrayList<Conta> contas = new ArrayList<Conta>();

        if(c.moveToFirst()){
            do {
                Conta conta = new Conta();
                conta.setId(c.getInt(0));
                conta.setUsuario(c.getString(1));
                conta.setSaldo(c.getDouble(2));
                conta.setPoupanca(c.getDouble(3));
                conta.setTipoDespesa(c.getString(4));
                conta.setDespesa(c.getDouble(5));

                contas.add(conta);

            }while(c.moveToNext());
        }

        return contas;

    }

    public void excluir(Conta conta){

        SQLiteDatabase conn =  Conexao.getInstance().getWritableDatabase();

        conn.delete("conta","id = ?", new String []{conta.getId().toString()});

    }

}
