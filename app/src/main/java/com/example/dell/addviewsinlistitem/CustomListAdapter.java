package com.example.dell.addviewsinlistitem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dell on 2/4/2016.
 */
public class CustomListAdapter extends BaseExpandableListAdapter {

    ArrayList<ListItemModel> groupItem;

    GroupViewHolder groupViewHolder;
    ChildViewHolder childViewHolder;

    Context mContext;

    public LayoutInflater minflater;

    public CustomListAdapter(Context context, ArrayList<ListItemModel> groupItem) {
        this.mContext = context;
        this.groupItem = groupItem;
    }

    public void setInflater(LayoutInflater mInflater) {
        this.minflater = mInflater;
    }

    @Override
    public int getGroupCount() {
        return groupItem.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return groupItem.get(i).getArrayList().size();
    }

    @Override
    public Object getGroup(int i) {
        return groupItem.get(i);
    }

    @Override
    public Object getChild(int i, int i2) {
        return groupItem.get(i).getArrayList().get(i2);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            groupViewHolder = new GroupViewHolder();
            convertView = minflater.inflate(R.layout.list_header, null);
            groupViewHolder.tvTitle = (TextView) convertView.findViewById(R.id.title);
            groupViewHolder.btnAdd = (Button) convertView.findViewById(R.id.addEdittext);
            convertView.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        ExpandableListView eLV = (ExpandableListView) parent;
        eLV.expandGroup(groupPosition);

        groupViewHolder.tvTitle.setText(groupItem.get(groupPosition).getTitle());
        groupViewHolder.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                groupItem.get(groupPosition).getArrayList().add(new EdittextValues(""));
                getChildrenCount(groupPosition);
                notifyDataSetChanged();
            }
        });

        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            childViewHolder = new ChildViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_row, null);

            childViewHolder.et = (EditText) convertView.findViewById(R.id.edittext);

            convertView.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }

        if (!groupItem.get(groupPosition).getArrayList().get(childPosition).getValue().equals(""))
            childViewHolder.et.setText(groupItem.get(groupPosition).getArrayList().get(childPosition).getValue());
        else
            childViewHolder.et.setText("");

        childViewHolder.et.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    final EditText Caption = (EditText) v;
                    groupItem.get(groupPosition).getArrayList().get(childPosition).setValue(Caption.getText().toString());
                }
            }
        });

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i2) {
        return false;
    }

    private class GroupViewHolder {
        public TextView tvTitle;
        public Button btnAdd;
    }

    private class ChildViewHolder {
        public EditText et;
    }

}
