package com.tmrtapps.loadingbutton

import android.animation.AnimatorInflater
import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.RippleDrawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.annotation.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.tmrtapps.loadingbutton.databinding.LoadingButtonBinding

class LoadingButton @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : ConstraintLayout(context, attrs, defStyleAttr) {

    companion object {
        const val ALIGN_START = 1
        const val ALIGN_END = 2
        const val ALIGN_CENTER = 7
        const val ALIGN_TOP = 3
        const val ALIGN_BOTTOM = 4
        const val STUCK = 5
        const val FREE = 6
    }

    var isLoading = false
        set(value) {
            field = value
            handleIsLoading()
        }

    @ColorInt
    var buttonColor = ContextCompat.getColor(context, R.color.buttonColor)
        set(value) {
            field = value
            view()
        }

    @ColorInt
    var buttonColorDisabled = ContextCompat.getColor(context, R.color.buttonColorDisabled)

    @ColorInt
    var buttonStrokeColor = ContextCompat.getColor(context, R.color.buttonStrokeColor)
        set(value) {
            field = value
            view()
        }

    @ColorInt
    var buttonStrokeColorDisabled = ContextCompat.getColor(context, R.color.buttonStrokeColorDisabled)
        set(value) {
            field = value
        }

    @Dimension
    var buttonStrokeWidth = context.resources.getDimensionPixelSize(R.dimen.buttonStrokeWidth)
        set(value) {
            field = value
            view()
        }

    @ColorInt
    var buttonRippleColor = ContextCompat.getColor(context, R.color.buttonRippleColor)
        set(value) {
            field = value
            view()
        }

    @Dimension
    var buttonCornerRadius = context.resources.getDimensionPixelSize(R.dimen.buttonCornerRadius)
        set(value) {
            field = value
            view()
        }

    @Dimension
    var textMarginTop = context.resources.getDimensionPixelSize(R.dimen.textMargin)
        set(value) {
            field = value
            textView()
        }

    @Dimension
    var textMarginBottom = context.resources.getDimensionPixelSize(R.dimen.textMargin)
        set(value) {
            field = value
            textView()
        }

    @Dimension
    var textMarginStart = context.resources.getDimensionPixelSize(R.dimen.textMargin)
        set(value) {
            field = value
            textView()
        }

    @Dimension
    var textMarginEnd = context.resources.getDimensionPixelSize(R.dimen.textMargin)
        set(value) {
            field = value
            textView()
        }

    var text = ""
        set(value) {
            field = value
            textView()
        }

    @ColorInt
    var textColor = ContextCompat.getColor(context, R.color.textColor)
        set(value) {
            field = value
            textView()
        }

    @ColorInt
    var textColorDisabled = ContextCompat.getColor(context, R.color.textColorDisabled)

    var textSizeUnit = TypedValue.COMPLEX_UNIT_PX
        set(value) {
            field = value
            textView()
        }

    @Dimension
    var textSize = context.resources.getDimensionPixelSize(R.dimen.textSize)
        set(value) {
            field = value
            textView()
        }

    @FontRes
    var textFontFamilyResId = -1
        set(value) {
            field = value
            textView()
        }

    var textIsAllCaps = true
        set(value) {
            field = value
            textView()
        }

    var iconPosition = STUCK
        set(value) {
            field = value
            imageView()
        }

    var iconHorizontalBias = 0.5f
        set(value) {
            field = value
            imageView()
        }

    var iconVerticalBias = 0.5f
        set(value) {
            field = value
            imageView()
        }

    var iconAlign = ALIGN_START
        set(value) {
            field = value
            imageView()
        }

    @Dimension
    var iconWidth = context.resources.getDimensionPixelSize(R.dimen.iconWidth)
        set(value) {
            field = value
            imageView()
        }

    @Dimension
    var iconHeight = context.resources.getDimensionPixelSize(R.dimen.iconHeight)
        set(value) {
            field = value
            imageView()
        }

    @Dimension
    var iconMarginTop = context.resources.getDimensionPixelSize(R.dimen.iconMargin)
        set(value) {
            field = value
            imageView()
        }

    @Dimension
    var iconMarginBottom = context.resources.getDimensionPixelSize(R.dimen.iconMargin)
        set(value) {
            field = value
            imageView()
        }

