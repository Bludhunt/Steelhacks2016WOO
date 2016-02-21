package peter.tudlr20;

/**
 * Created by Peter on 2/21/2016.
 */
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Andraws on 2/20/16.
 */
public class DevicePageAdaptar extends FragmentPagerAdapter {
    String[] aboutTutor;
    String[] name_stuff;
    String[] names;

    public DevicePageAdaptar(FragmentManager fm, Context context) {
        super(fm);

        Resources resources = context.getResources();
        name_stuff = resources.getStringArray(R.array.names_stuff);
        Resources resources1 = context.getResources();
        aboutTutor = resources1.getStringArray(R.array.about_tutor);



    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putString(FragmantStuff.DescriptionKey, name_stuff[position]);
        bundle.putString(FragmantStuff.AboutKey, aboutTutor[position]);
        bundle.putInt(FragmantStuff.ImageIDKey, getProfileImage(position));

        FragmantStuff deviceFragment = new FragmantStuff();
        deviceFragment.setArguments(bundle);

        return deviceFragment;
    }
    private int getProfileImage(int position){
        int id = 0;
        switch(position)
        {
            case 0:
                id = R.mipmap.ic_launcher;
                break;
            case 1:
                id = R.mipmap.tyler_pic;
                break;
            case 2:
                id = R.mipmap.john_pic;
                break;
        }
        return id;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return name_stuff[position];
    }
    public CharSequence getPageTitle2(int position) {
        return aboutTutor[position];
    }

    @Override
    public int getCount() {
        return name_stuff.length;
    }
}
