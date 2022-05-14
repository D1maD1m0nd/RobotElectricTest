package com.geekbrains.tests

import com.geekbrains.tests.presenter.details.DetailsPresenter
import com.geekbrains.tests.presenter.search.SearchPresenter
import com.geekbrains.tests.view.details.ViewDetailsContract
import com.geekbrains.tests.view.search.ViewSearchContract
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class DetailsPresenterTest {
    private lateinit var presenter: DetailsPresenter
    @Mock
    private lateinit var viewContract: ViewDetailsContract

    @Before
    fun setUp() {
        //Обязательно для аннотаций "@Mock"
        //Раньше было @RunWith(MockitoJUnitRunner.class) в аннотации к самому классу (SearchPresenterTest)
        MockitoAnnotations.initMocks(this)
        //Создаем Презентер, используя моки Репозитория и Вью, проинициализированные строкой выше
        presenter = DetailsPresenter()
    }

    @Test //Проверим вызов метода init() у viewContract
    fun detailsOnAttach_Test() {
        presenter.onAttach(viewContract)
        //Убеждаемся, что все работает как надо
        Mockito.verify(viewContract, Mockito.times(1)).init()
    }

    @Test //Проверим на null viewContract перед onAttach
    fun detailsOnAttachContracIsNotNull_Test() {
       Assert.assertNull(presenter.viewContract)
       presenter.onAttach(viewContract)
    }
    @Test //Проверим на null count перед onAttach
    fun detailsOnAttachCountIsNotNull_Test() {
        Assert.assertNull(presenter.count)
        presenter.onAttach(viewContract)
    }
    @Test //Проверим на не null viewContract после onAttach
    fun detailsOnAttachContracNotNull_Test() {
        presenter.onAttach(viewContract)
        Assert.assertNotNull(presenter.viewContract)
    }

    @Test //Проверим на не null count после onAttach
    fun detailsOnAttachCountNotNull_Test() {
        presenter.onAttach(viewContract)
        Assert.assertNotNull(presenter.count)
    }

    @Test
    fun detailsOnDetachIsNullViewContract_Test() {
        presenter.onDetach()
        Assert.assertNull(presenter.viewContract)
    }

    @Test
    fun detailsOnDetachIsNullCount_Test() {
        presenter.onDetach()
        Assert.assertNull(presenter.count)
    }


    @Test
    fun detailsOnIncrement_test() {
        presenter.onAttach(viewContract)
        presenter.onIncrement()
        Assert.assertEquals(presenter.count, 1)
    }

    @Test
    fun detailsOnDecrement_test() {
        presenter.onAttach(viewContract)
        presenter.onDecrement()
        Assert.assertEquals(presenter.count, -1)
    }

    @Test
    fun detailsOnIncrementVerifySetCountContract_test() {
        presenter.onAttach(viewContract)
        presenter.onIncrement()
        Mockito.verify(viewContract, Mockito.times(1)).setCount(1)
    }

    @Test
    fun detailsOnDecrementVerifySetCountContract_test() {
        presenter.onAttach(viewContract)
        presenter.onDecrement()
        Mockito.verify(viewContract, Mockito.times(1)).setCount(-1)
    }

}