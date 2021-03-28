package by.it.academy.app9task.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cities")
class CityItem(
        val city: String
) {
    @PrimaryKey(autoGenerate = true)
    var cityId: Int = 0
}