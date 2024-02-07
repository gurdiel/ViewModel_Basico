package com.mpd.pmdm.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.mpd.pmdm.mvvm.databinding.FragmentBotonesBinding

class BotonesFragment : Fragment() {

    private var _binding: FragmentBotonesBinding? = null
    private val binding get() = _binding!!



    // como hacemos referencia al viewModel
    //No son dos instancias, no se porqué pero no se crean dos instancias.
    private val contador:ContadorClicks by activityViewModels {
        ContadorClickFactory(5)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBotonesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.contadorBindingFunciones = contador
        binding.lifecycleOwner = viewLifecycleOwner
        /*binding.btnIncrementa.setOnClickListener {
            contador.incrementa()
        }
        binding.btnResta.setOnClickListener {
            contador.decrementa()
        }*/
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}