package com.itcast.listview;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private String[] names = {"桌子","苹果","蛋糕","线衣","围巾","台球杆","苹果18","苹果手表","奔驰E300",};

    private String[] prices = {"价格：1800元","价格：38元","价格：300元","价格：350元","价格：100元","价格：1888元","价格：15999元","价格：2999元","价格：388888元",};

    private int[] images = {R.drawable.table,R.drawable.apple,R.drawable.cake,R.drawable.wireclothes,R.drawable.scarf,R.drawable.cue,R.drawable.phone,R.drawable.watch,R.drawable.car};

    List<Integer> showList = new ArrayList<>();
    MyBaseAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        for(int i = 0; i < names.length; i++){
            showList.add(i);
        }

        ListView listView = findViewById(R.id.lv_shop);
        myAdapter = new MyBaseAdapter();
        listView.setAdapter(myAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int realIndex = showList.get(position);
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("index", realIndex);
                startActivity(intent);
            }
        });


        EditText etSearch = findViewById(R.id.et_search);
        Button btnSearch = findViewById(R.id.btn_search);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = etSearch.getText().toString().trim();
                showList.clear();
                if(key.isEmpty()){

                    for(int i = 0; i < names.length; i++){
                        showList.add(i);
                    }
                }else{

                    for(int i = 0; i < names.length; i++){
                        if(names[i].contains(key)){
                            showList.add(i);
                        }
                    }
                }
                myAdapter.notifyDataSetChanged();
            }
        });

    }


    class MyBaseAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return showList.size();
        }

        @Override
        public Object getItem(int position) {
            return showList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            View itemView = inflater.inflate(R.layout.list_item,parent,false);

            int realPos = showList.get(position);
            ImageView img = itemView.findViewById(R.id.iv_goods);
            TextView tvName = itemView.findViewById(R.id.tv_name);
            TextView tvPrice = itemView.findViewById(R.id.tv_price);

            img.setImageResource(images[realPos]);
            tvName.setText(names[realPos]);
            tvPrice.setText(prices[realPos]);

            return itemView;
        }
    }

}