package io.reyurnible.goodbyshape

import android.util.Log
import com.google.android.material.shape.CornerTreatment
import com.google.android.material.shape.ShapePath

class MyCornerTreatment(private val radius: Float) : CornerTreatment() {

    override fun getCornerPath(angle: Float, interpolation: Float, shapePath: ShapePath?) {
        Log.d("MyCornerTreatment", "getCornerPath($angle, $interpolation)")
        shapePath?.let { path ->
            path.reset(0.0f, radius * interpolation)
            path.addArc(0.0f, 0.0f, 2.0f * radius * interpolation, 2.0f * radius * interpolation, angle + 90.0f, 90.0f)
//            path.addArc(0.0f, 0.0f, 2.0f * radius * interpolation, 2.0f * radius * interpolation, angle + 180.0f, 90.0f)
        }


    }
}