    @Dimension
    var iconMarginStart = context.resources.getDimensionPixelSize(R.dimen.iconMargin)
        set(value) {
            field = value
            imageView()
        }

    @Dimension
    var iconMarginEnd = context.resources.getDimensionPixelSize(R.dimen.iconMargin)
        set(value) {
            field = value
            imageView()
        }

    @DrawableRes
    var iconSrc = -1
        set(value) {
            field = value
            imageView()
        }

    @ColorInt
    var iconTint = ContextCompat.getColor(context, R.color.iconTint)
        set(value) {
            field = value
            imageView()
        }

    @ColorInt
    var iconTintDisabled = ContextCompat.getColor(context, R.color.iconTintDisabled)

    var iconScaleType = ImageView.ScaleType.FIT_CENTER
        set(value) {
            field = value
            imageView()
        }

    @Dimension
    var progressBarWidth = context.resources.getDimensionPixelSize(R.dimen.progressBarWidth)
        set(value) {
            field = value
            progressBar()
        }

    @Dimension
    var progressBarHeight = context.resources.getDimensionPixelSize(R.dimen.progressBarHeight)
        set(value) {
            field = value
            progressBar()
        }

    @Dimension
    var progressBarMarginTop = context.resources.getDimensionPixelSize(R.dimen.progressBarMargin)
        set(value) {
            field = value
            progressBar()
        }

    @Dimension
    var progressBarMarginBottom = context.resources.getDimensionPixelSize(R.dimen.progressBarMargin)
        set(value) {
            field = value
            progressBar()
        }

    @Dimension
    var progressBarMarginStart = context.resources.getDimensionPixelSize(R.dimen.progressBarMargin)
        set(value) {
            field = value
            progressBar()
        }

    @Dimension
    var progressBarMarginEnd = context.resources.getDimensionPixelSize(R.dimen.progressBarMargin)
        set(value) {
            field = value
            progressBar()
        }

    @ColorInt
    var progressBarColor = ContextCompat.getColor(context, R.color.progressBarColor)
        set(value) {
            field = value
            progressBar()
        }

    private val binding = LoadingButtonBinding.inflate(LayoutInflater.from(context), this, true)

