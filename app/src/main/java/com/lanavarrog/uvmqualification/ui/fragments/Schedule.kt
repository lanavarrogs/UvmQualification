package com.lanavarrog.uvmqualification.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.lanavarrog.uvmqualification.R
import com.lanavarrog.uvmqualification.adapters.MateriaListener
import com.lanavarrog.uvmqualification.adapters.MateriasAdapter
import com.lanavarrog.uvmqualification.model.Materia
import com.lanavarrog.uvmqualification.viewModel.ScheduleViewModel
import kotlinx.android.synthetic.main.fragment_schedule.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Schedule.newInstance] factory method to
 * create an instance of this fragment.
 */
class Schedule : Fragment(), MateriaListener {
    private lateinit var materiaAdapter: MateriasAdapter
    private lateinit var viewModel: ScheduleViewModel
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_schedule, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //auth = Firebase.auth
        //val user = auth.currentUser
            viewModel = ViewModelProvider(this).get(ScheduleViewModel::class.java)
            viewModel.refresh()
            materiaAdapter = MateriasAdapter(this)
            rvSchedule.apply {
                layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL,false)
                adapter = materiaAdapter
            }
            observeViewModel()
    }

    fun observeViewModel(){
        viewModel.listScheduleViewModel.observe(viewLifecycleOwner, Observer<List<Materia>>{ schedule ->
            materiaAdapter.updateData(schedule)
        })
        viewModel.isLoading.observe(viewLifecycleOwner, Observer<Boolean>{
                rlBase.visibility = View.INVISIBLE
        })
    }

    override fun onMateriaClicked(materia: Materia, position: Int) {
        val bundle = bundleOf("materia" to materia)
        findNavController().navigate(R.id.scheduleDetailDialog,bundle)
    }
}