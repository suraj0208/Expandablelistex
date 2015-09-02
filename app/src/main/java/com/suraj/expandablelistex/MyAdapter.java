package com.suraj.expandablelistex;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by suraj on 30/8/15.
 */

public class MyAdapter extends BaseExpandableListAdapter  {

    private Context _context;
    private static int count=1;
    private List<String> _listDataHeader;

    public MyAdapter(Context context, List<String> listDataHeader,
                                 HashMap<String, List<String>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return _listDataHeader.get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String text = _listDataHeader.get(groupPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.items, null);
        }

        final TextView tvdisp = (TextView) convertView
                .findViewById(R.id.tvdisp);

        tvdisp.setText(text);

        EditText projectname = (EditText) convertView
                .findViewById(R.id.projectname);

        Button button = (Button) convertView.findViewById(R.id.btnsave);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //_context.startActivity(new Intent(_context,MainActivity.class));
                count++;
                MyAdapter.this.notifyDataSetChanged();
                MyAdapter.this.notifyDataSetInvalidated();
                //Toast.makeText(_context.getApplicationContext(), "clicked:" + tvdisp.getText(),Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return count;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.day_group, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.dayname);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
