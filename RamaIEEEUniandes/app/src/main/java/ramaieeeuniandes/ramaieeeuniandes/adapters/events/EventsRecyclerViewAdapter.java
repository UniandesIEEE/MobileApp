package ramaieeeuniandes.ramaieeeuniandes.adapters.events;

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

public class EventsRecyclerViewAdapter extends RecyclerView.Adapter{

    private List<Event> events;

    public EventsRecyclerViewAdapter(List<Event> events) {
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
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.events_view, parent, false);
            return new EventsViewHolder(view);
        }else{
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.no_data_available_view, parent, false);
            return new EventsNoDataViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(events.size()!=0){
            EventsViewHolder mHolder = (EventsViewHolder) holder;
            Event event = events.get(position);
            mHolder.bind(event,position);
        }else{
            EventsNoDataViewHolder mHolder = (EventsNoDataViewHolder) holder;
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
