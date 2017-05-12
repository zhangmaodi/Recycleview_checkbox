package test.bwie.com.recycleview_checkbox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * date:2017/5/12
 * author:张毛第
 * function:
 */

public class MyAdapter extends BaseAdapter {
    Context context;
    List<JavaBean> list;


    public MyAdapter(Context context, List<JavaBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list!=null?list.size():0;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder_ viewHolder_;
        if (convertView == null) {
            convertView= LayoutInflater.from(context).inflate(R.layout.baseadapter,null);
            viewHolder_=new ViewHolder_();
            viewHolder_.Num_ada= (TextView) convertView.findViewById(R.id.Num_Ada);
            convertView.setTag(viewHolder_);
        }else {
            viewHolder_= (ViewHolder_) convertView.getTag();
        }
        viewHolder_.Num_ada.setText(list.get(position).getNum());
        return convertView;
    }

    class ViewHolder_{
        TextView Num_ada;
    }
}
