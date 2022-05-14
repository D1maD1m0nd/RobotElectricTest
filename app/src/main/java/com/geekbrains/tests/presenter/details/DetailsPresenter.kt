package com.geekbrains.tests.presenter.details

import com.geekbrains.tests.view.ViewContract
import com.geekbrains.tests.view.details.ViewDetailsContract

class DetailsPresenter : PresenterDetailsContract {
    var viewContract: ViewDetailsContract? = null
    var count: Int? = null
    override fun onAttach(viewContract: ViewContract) {
        this.viewContract = viewContract as ViewDetailsContract
        count = 0
        viewContract.init()
    }

    override fun setCounter(count: Int) {
        this.count = count
    }

    override fun onIncrement() {
        count = count?.plus(1)
        count?.let {
            viewContract?.setCount(it)
        }
    }

    override fun onDecrement() {
        count = count?.minus(1)
        count?.let {
            viewContract?.setCount(it)
        }
    }

    override fun onDetach() {
        viewContract = null
        count = null
    }
}
