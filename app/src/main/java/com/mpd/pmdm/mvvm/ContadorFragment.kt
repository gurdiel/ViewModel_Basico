package com.mpd.pmdm.mvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.mpd.pmdm.mvvm.databinding.FragmentContadorBinding

class ContadorFragment : Fragment() {

    private var _binding:FragmentContadorBinding? = null
    private val binding get() = _binding!!

    // como hacemos referencia al viewModel
    private val contador:ContadorClicks by activityViewModels {
        ContadorClickFactory(5)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentContadorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.contadoBind = contador
        binding.lifecycleOwner = viewLifecycleOwner
        //una vez creadas las vistas,
        // mantenemos el contador al día.
        //diferencia del observe en el main activity que cambia en un framento?
        //el primer parametro ya no es el this porque el framento no es el dueño
        //en un framento. le pasamos una varibale del framento.

        /**Quitamos este observer al meter el LiveData*/
        //contador.cuentaClicks.observe(viewLifecycleOwner){
        //    actualizaContador()
        //}
        //cada vez que haya un cambio se le llama a actualiza contador.
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun actualizaContador() {
        binding.tvContador.text = contador.cuentaClicks.value.toString()
    }


}