package bf.uv.persistance;

import android.content.Context;

import bf.uv.persistance.AppDatabase;

public class DbProvider {
    private static AppDatabase INSTANCE;

    public static synchronized AppDatabase get(Context ctx) {
        if (INSTANCE == null) {
            INSTANCE = androidx.room.Room.databaseBuilder(
                    ctx.getApplicationContext(),
                    AppDatabase.class,
                    "app.db"
            ).build();
        }
        return INSTANCE;
    }
}