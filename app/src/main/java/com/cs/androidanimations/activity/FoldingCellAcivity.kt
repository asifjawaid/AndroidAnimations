package com.cs.androidanimations.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cs.androidanimations.R
import kotlinx.android.synthetic.main.activity_folding_cell_acivity.*

class FoldingCellAcivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_folding_cell_acivity)
        folding_cell.setOnClickListener {
                folding_cell.toggle(false)
        }
    }
}
