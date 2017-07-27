package ramaieeeuniandes.ramaieeeuniandes.adapters.my_events;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ramaieeeuniandes.ramaieeeuniandes.R;
import ramaieeeuniandes.ramaieeeuniandes.concept.Event;

/**
 * Created by juanm on 26/07/2017.
 */

public class MyEventsRecyclerViewAdapter extends RecyclerView.Adapter{

    private List<Event> events;

    public MyEventsRecyclerViewAdapter(List<Event> events) {
        this.events = events;
    }

    @Override
    public int getItemViewType(int position){
        return position;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if(events.size()!=0) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_events_view, parent, false);
            return new MyEventsViewHolder(view);
        }else{
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.no_data_available_view, parent, false);
            return new MyEventsNoDataViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(events.size()!=0){
            MyEventsViewHolder mHolder = (MyEventsViewHolder) holder;
            Event event = events.get(position);
            mHolder.bind(event,position);
        }else{
            MyEventsNoDataViewHolder mHolder = (MyEventsNoDataViewHolder) holder;
            mHolder.bind();
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return events.size()==0?1:events.size();
    }
}
