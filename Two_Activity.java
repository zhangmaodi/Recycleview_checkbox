package test.bwie.com.recycleview_checkbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

public class Two_Activity extends AppCompatActivity {

    ListView listv;
    private List<JavaBean> nlist;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_);
             initView();
        Intent it = getIntent();
        nlist = (List<JavaBean>) it.getSerializableExtra("list");

        adapter = new MyAdapter(Two_Activity.this,  nlist);
        listv.setAdapter(adapter);
    }

    private void initView() {
    listv= (ListView) findViewById(R.id.NListv);
    }


}
