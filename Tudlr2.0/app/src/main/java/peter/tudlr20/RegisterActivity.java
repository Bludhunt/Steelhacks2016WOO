package peter.tudlr20;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterActivity extends AppCompatActivity {

    public final static String FIRST_NAME = "com.peter.tudlr20.FIRST_NAME";
    public final static String LAST_NAME = "com.peter.tudlr20.LAST_NAME";
    public final static String EMAIL = "com.peter.tudlr20.EMAIL";
    public final static String USERNAME = "com.peter.tudlr20.USERNAME";
    public final static String PASSWORD = "com.peter.tudlr20.PASSWORD";


    Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void next(View view){
        EditText editFirstName = (EditText) findViewById(R.id.editFirstName);
        EditText editLastName = (EditText) findViewById(R.id.editLastName);
        EditText editEmail = (EditText) findViewById(R.id.editEmailRegister);
        EditText editUsername = (EditText) findViewById(R.id.editUsername);
        EditText editPassword = (EditText) findViewById(R.id.editPasswordRegister);
        EditText editPassword2 = (EditText) findViewById(R.id.editPasswordRegister2);

        String firstName = editFirstName.getText().toString();
        String lastName = editLastName.getText().toString();
        String email = editEmail.getText().toString();
        if(!(email.endsWith("@pitt.edu")||email.endsWith("@pitt.edu "))){
            TextView message = (TextView) findViewById(R.id.registerMessage1);
            message.setText("A University of Pittsburgh email account is required");
            return;
        }
        String username = editUsername.getText().toString();
        String password = editPassword.getText().toString();
        String password2 = editPassword2.getText().toString();
        if(!password.equals(password2)){
            TextView message = (TextView) findViewById(R.id.registerMessage1);
            message.setText("Passwords do not match!");
            return;
        } else if(firstName.isEmpty()) {
            TextView message = (TextView) findViewById(R.id.registerMessage1);
            message.setText("First name required!");
            return;
        } else if(lastName.isEmpty()) {
            TextView message = (TextView) findViewById(R.id.registerMessage1);
            message.setText("Last name required!");
            return;
        } else if(username.isEmpty()) {
            TextView message = (TextView) findViewById(R.id.registerMessage1);
            message.setText("Username required!");
            return;
        } else if(password.isEmpty()) {
            TextView message = (TextView) findViewById(R.id.registerMessage1);
            message.setText("Password required!");
            return;
        }


        Profile.list.add(new Profile(firstName, lastName, email, password, username));
        Intent intent = new Intent(this, RegisterActivity2.class);
        intent.putExtra(EMAIL, email);
        startActivity(intent);
    }
}
