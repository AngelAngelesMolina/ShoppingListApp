package com.example.shoppinglist.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Category.class, Items.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    //SINGLETON FROM OUR DB
    public static AppDatabase INSTANCE;

    public abstract ShoppingListDao shoppingListDao();

    public static AppDatabase getDBInstace(Context context) {
        if (INSTANCE == null) {
            //Make the instance of the db
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "AppDB")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

}
