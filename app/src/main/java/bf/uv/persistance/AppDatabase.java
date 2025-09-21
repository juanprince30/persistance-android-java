package bf.uv.persistance;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import bf.uv.persistance.User;
import bf.uv.persistance.UserDao;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}