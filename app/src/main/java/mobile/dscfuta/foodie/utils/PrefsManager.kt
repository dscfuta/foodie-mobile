package mobile.dscfuta.foodie.utils

import android.content.Context
import android.content.SharedPreferences


object SharedprefManager {

    val PHONE = "PHONE"
    val UID = "UID"
    val EMAIL = "EMAIL"
    val NAME = "NAME"

    fun customPreference(context: Context, name: String):
            SharedPreferences? = context.getSharedPreferences(name, Context.MODE_PRIVATE)

    inline fun SharedPreferences.editMe(operation: (SharedPreferences.Editor) -> Unit) {
        val editMe = edit()
        operation(editMe)
        editMe.apply()
    }

    fun SharedPreferences.Editor.put(pair: Pair<String, Any>) {
        val key = pair.first
        val value = pair.second
        when (value) {
            is String -> putString(key, value)
            is Int -> putInt(key, value)
            is Boolean -> putBoolean(key, value)
            is Long -> putLong(key, value)
            is Float -> putFloat(key, value)
            else -> error("Only primitive types can be stored in SharedPreferences")
        }
    }

    var SharedPreferences.phonenumber
        get() = getString(PHONE, "")
        set(value) {
            editMe {
                it.putString(PHONE, value)
            }
        }

    var SharedPreferences.usertoken
        get() = getString(UID, "")
        set(value) {
            editMe {
                it.putString(UID, value)
            }
        }

    var SharedPreferences.email
        get() = getString(EMAIL, "")
        set(value) {
            editMe {
                it.putString(EMAIL, value)
            }
        }

    var SharedPreferences.name
        get() = getString(NAME, "")
        set(value) {
            editMe {
                it.putString(NAME, value)
            }
        }

    var SharedPreferences.clearValues
        get() = { }
        set(value) {
            editMe {
                it.clear()
            }
        }
}
