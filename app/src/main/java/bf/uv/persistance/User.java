package bf.uv.persistance;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {
    @PrimaryKey(autoGenerate = true)
    public long id;

    public String name;
    public String email;
    public String phone;
    public String password;

    public long createdAt;
} 