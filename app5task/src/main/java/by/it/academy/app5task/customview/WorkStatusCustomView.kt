package by.it.academy.app5task.customview

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import by.it.academy.app5task.R

class WorkStatusCustomView : View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    private val imagePendingGray = R.drawable.ic_pending_gray
    private val imageInProgressGray = R.drawable.ic_in_progress_gray
    private val imageCompletedGray = R.drawable.ic_completed_gray
    private val imagePending = R.drawable.ic_pending
    private val imageInProgress = R.drawable.ic_in_progress
    private val imageCompleted = R.drawable.ic_completed
    private val imageArrowForward = R.drawable.ic_baseline_arrow_forward_24

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

}