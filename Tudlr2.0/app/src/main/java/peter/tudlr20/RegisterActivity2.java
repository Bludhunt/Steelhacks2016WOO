package peter.tudlr20;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class RegisterActivity2 extends AppCompatActivity {

    public final static String MAJOR = "com.peter.tudlr20.MAJOR";
    public final static String YEAR = "com.peter.tudlr20.YEAR";
    public final static String STRENGTH = "com.peter.tudlr20.STRENGTH";
    public final static String WEAKNESS = "com.peter.tudlr20.WEAKNESS";
    public final static String ABOUT_ME = "com.peter.tudlr20.ABOUT_ME";
    public String strength;
    public String weakness;
    public String email;

    Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        Intent intent = getIntent();
        email = intent.getStringExtra(RegisterActivity.EMAIL);
    }

    public void onRadioButtonClicked1(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.cs_strength:
                if (checked) {
                    strength = "Computer Science";
                    break;
                }
            case R.id.math_strength:
                if (checked) {
                    strength = "Math";
                    break;
                }
            case R.id.chem_strength:
                if (checked) {
                    strength = "Chemistry";
                    break;
                }
            case R.id.religion_strength:
                if (checked) {
                    strength = "Religion";
                    break;
                }
            case R.id.physics_strength:
                if (checked) {
                    strength = "Physics";
                    break;
                }
        }
    }

    public void onRadioButtonClicked2(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.cs_weakness:
                if (checked) {
                    weakness = "Computer Science";
                    break;
                }
            case R.id.math_weakness:
                if (checked) {
                    weakness = "Math";
                    break;
                }
            case R.id.chem_weakness:
                if (checked) {
                    weakness = "Chemistry";
                    break;
                }
            case R.id.religion_weakness:
                if (checked) {
                    weakness = "Religion";
                    break;
                }
            case R.id.physics_weakness:
                if (checked) {
                    weakness = "Physics";
                    break;
                }
        }
    }

    public void register(View view){
        EditText editMajor = (EditText) findViewById(R.id.editMajor);
        EditText editYear = (EditText) findViewById(R.id.editYear);

        String major = editMajor.getText().toString();
        String year = editYear.getText().toString();

        Profile p = Profile.find(email);
        p.addMoreInfo(major, year, strength, weakness);

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
