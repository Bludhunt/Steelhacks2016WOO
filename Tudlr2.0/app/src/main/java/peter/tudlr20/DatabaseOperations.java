package peter.tudlr20;

/**
 * Created by Peter on 2/20/2016.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by shed4_000 on 2/20/2016.
 */
public class DatabaseOperations extends SQLiteOpenHelper  {
    public static final int DATABASE_VERSION = 2;
    public String CREATE_QUERY = "CREATE TABLE "+ TableData.TableInfo.TABLE_NAME+"("+
            TableData.TableInfo.USER_NAME+" ,TEXT"+ TableData.TableInfo.PASSWORD+" TEXT);";

    public DatabaseOperations(Context context){
        super(context, TableData.TableInfo.USER_NAME, null, DATABASE_VERSION);
        Log.d("Database operations", "Database Created");
    }

    @Override
    public void onCreate(SQLiteDatabase sdb){
        sdb.execSQL(CREATE_QUERY);
        Log.d("Database operations", "Table Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){

    }

    public void putInformation(DatabaseOperations dop, String userName, String pass, String EMAIL,
                               String firstName, String lastName){
        SQLiteDatabase SQ = dop.getWritableDatabase();

        ContentValues cv = new ContentValues();
        Log.d("Database operations", "Lalalalalala");
        cv.put(TableData.TableInfo.USER_NAME, userName);
        cv.put(TableData.TableInfo.PASSWORD, pass);
        cv.put(TableData.TableInfo.EMAIL, EMAIL);
        cv.put(TableData.TableInfo.FIRST_NAME, firstName);
        cv.put(TableData.TableInfo.LAST_NAME, lastName);
        long k = SQ.insert(TableData.TableInfo.TABLE_NAME, null, cv);
        SQ.close();

        Log.d("Database operations", "We're goin in raw!");
    }

    public void putInformation2(DatabaseOperations dop, String major, String year, String strengths,
                                String weaknesses, String about){
        SQLiteDatabase SQ = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableData.TableInfo.MAJOR, major);
        cv.put(TableData.TableInfo.YEAR, year);
        cv.put(TableData.TableInfo.STRENGTHS, strengths);
        cv.put(TableData.TableInfo.WEAKNESSES, weaknesses);
        cv.put(TableData.TableInfo.ABOUT_ME, about);
        long k = SQ.insert(TableData.TableInfo.TABLE_NAME, null, cv);
    }

    public Cursor getInformation(DatabaseOperations dop){
        SQLiteDatabase SQ = dop.getReadableDatabase();
        String[] columns = {TableData.TableInfo.USER_NAME, TableData.TableInfo.PASSWORD};
        Cursor CR = SQ.query(TableData.TableInfo.TABLE_NAME, columns, null, null, null, null, null);
        return CR;
    }
}