    init {

        attrs?.let {

            val attributes = context.obtainStyledAttributes(it, R.styleable.LoadingButton)

            buttonColor = attributes.getColor(R.styleable.LoadingButton_buttonColor, buttonColor)
            buttonColorDisabled = attributes.getColor(R.styleable.LoadingButton_buttonColorDisabled, buttonColorDisabled)
            buttonStrokeColor = attributes.getColor(R.styleable.LoadingButton_buttonStrokeColor, buttonStrokeColor)
            buttonStrokeColorDisabled = attributes.getColor(R.styleable.LoadingButton_buttonStrokeColorDisabled, buttonStrokeColorDisabled)
            buttonStrokeWidth = attributes.getDimensionPixelSize(R.styleable.LoadingButton_buttonStrokeWidth, buttonStrokeWidth)
            buttonRippleColor = attributes.getColor(R.styleable.LoadingButton_buttonRippleColor, buttonRippleColor)
            buttonCornerRadius = attributes.getDimensionPixelSize(R.styleable.LoadingButton_buttonCornerRadius, buttonCornerRadius)

            textMarginTop = attributes.getDimensionPixelSize(R.styleable.LoadingButton_textMarginTop, textMarginTop)
            textMarginBottom = attributes.getDimensionPixelSize(R.styleable.LoadingButton_textMarginBottom, textMarginBottom)
            textMarginStart = attributes.getDimensionPixelSize(R.styleable.LoadingButton_textMarginStart, textMarginStart)
            textMarginEnd = attributes.getDimensionPixelSize(R.styleable.LoadingButton_textMarginEnd, textMarginEnd)
            text = if (attributes.hasValue(R.styleable.LoadingButton_text)) attributes.getString(R.styleable.LoadingButton_text)!! else text
            textColor = attributes.getColor(R.styleable.LoadingButton_textColor, textColor)
            textColorDisabled = attributes.getColor(R.styleable.LoadingButton_textColorDisabled, textColorDisabled)
            textSize = attributes.getDimensionPixelSize(R.styleable.LoadingButton_textSize, textSize)
            textFontFamilyResId = attributes.getResourceId(R.styleable.LoadingButton_textFontFamily, -1)
            textIsAllCaps = attributes.getBoolean(R.styleable.LoadingButton_textIsAllCaps, textIsAllCaps)

            iconPosition = attributes.getInt(R.styleable.LoadingButton_iconPosition, iconPosition)
            iconHorizontalBias = attributes.getFloat(R.styleable.LoadingButton_iconHorizontalBias, iconHorizontalBias)
            iconVerticalBias = attributes.getFloat(R.styleable.LoadingButton_iconVerticalBias, iconVerticalBias)
            iconAlign = attributes.getInt(R.styleable.LoadingButton_iconAlign, ALIGN_START)
            iconWidth = attributes.getLayoutDimension(R.styleable.LoadingButton_iconWidth, iconWidth)
            iconHeight = attributes.getLayoutDimension(R.styleable.LoadingButton_iconHeight, iconHeight)
            iconMarginTop = attributes.getDimensionPixelSize(R.styleable.LoadingButton_iconMarginTop, iconMarginTop)
            iconMarginBottom = attributes.getDimensionPixelSize(R.styleable.LoadingButton_iconMarginBottom, iconMarginBottom)
            iconMarginStart = attributes.getDimensionPixelSize(R.styleable.LoadingButton_iconMarginStart, iconMarginStart)
            iconMarginEnd = attributes.getDimensionPixelSize(R.styleable.LoadingButton_iconMarginEnd, iconMarginEnd)
            iconSrc = attributes.getResourceId(R.styleable.LoadingButton_iconSrc, iconSrc)
            iconTint = attributes.getColor(R.styleable.LoadingButton_iconTint, iconTint)
            iconTintDisabled = attributes.getColor(R.styleable.LoadingButton_iconTintDisabled, iconTintDisabled)
            iconScaleType = intToImageViewScaleType(attributes.getInt(R.styleable.LoadingButton_iconScaleType, imageViewScaleTypeToInt(iconScaleType)))

            progressBarWidth = attributes.getLayoutDimension(R.styleable.LoadingButton_progressBarWidth, progressBarWidth)
            progressBarHeight = attributes.getLayoutDimension(R.styleable.LoadingButton_progressBarHeight, progressBarHeight)
            progressBarMarginTop = attributes.getDimensionPixelSize(R.styleable.LoadingButton_progressBarMarginTop, progressBarMarginTop)
            progressBarMarginBottom = attributes.getDimensionPixelSize(R.styleable.LoadingButton_progressBarMarginBottom, progressBarMarginBottom)
            progressBarMarginStart = attributes.getDimensionPixelSize(R.styleable.LoadingButton_progressBarMarginStart, progressBarMarginStart)
            progressBarMarginEnd = attributes.getDimensionPixelSize(R.styleable.LoadingButton_progressBarMarginEnd, progressBarMarginEnd)
            progressBarColor = attributes.getColor(R.styleable.LoadingButton_progressBarColor, progressBarColor)

            isEnabled = attributes.getBoolean(R.styleable.LoadingButton_android_enabled, isEnabled)

            attributes.recycle()
        }

        isFocusable = true
        isClickable = true
        stateListAnimator = AnimatorInflater.loadStateListAnimator(context, R.xml.animate_scale)
    }

    private fun view() {

        val gradientDrawable = GradientDrawable()
        gradientDrawable.shape = GradientDrawable.RECTANGLE
        gradientDrawable.cornerRadius = buttonCornerRadius.toFloat()
        gradientDrawable.setColor(buttonColor)
        gradientDrawable.setStroke(buttonStrokeWidth, buttonStrokeColor)

        val rippleDrawable = RippleDrawable(ColorStateList.valueOf(buttonRippleColor), gradientDrawable, null)

        background = rippleDrawable
    }

