package com.kbb.besinkitabi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.kbb.besinkitabi.R
import com.kbb.besinkitabi.databinding.BesinRecyclerRowBinding
import com.kbb.besinkitabi.model.Besin
import com.kbb.besinkitabi.util.gorselIndir
import com.kbb.besinkitabi.util.placeholderYap
import com.kbb.besinkitabi.view.BesinListesiFragmentDirections
import kotlinx.android.synthetic.main.besin_recycler_row.view.*
import kotlinx.android.synthetic.main.fragment_besin_detayi.view.*

class BesinRecyclerAdapter(val besinListesi:ArrayList<Besin>):RecyclerView.Adapter<BesinRecyclerAdapter.BesinViewHolder>(),BesinClickListener {
    class BesinViewHolder(var view: BesinRecyclerRowBinding):RecyclerView.ViewHolder(view.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BesinViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        //val view=inflater.inflate(R.layout.besin_recycler_row,parent,false)
        val view = DataBindingUtil.inflate<BesinRecyclerRowBinding>(inflater,R.layout.besin_recycler_row,parent,false)
        return BesinViewHolder(view)



    }

    override fun onBindViewHolder(holder: BesinViewHolder, position: Int) {
        /*
        holder.itemView.Ismi.text=besinListesi.get(position).besinIsim
        holder.itemView.Kalorisi.text=besinListesi.get(position).besinKalori
        holder.itemView.setOnClickListener {
            val action=BesinListesiFragmentDirections.actionBesinListesiFragmentToBesinDetayiFragment(besinListesi.get(position).uuid)
            Navigation.findNavController(it).navigate(action)
        }
        holder.itemView.imageView.gorselIndir(besinListesi.get(position).besinGorsel,
            placeholderYap(holder.itemView.context))
         */
        holder.view.besin=besinListesi[position]
        holder.view.listener=this

    }

    override fun getItemCount(): Int {
        return besinListesi.size
    }
    fun besinListesiniGuncelle(yeniBesinListesi:List<Besin>){
        besinListesi.clear()
        besinListesi.addAll(yeniBesinListesi)
        notifyDataSetChanged()

    }

    override fun besinTiklandi(view: View) {
        val uuid=view.besin_uuid.text.toString().toIntOrNull()
        uuid?.let {
            val action=BesinListesiFragmentDirections.actionBesinListesiFragmentToBesinDetayiFragment(uuid)
            Navigation.findNavController(view).navigate(action)

        }

    }
}