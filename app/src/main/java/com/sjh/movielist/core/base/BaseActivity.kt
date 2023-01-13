package com.sjh.movielist.core.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.sjh.movielist.BR

abstract class BaseActivity<VB : ViewDataBinding, VM : BaseViewModel>(@LayoutRes private val layoutResId: Int) :
    AppCompatActivity() {
    lateinit var binding: VB
    protected abstract val viewModel: VM
    protected abstract val bindingId: Int


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutResId)
        binding.setVariable(bindingId, viewModel)
    }

}