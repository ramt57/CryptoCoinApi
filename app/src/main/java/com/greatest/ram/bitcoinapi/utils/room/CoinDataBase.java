package com.greatest.ram.bitcoinapi.utils.room;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import com.greatest.ram.bitcoinapi.utils.model.Datum;
import com.greatest.ram.bitcoinapi.utils.room.dao.DatumDoa;
import com.greatest.ram.bitcoinapi.utils.room.typeconverters.DateConverters;

@Database(entities = {Datum.class}, version = 2)
@TypeConverters(DateConverters.class)
public abstract class CoinDataBase extends RoomDatabase {

    // --- SINGLETON ---
    private static volatile CoinDataBase INSTANCE;

    // --- DAO ---
    public abstract DatumDoa datumDoa();
}
