package io.reyurnible.goodbyshape

import android.graphics.drawable.Drawable
import android.graphics.drawable.RippleDrawable
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.shape.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSharpCutButton()
        setEdgeButton()
        setAllowCutButton()
        setRoundedCornerButton()
        Log.d(MainActivity::class.java.simpleName, normal_button.background.toString())
    }

    private fun setSharpCutButton() {
        val shapePathModel = ShapePathModel().apply {
            topLeftCorner = CutCornerTreatment(resources.getDimension(R.dimen.btn_cut_corner_size))
        }
        val shapeDrawable = MaterialShapeDrawable(shapePathModel).apply {
            setTint(ContextCompat.getColor(this@MainActivity, R.color.colorAccent))
        }
        sharp_cut_button.background = shapeDrawable.toRipple()
    }

    private fun setEdgeButton() {
        val shapePathModel = ShapePathModel().apply {
            setAllEdges(TriangleEdgeTreatment(resources.getDimension(R.dimen.btn_cut_edge_size), true))
        }
        val shapeDrawable = MaterialShapeDrawable(shapePathModel).apply {
            setTint(ContextCompat.getColor(this@MainActivity, R.color.colorAccent))
        }
        edge_button.background = shapeDrawable.toRipple()
    }

    private fun setAllowCutButton() {
        val shapePathModel = ShapePathModel().apply {
            val cornerTreatment = CutCornerTreatment(resources.getDimension(R.dimen.btn_half_cut_corner_size))
            topRightCorner = cornerTreatment
            bottomRightCorner = cornerTreatment
            leftEdge = TriangleEdgeTreatment(resources.getDimension(R.dimen.btn_half_cut_corner_size), true)
        }
        val shapeDrawable = MaterialShapeDrawable(shapePathModel).apply {
            setTint(ContextCompat.getColor(this@MainActivity, R.color.colorAccent))
        }
        allow_cut_button.background =shapeDrawable.toRipple()
    }

    private fun setRoundedCornerButton() {
        val shapePathModel = ShapePathModel().apply {
            val cornerTreatment = RoundedCornerTreatment(resources.getDimension(R.dimen.btn_half_cut_corner_size))
            topLeftCorner = cornerTreatment
            topRightCorner = cornerTreatment
        }
        val shapeDrawable = MaterialShapeDrawable(shapePathModel).apply {
            setTint(ContextCompat.getColor(this@MainActivity, R.color.colorAccent))
        }
        rounded_corner_button.background = shapeDrawable.toRipple()
    }

    private fun Drawable.toRipple(): RippleDrawable =
            RippleDrawable(
                    ContextCompat.getColorStateList(this@MainActivity, R.color.mtrl_btn_ripple_color),
                    this,
                    null
            )
}
