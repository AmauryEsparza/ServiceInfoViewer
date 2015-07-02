package com.example.amauryesparza.serviceinfoviewer;

import android.app.ActivityManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ArrayAdapter<RunningServiceWrapper> mServices;
    private ListView mServiceList;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mServices = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1);
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mServiceList = (ListView) rootView.findViewById(R.id.service_list);
        mServiceList.setAdapter(mServices);
        mServiceList.setOnItemClickListener(this);
        return rootView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //  TODO: Return here and hook this up
    }

    private class RunningServiceWrapper{

        private ActivityManager.RunningServiceInfo mInfo;

        public RunningServiceWrapper(ActivityManager.RunningServiceInfo info){
            this.mInfo = info;
        }

        public ActivityManager.RunningServiceInfo getInfo(){
            return mInfo;
        }

        public String toString(){
            return mInfo.service.flattenToShortString();
        }
    }
}
