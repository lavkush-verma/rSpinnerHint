package com.lk.rspinnerhint;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * @author LVerma
 *
 */
public class RSpinnerAdapter extends ArrayAdapter<String> {
    public RSpinnerAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View view = null;
        // If this is the initial dummy entry, make it hidden
        if (position == 0) {
            final TextView textView = new TextView(getContext());
            textView.setHeight(0);
            textView.setVisibility(View.GONE);
            view = textView;
        } else // Pass convertView as null to prevent reuse of special case views
            view = super.getDropDownView(position, null, parent);

        // Hide scroll bar because it appears sometimes unnecessarily, this does not prevent scrolling
        parent.setVerticalScrollBarEnabled(false);
        return view;
    }
}
