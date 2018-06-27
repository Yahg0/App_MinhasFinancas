package up.edu.br.minhasfinancas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexao extends SQLiteOpenHelper {

    public static Conexao conexao;

    public static Conexao getInstance(){
        return conexao;

    }

    public Conexao(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

        conexao = this;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String statement = " create table conta (" +
                "id integer primary key autoincrement," +
                "usuario varchar (255)," +
                "saldo double (8,2)," +
                "poupanca double (8,2)," +
                "tipoDespesa varchar (80)," +
                "despesa double (8,2)" + ")";

        db.execSQL(statement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
