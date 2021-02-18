package by.it.academy.app5task.content_provider

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import by.it.academy.app5task.database.DatabaseCars
import by.it.academy.app5task.database.WorkItemDAO

class CarWorksContentProvider : ContentProvider() {

    companion object {
        private const val AUTHORITY = "by.it.academy.app5task.app5task.content_provider.CarWorksContentProvider"
        private const val URI_WORKS_DATABASE_CODE = 1
        private val uriMatcher = UriMatcher(UriMatcher.NO_MATCH).apply {
            addURI(AUTHORITY, "WorksDataBase", URI_WORKS_DATABASE_CODE)
        }
    }

    private lateinit var dao: WorkItemDAO

    override fun onCreate(): Boolean {
        context?.run {
            dao = DatabaseCars.init(applicationContext).getWorkListDatabaseDAO()
        }
        return false
    }

    override fun query(uri: Uri, //откуда забирать данные
                       projection: Array<out String>?, // какие столбцы нужно выбрать и вернуть в качестве результата
                       selection: String?, // условие выборки
                       selectionArgs: Array<out String>?, //аргументы этой выборки
                       sortOrder: String?) // тип сортировки если он нужен. по возрастанию, по убыванию или по какому столбцу
            : Cursor? {
        if (uriMatcher.match(uri) == URI_WORKS_DATABASE_CODE) {
            return dao.getAllWorks()
        }
        return null
    }

    override fun getType(uri: Uri): String? {
        if (uriMatcher.match(uri) == URI_WORKS_DATABASE_CODE) {
            return "object/*"
        }
        return null
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
//        TODO("Not yet implemented")
        return null
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
//        TODO("Not yet implemented")
        return 0
    }

    override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<out String>?): Int {
//        TODO("Not yet implemented")
        return 0
    }


}