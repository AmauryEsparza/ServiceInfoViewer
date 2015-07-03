package com.example.amauryesparza.serviceinfoviewer;


import android.app.ActivityManager;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ServiceDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ServiceDetailFragment extends Fragment {
    private static final String ARG_SERVICE_INFO = "srv_info";

    private ActivityManager.RunningServiceInfo mServiceInfo;

    public static ServiceDetailFragment newInstance(ActivityManager.RunningServiceInfo info) {
        ServiceDetailFragment fragment = new ServiceDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_SERVICE_INFO, info);
        fragment.setArguments(args);
        return fragment;
    }

    public ServiceDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mServiceInfo = getArguments().getParcelable(ARG_SERVICE_INFO);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_service_details, container, false);
        View cnRow;
        TextView title;
        TextView data;

        //Component Name
        cnRow = rootView.findViewById(R.id.component_name);
        title = (TextView) cnRow.findViewById(R.id.title);
        data = (TextView) cnRow.findViewById(R.id.data);
        title.setText(R.string.component_name_title);
        data.setText(mServiceInfo.service.flattenToShortString());

        //Process Name
        cnRow = rootView.findViewById(R.id.process_name);
        title = (TextView) cnRow.findViewById(R.id.title);
        data = (TextView) cnRow.findViewById(R.id.data);
        title.setText(R.string.process_name);
        data.setText(mServiceInfo.service.flattenToShortString());

        //PID
        cnRow = rootView.findViewById(R.id.pid);
        title = (TextView) cnRow.findViewById(R.id.title);
        data = (TextView) cnRow.findViewById(R.id.data);
        title.setText(R.string.pid_title);
        data.setText(mServiceInfo.service.flattenToShortString());

        //UID
        cnRow = rootView.findViewById(R.id.uid);
        title = (TextView) cnRow.findViewById(R.id.title);
        data = (TextView) cnRow.findViewById(R.id.data);
        title.setText(R.string.uid_title);
        data.setText(mServiceInfo.service.flattenToShortString());

        //Connected clients
        cnRow = rootView.findViewById(R.id.connected_clients);
        title = (TextView) cnRow.findViewById(R.id.title);
        data = (TextView) cnRow.findViewById(R.id.data);
        title.setText(R.string.conn_client_title);
        data.setText(mServiceInfo.service.flattenToShortString());

        //Active time
        cnRow = rootView.findViewById(R.id.active_time);
        title = (TextView) cnRow.findViewById(R.id.title);
        data = (TextView) cnRow.findViewById(R.id.data);
        title.setText(R.string.active_time_title);
        data.setText(mServiceInfo.service.flattenToShortString());

        return rootView;
    }


}
