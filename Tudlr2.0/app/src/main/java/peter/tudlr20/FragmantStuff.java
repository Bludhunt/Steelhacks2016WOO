package peter.tudlr20;

/**
 * Created by Peter on 2/21/2016.
 */
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Andraws on 2/20/16.
 */
public class FragmantStuff extends android.support.v4.app.Fragment{

    public static final String ImageIDKey = "imagekey";
    public static final String DescriptionKey = "descriptionKey";
    public static final String AboutKey = "aboutKey";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragmant_desc, container, false);


        Bundle bundle = getArguments();

        if(bundle!=null){
            int imageID = bundle.getInt(ImageIDKey);
            String description = bundle.getString(DescriptionKey);
            String random = bundle.getString(AboutKey);
            setValues(view, imageID, description, random);
        }
        return view;
    }
    private void setValues(View view, int imageID, String description, String random){
        ImageView imageView = (ImageView)view.findViewById(R.id.imageViewDevice);
        imageView.setImageResource(imageID);

        TextView textView = (TextView) view.findViewById(R.id.textViewDevice);
        textView.setText(description);

        TextView textView3 = (TextView) view.findViewById(R.id.textView2);
        textView3.setText(random);
    }
}