    private fun textView() {

        binding.textView.isVisible = text.isNotEmpty()

        binding.textView.text = text

        binding.textView.setTextColor(textColor)

        binding.textView.setTextSize(textSizeUnit, textSize.toFloat())

        binding.textView.isAllCaps = textIsAllCaps

        if (textFontFamilyResId != -1) {
            binding.textView.typeface = ResourcesCompat.getFont(context, textFontFamilyResId)
        }

        val constraintSet = ConstraintSet()
        constraintSet.clone(binding.root)

        if (iconPosition == STUCK && binding.imageView.isVisible) {

            when (iconAlign) {

                ALIGN_START -> {

                    constraintSet.connect(binding.textView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, textMarginBottom)
                    constraintSet.connect(binding.textView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, textMarginEnd)
                    constraintSet.connect(binding.textView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, textMarginTop)
                }

                ALIGN_END -> {

                    constraintSet.connect(binding.textView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, textMarginBottom)
                    constraintSet.connect(binding.textView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, textMarginStart)
                    constraintSet.connect(binding.textView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, textMarginTop)
                }

                ALIGN_CENTER -> {
                    constraintSet.connect(binding.textView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, textMarginBottom)
                    constraintSet.connect(binding.textView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, textMarginEnd)
                    constraintSet.connect(binding.textView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, textMarginStart)
                    constraintSet.connect(binding.textView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, textMarginTop)
                }

                ALIGN_TOP -> {

                    constraintSet.connect(binding.textView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, textMarginBottom)
                    constraintSet.connect(binding.textView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, textMarginEnd)
                    constraintSet.connect(binding.textView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, textMarginStart)
                }

                ALIGN_BOTTOM -> {

                    constraintSet.connect(binding.textView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, textMarginEnd)
                    constraintSet.connect(binding.textView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, textMarginStart)
                    constraintSet.connect(binding.textView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, textMarginTop)
                }
            }

        } else {

            constraintSet.connect(binding.textView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, textMarginBottom)
            constraintSet.connect(binding.textView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, textMarginEnd)
            constraintSet.connect(binding.textView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, textMarginStart)
            constraintSet.connect(binding.textView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, textMarginTop)
        }

        constraintSet.applyTo(binding.root)
    }

    private fun imageView() {

        binding.imageView.layoutParams = LayoutParams(iconWidth, iconHeight)

        binding.imageView.isVisible = iconSrc != -1

        if (iconSrc != -1) binding.imageView.setImageResource(iconSrc)

        if (iconTint != 1) binding.imageView.imageTintList = ColorStateList.valueOf(iconTint)

        binding.imageView.scaleType = iconScaleType

        val constraintSet = ConstraintSet()
        constraintSet.clone(binding.root)

        if (iconPosition == STUCK) {

            if (binding.imageView.isVisible && binding.textView.isVisible) {

                when (iconAlign) {

                    ALIGN_START -> {

                        constraintSet.connect(binding.imageView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, iconMarginBottom)
                        constraintSet.connect(binding.imageView.id, ConstraintSet.END, binding.textView.id, ConstraintSet.START, iconMarginEnd)
                        constraintSet.connect(binding.imageView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, iconMarginStart)
                        constraintSet.connect(binding.imageView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, iconMarginTop)
                        constraintSet.clear(binding.textView.id, ConstraintSet.START)
                    }

                    ALIGN_END -> {

                        constraintSet.connect(binding.imageView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, iconMarginBottom)
                        constraintSet.connect(binding.imageView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, iconMarginEnd)
                        constraintSet.connect(binding.imageView.id, ConstraintSet.START, binding.textView.id, ConstraintSet.END, iconMarginStart)
                        constraintSet.connect(binding.imageView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, iconMarginTop)
                        constraintSet.clear(binding.textView.id, ConstraintSet.END)
                    }

                    ALIGN_CENTER -> {

                        constraintSet.connect(binding.imageView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, iconMarginBottom)
                        constraintSet.connect(binding.imageView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, iconMarginEnd)
                        constraintSet.connect(binding.imageView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, iconMarginStart)
                        constraintSet.connect(binding.imageView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, iconMarginTop)
                    }

                    ALIGN_TOP -> {

                        constraintSet.connect(binding.imageView.id, ConstraintSet.BOTTOM, binding.textView.id, ConstraintSet.TOP, iconMarginBottom)
                        constraintSet.connect(binding.imageView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, iconMarginEnd)
                        constraintSet.connect(binding.imageView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, iconMarginStart)
                        constraintSet.connect(binding.imageView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, iconMarginTop)
                        constraintSet.clear(binding.textView.id, ConstraintSet.TOP)
                    }

                    ALIGN_BOTTOM -> {

                        constraintSet.connect(binding.imageView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, iconMarginBottom)
                        constraintSet.connect(binding.imageView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, iconMarginEnd)
                        constraintSet.connect(binding.imageView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, iconMarginStart)
                        constraintSet.connect(binding.imageView.id, ConstraintSet.TOP, binding.textView.id, ConstraintSet.BOTTOM, iconMarginTop)
                        constraintSet.clear(binding.textView.id, ConstraintSet.BOTTOM)
                        constraintSet.applyTo(binding.root)
                    }
                }

            } else {

                constraintSet.connect(binding.imageView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, iconMarginBottom)
                constraintSet.connect(binding.imageView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, iconMarginEnd)
                constraintSet.connect(binding.imageView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, iconMarginStart)
                constraintSet.connect(binding.imageView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, iconMarginTop)
            }

        } else {

            constraintSet.connect(binding.imageView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, iconMarginBottom)
            constraintSet.connect(binding.imageView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, iconMarginEnd)
            constraintSet.connect(binding.imageView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, iconMarginStart)
            constraintSet.connect(binding.imageView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, iconMarginTop)

            constraintSet.setHorizontalBias(binding.imageView.id, iconHorizontalBias)
            constraintSet.setVerticalBias(binding.imageView.id, iconVerticalBias)
        }

        constraintSet.applyTo(binding.root)

        textView()
    }

