package home.dj.factory

import io.micronaut.context.annotation.Context
import io.micronaut.context.annotation.Factory
import kotlinx.coroutines.Dispatchers

@Factory
class LandlordAppFactory {

    @Context
    fun ioDispatcher() = Dispatchers.IO
}