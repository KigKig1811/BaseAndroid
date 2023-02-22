package com.example.common.base

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<viewModel : BaseViewModel, binding : ViewBinding>(layoutId: Int) :
    Fragment(layoutId) {
}