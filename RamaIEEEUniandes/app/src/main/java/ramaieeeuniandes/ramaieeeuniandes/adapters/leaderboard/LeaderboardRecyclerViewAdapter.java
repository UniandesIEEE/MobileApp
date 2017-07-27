package ramaieeeuniandes.ramaieeeuniandes.adapters.leaderboard;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ramaieeeuniandes.ramaieeeuniandes.R;
import ramaieeeuniandes.ramaieeeuniandes.concept.User;

/**
 * Created by juanm on 26/07/2017.
 */

public class LeaderboardRecyclerViewAdapter extends RecyclerView.Adapter{

    private List<User> users;

    public LeaderboardRecyclerViewAdapter(List<User> users) {
        this.users = users;
    }

    @Override
    public int getItemViewType(int position){
        return position;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if(users.size()!=0) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.leaderboard_view, parent, false);
            return new LeaderboardViewHolder(view);
        }else{
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.no_data_available_view, parent, false);
            return new LeaderboardNoDataViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(users.size()!=0){
            LeaderboardViewHolder mHolder = (LeaderboardViewHolder) holder;
            User user = users.get(position);
            mHolder.bind(user,position);
        }else{
            LeaderboardNoDataViewHolder mHolder = (LeaderboardNoDataViewHolder) holder;
            mHolder.bind();
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return users.size()==0?1:users.size();
    }
}