    private fun progressBar() {

        binding.progressBar.layoutParams = LayoutParams(progressBarWidth, progressBarHeight)

        binding.progressBar.indeterminateTintList = ColorStateList.valueOf(progressBarColor)

        val constraintSet = ConstraintSet()

        constraintSet.clone(binding.root)
        constraintSet.connect(binding.progressBar.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, progressBarMarginBottom)
        constraintSet.connect(binding.progressBar.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, progressBarMarginEnd)
        constraintSet.connect(binding.progressBar.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, progressBarMarginStart)
        constraintSet.connect(binding.progressBar.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, progressBarMarginTop)

        constraintSet.applyTo(binding.root)
    }

    private fun handleIsLoading() {

        if (isLoading) {

            isEnabled = false

            binding.progressBar.isVisible = true
            binding.progressBar.animate().cancel()
            binding.progressBar.animate().scaleX(1f).scaleY(1f).alpha(1f).setDuration(125).start()

            binding.imageView.animate().cancel()
            binding.imageView.animate().scaleX(0.85f).scaleY(0.85f).alpha(0f).setDuration(125).start()

            binding.textView.animate().cancel()
            binding.textView.animate().scaleX(0.85f).scaleY(0.85f).alpha(0f).setDuration(125).start()

        } else {

            isEnabled = true

            binding.progressBar.animate().cancel()
            binding.progressBar.animate().scaleX(0.75f).scaleY(0.75f).alpha(0f).setDuration(125).withEndAction {
                binding.progressBar.visibility = View.GONE
            }.start()

            //if (binding.imageView.isVisible) {
                binding.imageView.animate().cancel()
                binding.imageView.animate().scaleX(1f).scaleY(1f).alpha(1f).setDuration(125).start()
            //}

            //if (binding.textView.isVisible) {
                binding.textView.animate().cancel()
                binding.textView.animate().scaleX(1f).scaleY(1f).alpha(1f).setDuration(125).start()
            //}
        }
    }

    private fun imageViewScaleTypeToInt(scaleType: ImageView.ScaleType): Int {

        when (scaleType) {

            ImageView.ScaleType.MATRIX -> {
                return 0
            }

            ImageView.ScaleType.FIT_XY -> {
                return 1
            }

            ImageView.ScaleType.FIT_START -> {
                return 2
            }

            ImageView.ScaleType.FIT_CENTER -> {
                return 3
            }

            ImageView.ScaleType.FIT_END -> {
                return 4
            }

            ImageView.ScaleType.CENTER -> {
                return 5
            }

            ImageView.ScaleType.CENTER_CROP -> {
                return 6
            }

            ImageView.ScaleType.CENTER_INSIDE -> {
                return 7
            }

            else -> {
                return 3
            }
        }
    }

    private fun intToImageViewScaleType(i: Int): ImageView.ScaleType {

        when (i) {

            0 -> {
                return ImageView.ScaleType.MATRIX
            }

            1 -> {
                return ImageView.ScaleType.FIT_XY
            }

            2 -> {
                return ImageView.ScaleType.FIT_START
            }

            3 -> {
                return ImageView.ScaleType.FIT_CENTER
            }

            4 -> {
                return ImageView.ScaleType.FIT_END
            }

            5 -> {
                return ImageView.ScaleType.CENTER
            }

            6 -> {
                return ImageView.ScaleType.CENTER_CROP
            }

            7 -> {
                return ImageView.ScaleType.CENTER_INSIDE
            }
        }

        return ImageView.ScaleType.FIT_CENTER
    }

