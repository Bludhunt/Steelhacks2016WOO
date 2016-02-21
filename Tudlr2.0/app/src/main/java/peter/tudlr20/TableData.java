package peter.tudlr20;

/**
 * Created by Peter on 2/20/2016.
 */
import android.provider.BaseColumns;

/**
 * Created by shed4_000 on 2/20/2016.
 */
public class TableData {

    public TableData(){

    }//constructor

    public static abstract class TableInfo implements BaseColumns{
        public static final String USER_NAME = "user_name";
        public static final String PASSWORD = "password";
        public static final String FIRST_NAME = "first_name";
        public static final String LAST_NAME = "last_name";
        public static final String EMAIL = "email";
        public static final String MAJOR = "major";
        public static final String YEAR = "year";
        public static final String STRENGTHS = "strengths";
        public static final String WEAKNESSES = "weaknesses";
        public static final String ABOUT_ME = "about_me";
        public static final String TABLE_NAME = "table_info";
        public static final String DATABASE_NAME = "user_info";
    }//tableInfo

}
