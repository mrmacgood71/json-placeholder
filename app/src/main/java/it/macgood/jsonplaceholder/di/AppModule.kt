package it.macgood.jsonplaceholder.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import it.macgood.jsonplaceholder.common.Constants
import it.macgood.jsonplaceholder.data.remote.JsonPlaceholderApi
import it.macgood.jsonplaceholder.data.repository.JsonPlaceholderRepositoryImpl
import it.macgood.jsonplaceholder.domain.repository.JsonPlaceholderRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideJsonPlaceholderApi(): JsonPlaceholderApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JsonPlaceholderApi::class.java)
    }

    @Provides
    @Singleton
    fun provideJsonPlaceholderRepository(api: JsonPlaceholderApi)
    : JsonPlaceholderRepository {
        return JsonPlaceholderRepositoryImpl(api)
    }
}