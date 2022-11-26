package com.mberrueta.a15_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment(R.layout.fragment_first) {
    //mettendo l'id del layout nel costruttore del fragment gli dico di inflatare quella view senza tutto il boilerplate


    //QUESTI METODI VENGONO CANCELLATI NEL TUTORIAL
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        //qua non posso accedere alla view
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        //qua posso accedere alla view
//    }
//
//    //nel tutorial ho solo questo metodo, è il più usato
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment <- ECCO A COSA SERVE
//        return inflater.inflate(R.layout.fragment_first, container, false)
//    }
}