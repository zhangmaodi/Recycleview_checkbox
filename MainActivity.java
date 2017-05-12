package test.bwie.com.recycleview_checkbox;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<JavaBean> slist = new ArrayList<>();
    RecyclerView Rv;
    Button QuanBtn,NoBtn,FanBtn,QueDing;
    private MyRvAdapter adapter;
    ArrayList<JavaBean> nlist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        Rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        adapter = new MyRvAdapter(MainActivity.this,slist);
        Rv.setAdapter(adapter);
        Rv.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                    outRect.set(20,20,20,20);
            }
        });





        QueDing.setOnClickListener(new View.OnClickListener() {

            private String num;

            @Override
            public void onClick(View v) {
                for (JavaBean bean : slist) {
                    if (bean.getFalg()){
                        num = bean.getNum();
                        Log.e("sss", num);
                        nlist.add(bean);
                    }

                }
                Intent it = new Intent(MainActivity.this,Two_Activity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("list",nlist);
                it.putExtras(bundle);
                startActivity(it);
                nlist.clear();

            }
        });

        QuanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (JavaBean bean : slist) {

                        bean.setFalg(true);

                }
                adapter.notifyDataSetChanged();
            }

        });

        NoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (JavaBean bean : slist) {

                    bean.setFalg(false);

                }
                adapter.notifyDataSetChanged();
            }
        });

        FanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (JavaBean bean : slist) {
                    if (bean.getFalg()){
                        bean.setFalg(false);
                    }else {
                        bean.setFalg(true);
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });
    }


    private void initData() {
        for (int i=0;i<100;i++){
            JavaBean bean = new JavaBean();
            bean.setNum(""+i);
            bean.setFalg(false);
            slist.add(bean);
        }
    }


    private void initView() {
        Rv= (RecyclerView) findViewById(R.id.Rv);
        QuanBtn= (Button) findViewById(R.id.Quan);
        NoBtn= (Button) findViewById(R.id.NoQuan);
        FanBtn= (Button) findViewById(R.id.Fan);
        QueDing= (Button) findViewById(R.id.QueDing);
    }
}
