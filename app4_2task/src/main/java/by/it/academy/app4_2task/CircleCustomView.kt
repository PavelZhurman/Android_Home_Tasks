package by.it.academy.app4_2task

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Region
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class CircleCustomView : View {


    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    private val radiusSmallCircle = 150
    private val radiusBigCircle = 400
    private val regions = mutableListOf(Region(), Region(), Region(), Region(), Region())

    private val colors = mutableListOf(Color.BLACK, Color.BLUE, Color.CYAN, Color.GRAY, Color.GREEN, Color.RED)
    private val paints = mutableListOf(Paint(), Paint(), Paint(), Paint(), Paint())

    private var centerX = 0F
    private var centerY = 0F

    private lateinit var rect: RectF

    interface OnCustomClickListener {
        fun onCustomClick(x: Int, y: Int, color: Int)
    }

    lateinit var customClickListener: OnCustomClickListener

    fun onCustomClickListener(customClickListener: OnCustomClickListener) {
        this.customClickListener = customClickListener
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)
        centerX = ((width / 2).toFloat())
        centerY = ((height / 2).toFloat())

        initRectF()
        initPaints()
        initRegions()

    }


    private fun initRegions() {
        val x: Int = centerX.toInt()
        val y: Int = centerY.toInt()
        regions[0].set(x, y, x + radiusBigCircle, y + radiusBigCircle)
        regions[1].set(x - radiusBigCircle, y, x, y + radiusBigCircle)
        regions[2].set(x - radiusBigCircle, y - radiusBigCircle, x, y)
        regions[3].set(x, y - radiusBigCircle, x + radiusBigCircle, y)

        regions[4].set(x - radiusSmallCircle, y - radiusSmallCircle, x + radiusSmallCircle, y + radiusSmallCircle)

    }

    private fun initRectF() {
        rect = RectF(
                (centerX - radiusBigCircle), (centerY - radiusBigCircle),
                centerX + radiusBigCircle, centerY + radiusBigCircle)
    }

    private fun initPaints() {
        for (i in paints.indices) {
            paints[i].color = colors.random()
        }
    }

    override fun onDrawForeground(canvas: Canvas?) {
        initRegions()
        super.onDrawForeground(canvas)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawArc(rect, 0F, 90F, true, paints[0]) //rightBot
        canvas?.drawArc(rect, 90F, 90F, true, paints[1]) //leftBot
        canvas?.drawArc(rect, 180F, 90F, true, paints[2]) //leftTop
        canvas?.drawArc(rect, 270F, 90F, true, paints[3]) //rightTop

        canvas?.drawCircle(centerX, centerY, radiusSmallCircle.toFloat(), paints[4])

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val pressedX = event?.x?.toInt()
        val pressedY = event?.y?.toInt()
        val action = event?.action

        if (action == MotionEvent.ACTION_DOWN) {
            if (pressedX != null && pressedY != null) {
                if (regions[4].contains(pressedX, pressedY)) {
                    initPaints()
                    customClickListener.onCustomClick(pressedX, pressedY, paints[4].color)
                    invalidate()
                } else {
                    for (i in regions.indices) {
                        if (regions[i].contains(pressedX, pressedY)) {
                            paints[i].color = colors.random()
                            customClickListener.onCustomClick(pressedX, pressedY, paints[i].color)
                            invalidate()
                        }
                    }
                }
            }
        }

        return super.onTouchEvent(event)

    }
}
