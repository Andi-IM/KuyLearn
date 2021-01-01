package live.andiirham.kuylearn

import android.content.Context

internal class PrefManager(context: Context) {
    companion object {
        // Shared preferences file name
        private const val PREF_NAME = "introslider"
        private const val IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch"
    }

    private var preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    private var editor = preferences.edit()


    var isFirstTimeLaunch: Boolean
        get() = preferences.getBoolean(IS_FIRST_TIME_LAUNCH, true)
        set(isFirstTime) {
            editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime)
            editor.commit()
        }
}