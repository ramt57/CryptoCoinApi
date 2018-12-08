package com.greatest.ram.bitcoinapi.utils.di.modules;

import android.app.Application;
import androidx.room.Room;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.greatest.ram.bitcoinapi.utils.model.Datum;
import com.greatest.ram.bitcoinapi.utils.repository.CoinDataRepository;
import com.greatest.ram.bitcoinapi.utils.retrofit.CoinWebService;
import com.greatest.ram.bitcoinapi.utils.room.CoinDataBase;
import com.greatest.ram.bitcoinapi.utils.room.dao.DatumDoa;
import com.greatest.ram.bitcoinapi.utils.utils.Constant;
import dagger.Module;
import dagger.Provides;
import okhttp3.*;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Singleton;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Module(includes = ViewModelModule.class)
public class AppModules {

    // DATABASE INJECTION

    @Provides
    @Singleton
    CoinDataBase provideDatabase(Application application) {
        return Room.databaseBuilder(application,
                CoinDataBase.class, "CoinDatabase.db")
                .build();
    }

    @Provides
    @Singleton
    DatumDoa provideUserDao(CoinDataBase database) { return database.datumDoa(); }

    // REPOSITORY INJECTION

    @Provides
    Executor provideExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    @Provides
    @Singleton
    CoinDataRepository provideUserRepository(CoinWebService webservice, DatumDoa userDao, Executor executor) {
        return new CoinDataRepository(webservice, userDao, executor);
    }

    // --- NETWORK INJECTION ---


    @Provides
    Gson provideGson() { return new GsonBuilder().setLenient().create(); }

    @Provides
    Retrofit provideRetrofit(Gson gson) {

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(Constant.BASE_URL)
                .client(provideOkHttpClient())
                .build();
        return retrofit;
    }
    @Provides
    OkHttpClient provideOkHttpClient(){
        /*for passing header in every request*/
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Headers.Builder headers=new Headers.Builder();
                headers.add("Accept: application/json");
                headers.add(Constant.HEADER,Constant.API_KEY);
                Request request = chain.request().newBuilder().headers(headers.build()).build();
                return chain.proceed(request);
            }
        });
        return httpClient.build();
    }
    @Provides
    @Singleton
    CoinWebService provideCoinWebservice(Retrofit retrofit) {
        return retrofit.create(CoinWebService.class);
    }
}