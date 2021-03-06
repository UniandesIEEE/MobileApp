package ramaieeeuniandes.ramaieeeuniandes.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ramaieeeuniandes.ramaieeeuniandes.R;
import ramaieeeuniandes.ramaieeeuniandes.activities.ActivityRamaMain;
import ramaieeeuniandes.ramaieeeuniandes.adapters.leaderboard.LeaderboardRecyclerViewAdapter;

/**
 * Created by juanm on 26/07/2017.
 */

public class LeaderboardFragment extends Fragment {


    private RecyclerView recyclerView;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public LeaderboardFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment_leaderboard, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LeaderboardRecyclerViewAdapter adapter = new LeaderboardRecyclerViewAdapter(ActivityRamaMain.getUsers());
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_leaderboard);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(true);
    }
}
