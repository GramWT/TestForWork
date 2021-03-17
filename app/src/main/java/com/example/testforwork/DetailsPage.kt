package com.example.testforwork

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.event_row.view.*
import kotlinx.android.synthetic.main.fragment_details_page.view.*

class DetailsPage : Fragment() {

    private val args by navArgs<DetailsPageArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_details_page, container, false)

        view.backMainPage.setOnClickListener {
            val action = DetailsPageDirections.actionDetailsPageToMainPage()
            findNavController().navigate(action)
        }
        Picasso.get().load(args.Event.image_url).into(view.eventImage)

        view.nameEvent.text = args.Event.name
        view.discount.text = args.Event.price
        view.details.text = args.Event.description
        return view
    }


}