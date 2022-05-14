package com.geekbrains.tests.presenter.details

import com.geekbrains.tests.presenter.PresenterContract
import com.geekbrains.tests.view.details.ViewDetailsContract

interface PresenterDetailsContract : PresenterContract {

    fun setCounter(count: Int)
    fun onIncrement()
    fun onDecrement()

}
