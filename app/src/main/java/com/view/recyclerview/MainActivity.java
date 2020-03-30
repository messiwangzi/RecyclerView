package com.view.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;

    private List<Huoying> huoyingList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        setListener();
    }

    private void initData()
    {
        huoyingList = new ArrayList<>(7);
        huoyingList.add(new Huoying(1, "千手柱间", "木遁"));
        huoyingList.add(new Huoying(2, "千手扉间", "水遁"));
        huoyingList.add(new Huoying(3, "猿飞日斩", "猿魔"));
        huoyingList.add(new Huoying(4, "波风水门", "飞雷神"));
        huoyingList.add(new Huoying(5, "千手纲手", "百豪之术"));
        huoyingList.add(new Huoying(6, "旗木卡卡西", "雷切"));
        huoyingList.add(new Huoying(7, "漩涡鸣人", "螺旋丸"));
    }

    private void initView()
    {
        recyclerView = findViewById(R.id.rv_successive_dynasties_huoying);
        //1. 线性布局
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //2. 网格布局
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        //3. 瀑布流
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerAdapter = new RecyclerAdapter(huoyingList);
        recyclerView.setAdapter(recyclerAdapter);
//        recyclerView.addItemDecoration(new RecyclerItemDecoration(this));
    }

    private void setListener()
    {

    }
}
