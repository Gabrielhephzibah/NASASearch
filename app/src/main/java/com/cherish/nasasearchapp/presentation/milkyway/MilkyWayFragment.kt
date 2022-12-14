package com.cherish.nasasearchapp.presentation.milkyway

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.cherish.apimodule.common.Resource
import com.cherish.apimodule.data.model.response.MilkyWayResponse
import com.cherish.nasasearchapp.common.extension.collect
import com.cherish.nasasearchapp.common.extension.collectLast
import com.cherish.nasasearchapp.common.extension.executeWithAction
import com.cherish.nasasearchapp.databinding.FragmentMilkyWayBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.map


@AndroidEntryPoint
class MilkyWayFragment : Fragment() {
    private lateinit var binding : FragmentMilkyWayBinding
    private var milkyWayAdapter: MilkyWayAdapter? = null
    private val viewModel: MilkyWayViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMilkyWayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        milkyWayAdapter = MilkyWayAdapter {  }
        setupAdapter()

      // collectLast(viewModel.getMilkyWayImages(), ::setPost)

    }

   private fun setupAdapter(){
       collect(
           flow = viewModel.getMilkyWayImages(),
           action = ::getMilkyWayImages,
           display = { res ->
               println("RESPONSE ::: $res")
             val response = res.data?.collection?.items?.map { it ->
                 MilkyWayItem(
                     it.data?.map{ it.nasaId}?.firstOrNull(),
                     it.data?.map{ it.title}?.firstOrNull(),
                     it.data?.map{ it.center}?.firstOrNull(),
                     it.data?.map{ it.dateCreated}?.firstOrNull(),
                     it.links?.map{ it.href}?.firstOrNull(),
                     it.links?.map{ it.href}?.firstOrNull()) }
                  milkyWayAdapter?.submitList(response)
           }
       )
       binding.recyclerView.adapter = milkyWayAdapter

//        collect(
//            action = ::getMilkyWayImages
//        )
        //viewModel.getMilkyWayImages
//


       //commentAdapter?.submitList(detailViewModel.postComment)

    }



    private fun getMilkyWayImages(loadState: Resource<MilkyWayResponse?>) {
        binding.executeWithAction {
            milkyWayUI = MilkyWayViewState(loadState)
            println("Success State::: ${loadState.data}")
            println("Loading State::: ${loadState.loading}")
            println("Error State::: ${loadState.error}")
        }
    }

//    private suspend fun setPost(response: List<MilkyWayItem>) {
//        milkyWayAdapter?.submitList(response)
//    }





}