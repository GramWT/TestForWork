package com.example.testforwork

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testforwork.Common.Common
import com.example.testforwork.Model.Event
import com.example.testforwork.Interface.RetrofitService
import com.example.testforwork.databinding.FragmentMainPageBinding
import dmax.dialog.SpotsDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainPage : Fragment() {

    private lateinit var binding:FragmentMainPageBinding
    private lateinit var layoutManager: GridLayoutManager
    lateinit var adapter: EventAdapter
    lateinit var dialog: AlertDialog
    lateinit var mService:RetrofitService


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMainPageBinding.inflate(layoutInflater)

        val at = activity as Context

        mService = Common.retrofitService

        binding.recycleView.setHasFixedSize(true)
        layoutManager = GridLayoutManager(at,2,LinearLayoutManager.VERTICAL,false)

        binding.recycleView.layoutManager = layoutManager

        dialog = SpotsDialog.Builder().setCancelable(false).setContext(at).build()
        getAllEvent(at,binding.recycleView)


        return binding.root

    }

    private fun getAllEvent(mContext:Context,re:RecyclerView) {

        mService.getEventList().enqueue(object :Callback<MutableList<Event>>{
            override fun onResponse(call: Call<MutableList<Event>>?, response: Response<MutableList<Event>>?) {
                adapter = EventAdapter(mContext,response?.body() as MutableList<Event>)
                adapter.notifyDataSetChanged()
                re.adapter = adapter
            }

            override fun onFailure(call: Call<MutableList<Event>>?, t: Throwable?) {
            }


        })
    }


}