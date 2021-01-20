package com.mutualmobile.praxis.domain

import com.mutualmobile.praxis.domain.injection.component.DaggerTestAppComponent
import com.mutualmobile.praxis.domain.injection.component.TestAppComponent
import dagger.android.DaggerApplication

class TestApplication: DaggerApplication() {

    private val component: TestAppComponent by lazy {
        DaggerTestAppComponent.builder().create(this) as TestAppComponent
    }

    override fun applicationInjector() = component

    fun provideComponent() = component
}