    fun hide() {

        if (visibility == View.INVISIBLE || visibility == View.GONE) return

        scaleX = 1f
        scaleY = 1f
        alpha = 1f

        animate().cancel()
        animate().scaleX(0.85f).scaleY(0.85f).alpha(0f).setDuration(100).setInterpolator(FastOutSlowInInterpolator()).withEndAction {
            visibility = View.GONE
        }.start()
    }

    fun show() {

        if (visibility == VISIBLE) return

        visibility = View.VISIBLE

        scaleX = 0.85f
        scaleY = 0.85f
        alpha = 0f

        animate().cancel()
        animate().scaleX(1f).scaleY(1f).alpha(1f).setDuration(100).setInterpolator(FastOutSlowInInterpolator()).start()
    }

    override fun setEnabled(enabled: Boolean) {

        if (enabled == isEnabled) return

        if (enabled) {

            val buttonColorValueAnimator = ValueAnimator.ofObject(ArgbEvaluator(), buttonColorDisabled, buttonColor)
            buttonColorValueAnimator.duration = 150
            buttonColorValueAnimator.addUpdateListener { animator ->
                val gradientDrawable = GradientDrawable()
                gradientDrawable.shape = GradientDrawable.RECTANGLE
                gradientDrawable.cornerRadius = buttonCornerRadius.toFloat()
                gradientDrawable.setColor(animator.animatedValue as Int)
                gradientDrawable.setStroke(buttonStrokeWidth, buttonStrokeColor)
                val rippleDrawable = RippleDrawable(ColorStateList.valueOf(buttonRippleColor), gradientDrawable, null)
                background = rippleDrawable
            }
            buttonColorValueAnimator.start()

            val textColorValueAnimator = ValueAnimator.ofObject(ArgbEvaluator(), textColorDisabled, textColor)
            textColorValueAnimator.duration = 150
            textColorValueAnimator.addUpdateListener { animator ->
                binding.textView.setTextColor(animator.animatedValue as Int)
            }
            textColorValueAnimator.start()

            val iconTintValueAnimator = ValueAnimator.ofObject(ArgbEvaluator(), iconTintDisabled, iconTint)
            iconTintValueAnimator.duration = 150
            iconTintValueAnimator.addUpdateListener { animator ->
                binding.imageView.imageTintList = ColorStateList.valueOf(animator.animatedValue as Int)
            }
            iconTintValueAnimator.start()

        } else {

            val buttonColorValueAnimator = ValueAnimator.ofObject(ArgbEvaluator(), buttonColor, buttonColorDisabled)
            buttonColorValueAnimator.duration = 150
            buttonColorValueAnimator.addUpdateListener { animator ->
                val gradientDrawable = GradientDrawable()
                gradientDrawable.shape = GradientDrawable.RECTANGLE
                gradientDrawable.cornerRadius = buttonCornerRadius.toFloat()
                gradientDrawable.setColor(animator.animatedValue as Int)
                gradientDrawable.setStroke(buttonStrokeWidth, buttonStrokeColorDisabled)
                val rippleDrawable = RippleDrawable(ColorStateList.valueOf(buttonRippleColor), gradientDrawable, null)
                background = rippleDrawable
            }
            buttonColorValueAnimator.start()

            val textColorValueAnimator = ValueAnimator.ofObject(ArgbEvaluator(), textColor, textColorDisabled)
            textColorValueAnimator.duration = 150
            textColorValueAnimator.addUpdateListener { animator ->
                binding.textView.setTextColor(animator.animatedValue as Int)
            }
            textColorValueAnimator.start()

            val iconTintValueAnimator = ValueAnimator.ofObject(ArgbEvaluator(), iconTint, iconTintDisabled)
            iconTintValueAnimator.duration = 150
            iconTintValueAnimator.addUpdateListener { animator ->
                binding.imageView.imageTintList = ColorStateList.valueOf(animator.animatedValue as Int)
            }
            iconTintValueAnimator.start()
        }

        super.setEnabled(enabled)
    }
}




































