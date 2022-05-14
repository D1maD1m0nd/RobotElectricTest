package com.geekbrains.tests.presenter

import com.geekbrains.tests.view.ViewContract
import com.geekbrains.tests.view.details.ViewDetailsContract

interface PresenterContract {
    fun onAttach(viewContract: ViewContract)
    fun onDetach()
}
