package com.josepvictorr.tugas_uas_akb_genap_2021_10118369.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.josepvictorr.tugas_uas_akb_genap_2021_10118369.R;

public class DetailActivityWisata1 extends AppCompatActivity {
    TextView tvHargaWisata1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata1);

        tvHargaWisata1 = findViewById(R.id.tvHargaWisata1);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            tvHargaWisata1.setText(bundle.getString("harga"));
        }

    }
}