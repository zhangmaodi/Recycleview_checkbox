package test.bwie.com.recycleview_checkbox;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * date:2017/5/12
 * author:张毛第
 * function:
 */

public class MyRvAdapter extends RecyclerView.Adapter<MyRvAdapter.ViewHolder>{
    Context context;
    List<JavaBean> slist;

    public MyRvAdapter(Context context, List<JavaBean> slist) {
        this.context = context;
        this.slist = slist;
    }

    @Override
    public MyRvAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.rv_adapter, null);
        ViewHolder viewHolder = new ViewHolder(inflate);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyRvAdapter.ViewHolder holder, final int position) {

        holder.TiaoMu.setText(slist.get(position).getNum());
        holder.checkBox.setChecked(slist.get(position).getFalg());

 holder.checkBox.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         if(slist.get(position).getFalg()){
             slist.get(position).setFalg(false);
         }
         else{
             slist.get(position).setFalg(true);
         }
     }
 });


    }
    public interface onCheckedOnclint{
        void Oncheckedonclick(int position);
    }


    public void MyRvAdapter(MyRvAdapter.onCheckedOnclint onCheckedOnclint) {
        this.onCheckedOnclint = onCheckedOnclint;
    }

    onCheckedOnclint onCheckedOnclint;

    @Override
    public int getItemCount() {
        return slist!=null?slist.size():0;
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        CheckBox checkBox;
        TextView TiaoMu;
        public ViewHolder(View itemView) {
            super(itemView);
        checkBox= (CheckBox) itemView.findViewById(R.id.CheckBox_);
        TiaoMu= (TextView) itemView.findViewById(R.id.TiaoMu);
        }
    }
}
