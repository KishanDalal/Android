/*
 * Copyright (C) 2017 Google Inc.
 */

package com.example.android.recyclerview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Implements a basic RecyclerView that displays a list of generated words.
 * - Clicking an item marks it as clicked.
 * - Clicking the fab button adds a new word to the list.
 */
public class MainActivity extends AppCompatActivity{


    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    private final LinkedList<String> mWordList = new LinkedList<>();
    private List<Grocery> groceries;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initalizeData();
        // Put initial data into the word list.
        for (int i = 0; i < 3; i++) {
            // Original code: mWordList.addLast("Word " + i)
            mWordList.addLast(String.format(getResources().getString(R.string
                    .word), i));
        }

        // Create recycler view.
        mRecyclerView = (RecyclerView) findViewById(R.id.recycle);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new WordListAdapter(this, groceries);
        // Connect the adapter with the recycler view.
        mRecyclerView.setAdapter(mAdapter);
        // Give the recycler view a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    private  void initalizeData()
    {

        groceries = new ArrayList<>();
        groceries.add(new Grocery("Mango",R.drawable.mango,"$1","1L","3"));
        groceries.add(new Grocery("Apple",R.drawable.apple,"$2","3L","5"));
        groceries.add(new Grocery("Banana",R.drawable.banana,"$4","5L","2"));
    }
}