package mobile.dscfuta.foodie.views

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet

/**
 * Created by Abdrex on 1/16/2017.
 */
class SemiBoldTextView : androidx.appcompat.widget.AppCompatTextView {
    constructor(context: Context) : super(context) {
        applyTypeface(context, "font_semibold.ttf")

    }

    private fun applyTypeface(context: Context, d: String) {
        val tr = Typeface.createFromAsset(context.assets, d)
        typeface = tr
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        applyTypeface(context, "retsemibold.ttf")
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        applyTypeface(context, "retsemibold.ttf")
    }
}
