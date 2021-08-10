package com.josepvictorr.tugas_uas_akb_genap_2021_10118369.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.josepvictorr.tugas_uas_akb_genap_2021_10118369.R;
import com.josepvictorr.tugas_uas_akb_genap_2021_10118369.model.Wisata1;
import com.josepvictorr.tugas_uas_akb_genap_2021_10118369.wisata.WisataFragment1;

public class Wisata1ViewHolder extends RecyclerView.ViewHolder {
    public TextView tvPreviewWisata;
    public ImageView ivPreviewWisata;

    public Wisata1ViewHolder(View itemView) {
        super(itemView);
        tvPreviewWisata = itemView.findViewById(R.id.tvPreviewWisata1);
        ivPreviewWisata = itemView.findViewById(R.id.ivPreviewWisata1);
    }

    public void bindToWisata1 (Wisata1 wisata1){
        tvPreviewWisata.setText(wisata1.nama_tempat);
        Glide.with(itemView)
                .load(wisata1.gambar_tempat)
                .into(ivPreviewWisata);
    }
}
