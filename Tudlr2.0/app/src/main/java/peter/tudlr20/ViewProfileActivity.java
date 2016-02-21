package peter.tudlr20;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ViewProfileActivity extends AppCompatActivity {

    Context ctx = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);

        Intent intent = getIntent();
        String email = intent.getStringExtra(LoginActivity.EMAIL);
        //String password = intent.getStringExtra(LoginActivity.PASSWORD);

        /*DatabaseOperations op = new DatabaseOperations(ctx);
        Cursor CR = op.getInformation(op);
        CR.moveToFirst();
        boolean loginStatus = false;
        String NAME = "";
        do{
            if(email.equals(CR.getString(0))){
                loginStatus = true;
                String name = CR.getString(0);
                String username = CR.getString(1);
                String
            }
        }while(CR.moveToNext());*/

        //TODO: Get this stuff from the database instead of it being hardcoded

        String name = "Andrew";//intent.getStringExtra(RegisterActivity.FIRST_NAME) + " " + intent.getStringExtra(RegisterActivity.LAST_NAME);
        String username = "jokesman13";//intent.getStringExtra(RegisterActivity.USERNAME);
        String aboutMe = "You played yo'self";//intent.getStringExtra(RegisterActivity.ABOUT_ME);
        String strengths = "Jokes";//intent.getStringExtra(RegisterActivity.STRENGTHS);
        String weaknesses = "Playin' myself";//intent.getStringExtra(RegisterActivity.WEAKNESSES);

        TextView nameText = (TextView) findViewById(R.id.profile_name);
        TextView usernameText = (TextView) findViewById(R.id.profile_username);
        TextView aboutText = (TextView) findViewById(R.id.profile_about);
        TextView strengthsText = (TextView) findViewById(R.id.profile_strengths);
        TextView weaknessText = (TextView) findViewById(R.id.profile_weaknesses);
        TextView emailText = (TextView) findViewById(R.id.profile_email);
        nameText.setText(name);
        nameText.setTextSize(25);
        usernameText.setText(username);
        usernameText.setTextSize(25);
        aboutText.setText(aboutMe);
        aboutText.setTextSize(20);
        strengthsText.setText(strengths);
        strengthsText.setTextSize(20);
        weaknessText.setText(weaknesses);
        weaknessText.setTextSize(20);
        emailText.setText(email);
        emailText.setTextSize(25);
    }
}
