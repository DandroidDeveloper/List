package chaos.list;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class TodoListSQLHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "chaos.list.db";
    public static final String TABLE_NAME = "LIST";
    public static final String COL1_TASK = "item";
    public static final String _ID = BaseColumns._ID;

    public TodoListSQLHelper(Context context) {
        //1 is todo list database version
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqlDB) {
        String createTodoListTable = "CREATE TABLE " + TABLE_NAME + " ( _id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL1_TASK + " TEXT)";
        sqlDB.execSQL(createTodoListTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqlDB, int i, int i2) {
        sqlDB.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqlDB);
    }
}
