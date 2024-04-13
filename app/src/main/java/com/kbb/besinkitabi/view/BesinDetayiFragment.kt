package com.kbb.besinkitabi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.kbb.besinkitabi.R
import com.kbb.besinkitabi.adapter.BesinRecyclerAdapter
import com.kbb.besinkitabi.databinding.FragmentBesinDetayiBinding
import com.kbb.besinkitabi.util.gorselIndir
import com.kbb.besinkitabi.util.placeholderYap
import com.kbb.besinkitabi.viewmodel.BesinDetayiViewModel
import com.kbb.besinkitabi.viewmodel.BesinListesiViewModel
import kotlinx.android.synthetic.main.fragment_besin_detayi.*


class BesinDetayiFragment : Fragment() {
    private var besinId=0
    private lateinit var viewModel:BesinDetayiViewModel
    private lateinit var dataBinding:FragmentBesinDetayiBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_besin_detayi,container,false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            besinId=BesinDetayiFragmentArgs.fromBundle(it).besinId
        }
        viewModel=ViewModelProviders.of(this).get(BesinDetayiViewModel::class.java)
        viewModel.roomVerisiniAl(besinId)


        observeLiveData()


    }
    fun observeLiveData(){
        viewModel.besinLiveData.observe(viewLifecycleOwner, Observer { besin->
            besin?.let {
                dataBinding.secilenBesin=it
                /*
                besinIsim.text=it.besinIsim
                besinKalori.text=it.besinKalori
                besinKarbonhidrat.text=it.besinKarbonhidrat
                besinProtein.text=it.besinProtein
                besinYag.text=it.besinYag
                context?.let {
                    besinImage.gorselIndir(besin.besinGorsel, placeholderYap(it))
                                  }

                 */

            }
        })
    }

}