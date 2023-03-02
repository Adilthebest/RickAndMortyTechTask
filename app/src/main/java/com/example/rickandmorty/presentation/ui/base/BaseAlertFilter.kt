package com.example.rickandmorty.presentation.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.viewbinding.ViewBinding
import com.example.rickandmorty.R

abstract class BaseAlertFilter<VB : ViewBinding>(
    @LayoutRes private val layoutId: Int
) : AppCompatDialogFragment() {
    protected abstract val binding: VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.setCancelable(false)
        dialog?.setCanceledOnTouchOutside(false)
        return inflater.inflate(R.layout.fragment_filtr, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        filterCheckId()
        getCheckedFilter()
    }

    abstract fun getCheckedFilter()
    abstract fun filterCheckId()
    abstract fun initView()
}