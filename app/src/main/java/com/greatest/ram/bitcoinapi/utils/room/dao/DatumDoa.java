package com.greatest.ram.bitcoinapi.utils.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.greatest.ram.bitcoinapi.utils.model.Datum;

import java.util.Date;
import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface DatumDoa {
    @Insert(onConflict = REPLACE)
    void save(Datum datum);

    @Query("SELECT * FROM datum")
    LiveData<List<Datum>> loadAll();

    @Query("SELECT * FROM datum WHERE mId = :id")
    LiveData<Datum> load(long id);

    @Query("SELECT * FROM datum WHERE  lastRefresh > :lastRefreshMax LIMIT 1")
    Datum getCoin(Date lastRefreshMax);
}
