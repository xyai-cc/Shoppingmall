package com.itcast.listview;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    private String[] names = {"桌子","苹果","蛋糕","线衣","围巾","台球杆","苹果18","苹果手表","奔驰E300",};
    private String[] prices = {"价格：1800元","价格：38元","价格：300元","价格：350元","价格：100元","价格：1888元","价格：15999元","价格：2999元","价格：388888元",};

    private int[] images = {R.drawable.table,R.drawable.apple,R.drawable.cake,R.drawable.wireclothes,R.drawable.scarf,R.drawable.cue,R.drawable.phone,R.drawable.watch,R.drawable.car};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView img = findViewById(R.id.detail_img);
        TextView tvName = findViewById(R.id.detail_name);
        TextView tvPrice = findViewById(R.id.detail_price);
        Button btnBack = findViewById(R.id.btn_back);
        Button btnAddCart=findViewById(R.id.btn_add_cart);

        int pos = getIntent().getIntExtra("index",0);

        img.setImageResource(images[pos]);
        tvName.setText(names[pos]);
        tvPrice.setText(prices[pos]);

        btnAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailActivity.this, "✅已成功加入购物车", Toast.LENGTH_SHORT).show();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
