package peter.tudlr20;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Peter on 2/21/2016.
 */
public class Profile {
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String username;
    public String major;
    public String year;
    public String strength;
    public String weakness;
    public static ArrayList<Profile> list = new ArrayList<Profile>();

    public static DevicePageAdaptar adaptar;

    public Profile(String name, String lastname, String email, String password, String username){
        firstName = name;
        this.lastName = lastname;
        this.email = email;
        this.password = password;
        this.username = username;

    }

    public void addProfile(String name, String lastname, String email, String password, String username){
        firstName = name;
        this.lastName = lastname;
        this.email = email;
        this.password = password;
        this.username = username;
    }
    public void addMoreInfo(String major, String year, String strength, String weakness){
        this.major = major;
        this.year = year;
        this.strength = strength;
        this.weakness = weakness;
    }

    public static Profile find(String email) {
        for(Profile p : list){
            if(p.email.equals(email)){
                return p;
            }
        }
        return null;
    }

    public static ArrayList<Profile> match(String weakness){
        ArrayList<Profile> john = new ArrayList<Profile>();
        for (Profile p : list){
            if(p.strength.equals(weakness)){
                john.add(p);
            }
        }
        return john;
    }
}
