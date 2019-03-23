package com.example.a18314.my_sx2.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a18314.my_sx2.Bean.Food;
import com.example.a18314.my_sx2.Present.Bride;
import com.example.a18314.my_sx2.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements UpdateData {

    private Bride bride;
    private XRecyclerView xrecyclerview;
    private ArrayList<String> FoodTitleData = new ArrayList<>();
    private ArrayList<String> FoodImageData = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fresco.initialize(this);
        xrecyclerview = (XRecyclerView) findViewById(R.id.xrecyclerview);
        bride = new Bride(this);
        bride.senddata("ios/cf/dish_list.php?stage_id=1&limit=20&page=1");
        xrecyclerview.setLayoutManager(new LinearLayoutManager(this));
        xrecyclerview.setAdapter(new Myadapter());
    }

    @Override
    public void RefreshData(Food.data[] data) {
        for (int i = 0; i < data.length; i++) {
            FoodImageData.add(data[i].pic);
            FoodTitleData.add(data[i].title);
        }
    }

    class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewHolder> {


        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item, null);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.image.setImageURI(FoodImageData.get(position));
            holder.title.setText(FoodTitleData.get(position));
        }

        @Override
        public int getItemCount() {
            return FoodTitleData.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            private SimpleDraweeView image;
            private TextView title;

            public MyViewHolder(View itemView) {
                super(itemView);
                image = itemView.findViewById(R.id.image);
                title = itemView.findViewById(R.id.title);
            }
        }
    }
}


