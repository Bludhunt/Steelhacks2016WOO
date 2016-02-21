package peter.tudlr20;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    public final static String EMAIL = "com.peter.tudlr20.EMAIL";
    public final static String PASSWORD = "com.peter.tudlr20.PASSWORD";
    String email, password;
    Context ctx = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Profile andrew = new Profile("Andrew", "Masih", "anm226@pitt.edu", "jokes", "anm226");
        andrew.addMoreInfo("CS", "Co-founder", "Math", "Computer Science");
        Profile.list.add(andrew);
        Profile peter = new Profile("Peter", "Mul", "pem42@pitt.edu", "jokes", "pem42");
        andrew.addMoreInfo("CS","Founder","Computer Science","Religion");
        Profile.list.add(peter);
        Profile john = new Profile("John", "Ha", "jlh238@pitt.edu", "jokes", "jlh238");
        john.addMoreInfo("CS", "Janitor", "Math", "Computer Science");
        Profile.list.add(john);
        Profile tyler = new Profile("Tyler", "Big RAM", "aham@pitt.edu", "jokes", "lumberinJack");
        tyler.addMoreInfo("CS", "Dolphin", "Chemistry", "Physics");
        Profile.list.add(tyler);

        //root.setBackgroundColor(getResources().getColor(android.R.color.red));
    }

    public void logIn(View view) {
        EditText editEmail = (EditText) findViewById(R.id.editEmail);
        EditText editPassword = (EditText) findViewById(R.id.editPassword);
        String email = editEmail.getText().toString();

        //TODO: Check database for the email


        /*if(loginStatus){
            finish();
        }*/

        if(!(email.endsWith("@pitt.edu")||email.endsWith("@pitt.edu "))){
            TextView message = (TextView) findViewById(R.id.loginMessage);
            message.setText("A University of Pittsburgh email account is required");
            return;
        }
        String password = editPassword.getText().toString();
        if(password.isEmpty()){
            TextView message = (TextView) findViewById(R.id.loginMessage);
            message.setText("Please enter your password");
            return;
        }


        //TODO: Compare password to database
        if(Profile.find(email) == null){
            TextView message = (TextView) findViewById(R.id.loginMessage);
            message.setText("Invalid email, please register");
            return;
        } else {
            Profile p = Profile.find(email);
            if(!p.password.equals(password)){
                TextView message = (TextView) findViewById(R.id.loginMessage);
                message.setText("Wrong password, please try again"+p.password+password);
                return;
            }
        }

        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra(EMAIL, email);
        startActivity(intent);
    }

    public void register(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
