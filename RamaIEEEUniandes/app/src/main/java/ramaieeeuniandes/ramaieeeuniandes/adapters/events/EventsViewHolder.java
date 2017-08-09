package ramaieeeuniandes.ramaieeeuniandes.adapters.events;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import ramaieeeuniandes.ramaieeeuniandes.R;
import ramaieeeuniandes.ramaieeeuniandes.activities.ActivityRamaMain;
import ramaieeeuniandes.ramaieeeuniandes.adapters.RoundImage;
import ramaieeeuniandes.ramaieeeuniandes.concept.Event;

/**
 * Created by juanm on 26/07/2017.
 */

public class EventsViewHolder extends RecyclerView.ViewHolder {

    private LinearLayout linearLayout;
    private TextView name;
    private TextView date;
    private TextView capacity;
    private ImageView image;
    private ImageView chapterImage;
    private View view;

    public EventsViewHolder(View v) {
        super(v);
        view = v;
        name = (TextView) v.findViewById(R.id.eventName);
        date = (TextView) v.findViewById(R.id.eventDate);
        capacity = (TextView) v.findViewById(R.id.eventCapacity);
        image = (ImageView) v.findViewById(R.id.eventImage);
        chapterImage = (ImageView) v.findViewById(R.id.chapterImage);
        linearLayout = (LinearLayout) v.findViewById(R.id.eventListing);
    }

    public void bind(Event event, final int position) {
        name.setText(event.getName());

        String dDate = new SimpleDateFormat("dd/MM/yyyy").format(event.getDate());
        date.setText(dDate);

        capacity.setText(""+event.getCapacity());
        image.setImageResource(event.getImage());

        Bitmap bm = BitmapFactory.decodeResource(view.getResources(),event.getChapterImage());
        RoundImage roundedImage = new RoundImage(bm);
        chapterImage.setImageDrawable(roundedImage);

        linearLayout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if(view.getContext()instanceof ActivityRamaMain){
                    ActivityRamaMain main = (ActivityRamaMain) view.getContext();
                    main.startEventDetail(position);
                }
            }
        });
    }

}
