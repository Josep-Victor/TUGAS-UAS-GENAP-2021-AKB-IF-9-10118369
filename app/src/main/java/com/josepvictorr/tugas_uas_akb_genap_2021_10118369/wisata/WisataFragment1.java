package com.josepvictorr.tugas_uas_akb_genap_2021_10118369.wisata;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.josepvictorr.tugas_uas_akb_genap_2021_10118369.R;
import com.josepvictorr.tugas_uas_akb_genap_2021_10118369.detail.DetailActivityWisata1;
import com.josepvictorr.tugas_uas_akb_genap_2021_10118369.model.Wisata1;
import com.josepvictorr.tugas_uas_akb_genap_2021_10118369.view.Wisata1ViewHolder;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class WisataFragment1 extends Fragment {

    private DatabaseReference mDatabase;

    List<Wisata1> wisata1List;
    private FirebaseRecyclerAdapter<Wisata1, Wisata1ViewHolder> mAdapter;
    private RecyclerView mRecycler;
    private LinearLayoutManager mManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container
            ,Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_wisata1, container, false);
        mDatabase = FirebaseDatabase.getInstance("https://world-of-bandung-default-rtdb.asia-southeast1.firebasedatabase.app").getReference();
        mRecycler = rootView.findViewById(R.id.list_kota_bandung);

        mManager = new LinearLayoutManager(getActivity());
        mManager.setReverseLayout(true);
        mManager.setStackFromEnd(true);
        mRecycler.setLayoutManager(mManager);

        Query query = getQuery(mDatabase);

        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<Wisata1>()
                .setQuery(query, Wisata1.class)
                .build();

        mAdapter = new FirebaseRecyclerAdapter<Wisata1, Wisata1ViewHolder>(options) {
            @Override
            protected void onBindViewHolder(Wisata1ViewHolder holder, int position, Wisata1 model) {
                holder.bindToWisata1(model);

            }

            @NonNull
            @NotNull
            @Override
            public Wisata1ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                return new Wisata1ViewHolder(inflater.inflate(R.layout.item_list_wisata1, parent, false));
            }
        };
        mAdapter.notifyDataSetChanged();
        mRecycler.setAdapter(mAdapter);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mAdapter != null) {
            mAdapter.startListening();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAdapter != null) {
            mAdapter.stopListening();
        }
    }

    private Query getQuery(DatabaseReference mDatabase){
        Query query = mDatabase.child("kota_bandung");
        return query;
    }
}