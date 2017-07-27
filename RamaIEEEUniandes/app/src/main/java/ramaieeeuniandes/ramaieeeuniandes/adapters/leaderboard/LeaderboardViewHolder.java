package ramaieeeuniandes.ramaieeeuniandes.adapters.leaderboard;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import ramaieeeuniandes.ramaieeeuniandes.R;
import ramaieeeuniandes.ramaieeeuniandes.concept.Event;
import ramaieeeuniandes.ramaieeeuniandes.concept.User;

/**
 * Created by juanm on 26/07/2017.
 */

public class LeaderboardViewHolder extends RecyclerView.ViewHolder {

    private LinearLayout linearLayout;
    private TextView name;
    private TextView score;
    private ImageView image;
    private View view;

    public LeaderboardViewHolder(View v) {
        super(v);
        view = v;
        name = (TextView) v.findViewById(R.id.lbUserName);
        score = (TextView) v.findViewById(R.id.lbUserScore);
        image = (ImageView) v.findViewById(R.id.lbUserImage);
        linearLayout = (LinearLayout) v.findViewById(R.id.lbListing);
    }

    public void bind(User user, final int position) {
        name.setText(user.getName());
        score.setText(""+user.getScore());
        image.setImageResource(user.getImage());

        /*
        linearLayout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if(view.getContext()instanceof InloudMainActivity){
                    InloudMainActivity main = (InloudMainActivity) view.getContext();
                    main.startInvoiceDetail(position);
                }
            }
        });
        */
    }

}
