package com.dev.bob.aluguel_automovel.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bob on 07/11/2017.
 */

public class DBAutomoveis extends SQLiteOpenHelper {

    private static final String NOME_BD = "dbauto";
    private static final int VERSAO_BD = 1;
    private Context contexto;
    public static final String AUTO_TABLE_NAME = "tableauto";
    public static final String AUTO_COLUMN_ID = "id";
    public static final String AUTO_COLUMN_NAME = "name";
    public static final String AUTO_COLUMN_PLACA = "placa";
    public static final String AUTO_COLUMN_TYPE = "type";
    public static final String AUTO_COLUMN_DISPONIVEL = "disponivel";
    private static final ArrayList<String> nomeAuto = new ArrayList<String>();
    private static final ArrayList<String> placaAuto = new ArrayList<>();
    private static final ArrayList<String> typeAuto = new ArrayList<>();
    private static final int disponivelAuto = 0;
    private int i=0;
    public DBAutomoveis(Context context) {
        super(context, NOME_BD, null, VERSAO_BD);
        this.contexto = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS " + AUTO_TABLE_NAME + " ("
                + AUTO_COLUMN_ID + " integer primary key,"
                + AUTO_COLUMN_NAME + " text,"
                + AUTO_COLUMN_PLACA + " text,"
                + AUTO_COLUMN_TYPE + "text,"
                + AUTO_COLUMN_DISPONIVEL + "integer"
                + ")";
        sqLiteDatabase.execSQL(sql);
        _insert();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+AUTO_TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    private void _insert() {
        SQLiteDatabase db = getWritableDatabase();
        nomeAuto.add(0,"Uno 2017");
        nomeAuto.add(1,"I30");
        nomeAuto.add(2,"Jeep");
        placaAuto.add(0,"HHB8767");
        placaAuto.add(1,"HGB8767");
        placaAuto.add(2,"AHC8756");
        typeAuto.add(0,"Basico");
        typeAuto.add(1,"Intermediário");
        typeAuto.add(2,"Executivo");
        try {
            ContentValues values = new ContentValues();
            for (i=0;nomeAuto.size() < 4;i++){
                values.put(AUTO_COLUMN_ID, i);
                values.put(AUTO_COLUMN_NAME, nomeAuto.get(i));
                values.put(AUTO_COLUMN_PLACA, placaAuto.get(i));
                values.put(AUTO_COLUMN_TYPE, typeAuto.get(i));
                values.put(AUTO_COLUMN_DISPONIVEL, 0);
                db.insert(AUTO_TABLE_NAME,"",values);
            }

        } finally {
            db.close();
        }
    }

    public ArrayList<Automoveis> getAutoByType(String type){
        ArrayList<Automoveis> autos = new ArrayList<>();
        String query = "SELECT * FROM "+AUTO_TABLE_NAME+" where type = '"+type+"'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        try {
            Automoveis automoveis = null;
            if (cursor.moveToFirst()) {
                do {
                    automoveis = new Automoveis();
                    automoveis.id = cursor.getString(cursor.getColumnIndex(AUTO_COLUMN_ID));
                    automoveis.name = cursor.getString(cursor.getColumnIndex(AUTO_COLUMN_NAME));
                    automoveis.placa = cursor.getString(cursor.getColumnIndex(AUTO_COLUMN_PLACA));
                    automoveis.type = cursor.getString(cursor.getColumnIndex(AUTO_COLUMN_TYPE));
                    automoveis.disponivel = cursor.getInt(cursor.getColumnIndex(AUTO_COLUMN_DISPONIVEL));
                    autos.add(automoveis);
                } while (cursor.moveToNext());
            }
            return autos;
        }finally {
            db.close();
        }
    }
}
