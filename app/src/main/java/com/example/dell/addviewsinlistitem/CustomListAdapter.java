package com.example.dell.addviewsinlistitem;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by dell on 2/4/2016.
 */
public class CustomListAdapter extends BaseAdapter {

    ArrayList<ListItemModel> items;

    ViewHolder holder;

    Context mContext;

    ArrayList<EdittextValues> etValues;

    int i = 0;

    public CustomListAdapter(Context context, ArrayList<ListItemModel> items, ArrayList<EdittextValues> etValues) {
        this.mContext = context;
        this.items = items;
        this.etValues = etValues;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.list_row, null);

            holder.tvTitle = (TextView) convertView.findViewById(R.id.title);
            holder.btnAdd = (Button) convertView.findViewById(R.id.addEdittext);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvTitle.setText(items.get(position).getTitle());

        final View finalConvertView = convertView;

        holder.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                etValues.add(new EdittextValues(position, i, ""));

                LinearLayout mLayout = (LinearLayout) finalConvertView.findViewById(R.id.llChild);
                LinearLayout.LayoutParams mparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);

                final EditText myEditText = new EditText(mContext);
                mparams.setMargins(46, 3, 46, 3);
                myEditText.setLayoutParams(mparams);
                mLayout.setOrientation(LinearLayout.VERTICAL);
                myEditText.setPadding(10, 10, 10, 10);
                myEditText.setSingleLine(true);
                myEditText.setId(i);
                myEditText.setHeight(72);
                myEditText.setTextSize(15);
                myEditText.setFocusableInTouchMode(true);
                myEditText.setFocusable(true);
                myEditText.setHint("Type");
                mLayout.addView(myEditText);

                myEditText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        etValues.get(myEditText.getId()).setValue(charSequence+"");
                        Toast.makeText(mContext, etValues.get(myEditText.getId()).getValue(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });

                i++;

            }
        });

        return convertView;
    }

    private class ViewHolder {
        public TextView tvTitle;
        public Button btnAdd;
    }

}
