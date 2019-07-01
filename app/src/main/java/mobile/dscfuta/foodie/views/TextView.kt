package mobile.dscfuta.foodie.views

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet

/**
 * Created by Abdrex on 10/29/2016.
 */
class TextView : androidx.appcompat.widget.AppCompatTextView {
    constructor(context: Context) : super(context) {
        applyTypeface(context, "font.ttf")
    }

    private fun applyTypeface(context: Context, d: String) {
        val tr = Typeface.createFromAsset(getContext().assets, d)
        typeface = tr
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        applyTypeface(context, "font.ttf")
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        applyTypeface(context, "font.ttf")
    }


}
