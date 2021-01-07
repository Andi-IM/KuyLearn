package live.andiirham.kuylearn.andi.dataclass

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Posts(
    var name: String,
    var company: String,
    var date: String,
    var message: String,
    var photo: String
) : Parcelable