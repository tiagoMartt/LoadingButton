package com.tmrtapps.loadingbutton

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.RippleDrawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.OnFocusChangeListener
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
    var color = ContextCompat.getColor(context, R.color.color)
        set(value) {
            field = value
            handleView()
        }

    @ColorInt
    var colorDisabled = ContextCompat.getColor(context, R.color.colorDisabled)

    var strokeWidth = context.resources.getDimensionPixelSize(R.dimen.strokeWidth)
        set(value) {
            field = value
            handleView()
        }

    @ColorInt
    var rippleColor = ContextCompat.getColor(context, R.color.rippleColor)
        set(value) {
            field = value
            handleView()
        }

    var cornerRadius = context.resources.getDimensionPixelSize(R.dimen.cornerRadius)
        set(value) {
            field = value
            handleView()
        }

    @ColorInt
    var strokeColor = 0
        set(value) {
            field = value
            handleView()
        }

    @ColorInt
    var strokeColorDisabled = ContextCompat.getColor(context, R.color.strokeColorDisabled)
        set(value) {
            field = value
        }

    var textViewMarginTop = context.resources.getDimensionPixelSize(R.dimen.textViewMargin)
        set(value) {
            field = value
            handleTextView()
        }

    var textViewMarginBottom = context.resources.getDimensionPixelSize(R.dimen.textViewMargin)
        set(value) {
            field = value
            handleTextView()
        }

    var textViewMarginStart = context.resources.getDimensionPixelSize(R.dimen.textViewMargin)
        set(value) {
            field = value
            handleTextView()
        }

    var textViewMarginEnd = context.resources.getDimensionPixelSize(R.dimen.textViewMargin)
        set(value) {
            field = value
            handleTextView()
        }

    var text = ""
        set(value) {
            field = value
            handleTextView()
        }

    @ColorInt
    var textColor = ContextCompat.getColor(context, R.color.textColor)
        set(value) {
            field = value
            handleTextView()
        }

    @ColorInt
    var textColorDisabled = ContextCompat.getColor(context, R.color.textColorDisabled)

    var textSizeUnit = TypedValue.COMPLEX_UNIT_PX
        set(value) {
            field = value
            handleTextView()
        }

    var textSize = context.resources.getDimensionPixelSize(R.dimen.textSize)
        set(value) {
            field = value
            handleTextView()
        }

    @FontRes
    var fontFamilyResId = -1
        set(value) {
            field = value
            handleTextView()
        }

    var textIsAllCaps = true
        set(value) {
            field = value
            handleTextView()
        }

    var imageViewPosition = STUCK
        set(value) {
            field = value
            handleImageView()
        }

    var imageViewHorizontalBias = 0.5f
        set(value) {
            field = value
            handleImageView()
        }

    var imageViewVerticalBias = 0.5f
        set(value) {
            field = value
            handleImageView()
        }

    var imageViewAlign = ALIGN_START
        set(value) {
            field = value
            handleImageView()
        }

    var imageViewWidth = context.resources.getDimensionPixelSize(R.dimen.imageViewWidth)
        set(value) {
            field = value
            handleImageView()
        }

    var imageViewHeight = context.resources.getDimensionPixelSize(R.dimen.imageViewHeight)
        set(value) {
            field = value
            handleImageView()
        }

    var imageViewMarginTop = context.resources.getDimensionPixelSize(R.dimen.imageViewMargin)
        set(value) {
            field = value
            handleImageView()
        }

    var imageViewMarginBottom = context.resources.getDimensionPixelSize(R.dimen.imageViewMargin)
        set(value) {
            field = value
            handleImageView()
        }

    var imageViewMarginStart = context.resources.getDimensionPixelSize(R.dimen.imageViewMargin)
        set(value) {
            field = value
            handleImageView()
        }

    var imageViewMarginEnd = context.resources.getDimensionPixelSize(R.dimen.imageViewMargin)
        set(value) {
            field = value
            handleImageView()
        }

    @DrawableRes
    var imageViewSrcId = -1
        set(value) {
            field = value
            handleImageView()
        }

    @ColorInt
    var imageTint = 1
        set(value) {
            field = value
            handleImageView()
        }

    @ColorInt
    var imageTintDisabled = 1

    var imageScaleType = ImageView.ScaleType.FIT_CENTER
        set(value) {
            field = value
            handleImageView()
        }

    var progressBarWidth = context.resources.getDimensionPixelSize(R.dimen.imageViewWidth)
        set(value) {
            field = value
            handleProgressBar()
        }

    var progressBarHeight = context.resources.getDimensionPixelSize(R.dimen.imageViewHeight)
        set(value) {
            field = value
            handleProgressBar()
        }

    var progressBarMarginTop = context.resources.getDimensionPixelSize(R.dimen.progressBarMargin)
        set(value) {
            field = value
            handleProgressBar()
        }

    var progressBarMarginBottom = context.resources.getDimensionPixelSize(R.dimen.progressBarMargin)
        set(value) {
            field = value
            handleProgressBar()
        }

    var progressBarMarginStart = context.resources.getDimensionPixelSize(R.dimen.progressBarMargin)
        set(value) {
            field = value
            handleProgressBar()
        }

    var progressBarMarginEnd = context.resources.getDimensionPixelSize(R.dimen.progressBarMargin)
        set(value) {
            field = value
            handleProgressBar()
        }

    @ColorInt
    var progressBarColor = ContextCompat.getColor(context, R.color.progressBarColor)
        set(value) {
            field = value
            handleProgressBar()
        }

    private val binding = LoadingButtonBinding.inflate(LayoutInflater.from(context), this, true)

    init {

        attrs?.let {

            val attributes = context.obtainStyledAttributes(it, R.styleable.LoadingButton)

            color = attributes.getColor(R.styleable.LoadingButton_color, color)
            colorDisabled = attributes.getColor(R.styleable.LoadingButton_colorDisabled, colorDisabled)
            cornerRadius = attributes.getDimensionPixelSize(R.styleable.LoadingButton_cornerRadius, cornerRadius)
            strokeWidth = attributes.getDimensionPixelSize(R.styleable.LoadingButton_strokeWidth, strokeWidth)
            strokeColor = attributes.getColor(R.styleable.LoadingButton_strokeColor, strokeColor)
            strokeColorDisabled = attributes.getColor(R.styleable.LoadingButton_strokeColorDisabled, strokeColorDisabled)
            rippleColor = attributes.getColor(R.styleable.LoadingButton_rippleColor, rippleColor)

            textViewMarginTop = attributes.getDimensionPixelSize(R.styleable.LoadingButton_textViewMarginTop, textViewMarginTop)
            textViewMarginBottom = attributes.getDimensionPixelSize(R.styleable.LoadingButton_textViewMarginBottom, textViewMarginBottom)
            textViewMarginStart = attributes.getDimensionPixelSize(R.styleable.LoadingButton_textViewMarginStart, textViewMarginStart)
            textViewMarginEnd = attributes.getDimensionPixelSize(R.styleable.LoadingButton_textViewMarginEnd, textViewMarginEnd)
            text = if (attributes.hasValue(R.styleable.LoadingButton_text)) attributes.getString(R.styleable.LoadingButton_text)!! else text
            textColor = attributes.getColor(R.styleable.LoadingButton_textColor, textColor)
            textColorDisabled = attributes.getColor(R.styleable.LoadingButton_textColorDisabled, textColorDisabled)
            textSize = attributes.getDimensionPixelSize(R.styleable.LoadingButton_textSize, textSize)
            fontFamilyResId = attributes.getResourceId(R.styleable.LoadingButton_fontFamily, -1)
            textIsAllCaps = attributes.getBoolean(R.styleable.LoadingButton_textIsAllCaps, textIsAllCaps)

            imageViewPosition = attributes.getInt(R.styleable.LoadingButton_imageViewPosition, imageViewPosition)
            imageViewHorizontalBias = attributes.getFloat(R.styleable.LoadingButton_imageViewHorizontalBias, imageViewHorizontalBias)
            imageViewVerticalBias = attributes.getFloat(R.styleable.LoadingButton_imageViewVerticalBias, imageViewVerticalBias)
            imageViewAlign = attributes.getInt(R.styleable.LoadingButton_imageViewAlign, ALIGN_START)
            imageViewWidth = attributes.getLayoutDimension(R.styleable.LoadingButton_imageViewWidth, imageViewWidth)
            imageViewHeight = attributes.getLayoutDimension(R.styleable.LoadingButton_imageViewHeight, imageViewHeight)
            imageViewMarginTop = attributes.getDimensionPixelSize(R.styleable.LoadingButton_imageViewMarginTop, imageViewMarginTop)
            imageViewMarginBottom = attributes.getDimensionPixelSize(R.styleable.LoadingButton_imageViewMarginBottom, imageViewMarginBottom)
            imageViewMarginStart = attributes.getDimensionPixelSize(R.styleable.LoadingButton_imageViewMarginStart, imageViewMarginStart)
            imageViewMarginEnd = attributes.getDimensionPixelSize(R.styleable.LoadingButton_imageViewMarginEnd, imageViewMarginEnd)
            imageViewSrcId = attributes.getResourceId(R.styleable.LoadingButton_imageViewSrcId, imageViewSrcId)
            imageTint = attributes.getColor(R.styleable.LoadingButton_imageViewTint, imageTint)
            imageTintDisabled = attributes.getColor(R.styleable.LoadingButton_imageViewTintDisabled, imageTintDisabled)
            imageScaleType = intToImageViewScaleType(attributes.getInt(R.styleable.LoadingButton_imageViewScaleType, 3))

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

        onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->

            if (hasOnClickListeners()) {

                if (hasFocus) {
                    animate().cancel()
                    animate().scaleY(0.90f).scaleX(0.90f).setDuration(100).start()
                } else {
                    animate().cancel()
                    animate().scaleY(1.0f).scaleX(1.0f).setDuration(100).start()
                }
            }
        }
    }

    private fun handleView() {

        val gradientDrawable = GradientDrawable()
        gradientDrawable.shape = GradientDrawable.RECTANGLE
        gradientDrawable.cornerRadius = cornerRadius.toFloat()
        gradientDrawable.setColor(color)
        gradientDrawable.setStroke(strokeWidth, strokeColor)

        val rippleDrawable = RippleDrawable(ColorStateList.valueOf(rippleColor), gradientDrawable, null)

        background = rippleDrawable
    }

    private fun handleTextView() {

        binding.textView.visibility = if (text.isNotEmpty()) View.VISIBLE else View.GONE

        binding.textView.text = text

        binding.textView.setTextColor(textColor)

        binding.textView.setTextSize(textSizeUnit, textSize.toFloat())

        if (fontFamilyResId != -1) {
            binding.textView.typeface = ResourcesCompat.getFont(context, fontFamilyResId)
        }

        binding.textView.isAllCaps = textIsAllCaps

        val constraintSet = ConstraintSet()
        constraintSet.clone(binding.root)

        if (imageViewPosition == STUCK) {

            if (imageViewSrcId != -1) {

                when (imageViewAlign) {

                    ALIGN_START -> {

                        constraintSet.connect(binding.textView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, textViewMarginBottom)
                        constraintSet.connect(binding.textView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, textViewMarginEnd)
                        constraintSet.connect(binding.textView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, textViewMarginTop)
                    }

                    ALIGN_END -> {

                        constraintSet.connect(binding.textView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, textViewMarginBottom)
                        constraintSet.connect(binding.textView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, textViewMarginStart)
                        constraintSet.connect(binding.textView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, textViewMarginTop)
                    }

                    ALIGN_CENTER -> {
                        constraintSet.connect(binding.textView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, textViewMarginBottom)
                        constraintSet.connect(binding.textView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, textViewMarginEnd)
                        constraintSet.connect(binding.textView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, textViewMarginTop)
                        constraintSet.connect(binding.textView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, textViewMarginTop)
                    }

                    ALIGN_TOP -> {

                        constraintSet.connect(binding.textView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, textViewMarginBottom)
                        constraintSet.connect(binding.textView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, textViewMarginEnd)
                        constraintSet.connect(binding.textView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, textViewMarginStart)
                    }

                    ALIGN_BOTTOM -> {

                        constraintSet.connect(binding.textView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, textViewMarginEnd)
                        constraintSet.connect(binding.textView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, textViewMarginStart)
                        constraintSet.connect(binding.textView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, textViewMarginTop)
                    }
                }

            } else {

                constraintSet.connect(binding.textView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, textViewMarginBottom)
                constraintSet.connect(binding.textView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, textViewMarginEnd)
                constraintSet.connect(binding.textView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, textViewMarginTop)
                constraintSet.connect(binding.textView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, textViewMarginTop)
            }

        } else {

            constraintSet.connect(binding.textView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, textViewMarginBottom)
            constraintSet.connect(binding.textView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, textViewMarginEnd)
            constraintSet.connect(binding.textView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, textViewMarginTop)
            constraintSet.connect(binding.textView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, textViewMarginTop)
        }

        constraintSet.applyTo(binding.root)
    }

    private fun handleImageView() {

        binding.imageView.layoutParams = LayoutParams(imageViewWidth, imageViewHeight)

        binding.imageView.visibility = if (imageViewSrcId != -1) View.VISIBLE else View.GONE

        if (imageViewSrcId != -1) binding.imageView.setImageResource(imageViewSrcId)

        if (imageTint != 1) binding.imageView.imageTintList = ColorStateList.valueOf(imageTint)

        binding.imageView.scaleType = imageScaleType

        val constraintSet = ConstraintSet()
        constraintSet.clone(binding.root)

        if (imageViewPosition == STUCK) {

            if (binding.imageView.isVisible) {

                if (binding.textView.isVisible) {

                    when (imageViewAlign) {

                        ALIGN_START -> {

                            constraintSet.connect(binding.imageView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, imageViewMarginBottom)
                            constraintSet.connect(binding.imageView.id, ConstraintSet.END, binding.textView.id, ConstraintSet.START, imageViewMarginEnd)
                            constraintSet.connect(binding.imageView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, imageViewMarginStart)
                            constraintSet.connect(binding.imageView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, imageViewMarginTop)
                            constraintSet.clear(binding.textView.id, ConstraintSet.START)
                        }

                        ALIGN_END -> {

                            constraintSet.connect(binding.imageView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, imageViewMarginBottom)
                            constraintSet.connect(binding.imageView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, imageViewMarginEnd)
                            constraintSet.connect(binding.imageView.id, ConstraintSet.START, binding.textView.id, ConstraintSet.END, imageViewMarginStart)
                            constraintSet.connect(binding.imageView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, imageViewMarginTop)
                            constraintSet.clear(binding.textView.id, ConstraintSet.END)
                        }

                        ALIGN_CENTER -> {

                            constraintSet.connect(binding.imageView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, imageViewMarginBottom)
                            constraintSet.connect(binding.imageView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, imageViewMarginEnd)
                            constraintSet.connect(binding.imageView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, imageViewMarginStart)
                            constraintSet.connect(binding.imageView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, imageViewMarginTop)
                        }

                        ALIGN_TOP -> {

                            constraintSet.connect(binding.imageView.id, ConstraintSet.BOTTOM, binding.textView.id, ConstraintSet.TOP, imageViewMarginBottom)
                            constraintSet.connect(binding.imageView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, imageViewMarginEnd)
                            constraintSet.connect(binding.imageView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, imageViewMarginStart)
                            constraintSet.connect(binding.imageView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, imageViewMarginTop)
                            constraintSet.clear(binding.textView.id, ConstraintSet.TOP)
                        }

                        ALIGN_BOTTOM -> {

                            constraintSet.connect(binding.imageView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, imageViewMarginBottom)
                            constraintSet.connect(binding.imageView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, imageViewMarginEnd)
                            constraintSet.connect(binding.imageView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, imageViewMarginStart)
                            constraintSet.connect(binding.imageView.id, ConstraintSet.TOP, binding.textView.id, ConstraintSet.BOTTOM, imageViewMarginTop)
                            constraintSet.clear(binding.textView.id, ConstraintSet.BOTTOM)
                            constraintSet.applyTo(binding.root)
                        }
                    }

                } else {

                    constraintSet.connect(binding.imageView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, imageViewMarginBottom)
                    constraintSet.connect(binding.imageView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, imageViewMarginEnd)
                    constraintSet.connect(binding.imageView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, imageViewMarginStart)
                    constraintSet.connect(binding.imageView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, imageViewMarginTop)
                }

            } else {

                constraintSet.connect(binding.imageView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, imageViewMarginBottom)
                constraintSet.connect(binding.imageView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, imageViewMarginEnd)
                constraintSet.connect(binding.imageView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, imageViewMarginStart)
                constraintSet.connect(binding.imageView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, imageViewMarginTop)
            }

        } else {

            constraintSet.connect(binding.imageView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, imageViewMarginBottom)
            constraintSet.connect(binding.imageView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, imageViewMarginEnd)
            constraintSet.connect(binding.imageView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, imageViewMarginStart)
            constraintSet.connect(binding.imageView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, imageViewMarginTop)

            constraintSet.setHorizontalBias(binding.imageView.id, imageViewHorizontalBias)
            constraintSet.setVerticalBias(binding.imageView.id, imageViewVerticalBias)
        }

        constraintSet.applyTo(binding.root)

        handleTextView()
    }

    private fun handleProgressBar() {

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

            binding.progressBar.visibility = View.VISIBLE
            binding.progressBar.animate().cancel()
            binding.progressBar.animate().scaleX(1f).scaleY(1f).alpha(1f).setDuration(125).start()

            if (imageViewSrcId != -1) {
                binding.imageView.animate().cancel()
                binding.imageView.animate().scaleX(0.75f).scaleY(0.75f).alpha(0f).setDuration(125).withEndAction {
                    binding.imageView.visibility = View.INVISIBLE
                }.start()
            }

            binding.textView.animate().cancel()
            binding.textView.animate().scaleX(0.75f).scaleY(0.75f).alpha(0f).setDuration(125).withEndAction {
                binding.textView.visibility = View.INVISIBLE
            }.start()

            animate().cancel()
            animate().alpha(0.6f).setDuration(200).start()

        } else {

            isEnabled = true

            binding.progressBar.animate().cancel()
            binding.progressBar.animate().scaleX(0.75f).scaleY(0.75f).alpha(0f).setDuration(125).withEndAction {
                binding.progressBar.visibility = View.GONE
            }.start()

            if (imageViewSrcId != -1) {
                binding.imageView.visibility = View.VISIBLE
                binding.imageView.animate().cancel()
                binding.imageView.animate().scaleX(1f).scaleY(1f).alpha(1f).setDuration(125).start()
            }

            binding.textView.visibility = View.VISIBLE
            binding.textView.animate().cancel()
            binding.textView.animate().scaleX(1f).scaleY(1f).alpha(1f).setDuration(125).start()

            animate().cancel()
            animate().alpha(1f).setDuration(200).start()
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

        animate().cancel()
        animate().scaleX(0.85f).scaleY(0.85f).alpha(0f).setDuration(100).setInterpolator(FastOutSlowInInterpolator()).withEndAction {
            visibility = View.GONE
        }.start()
    }

    fun show() {

        if (visibility == VISIBLE) return

        visibility = View.VISIBLE

        animate().cancel()
        animate().scaleX(1f).scaleY(1f).alpha(if (isEnabled) 1f else 0.6f).setDuration(100).setInterpolator(FastOutSlowInInterpolator()).start()
    }

    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)

        if (isLoading) {
            return
        }

        if (enabled) {

            val gradientDrawable = GradientDrawable()
            gradientDrawable.shape = GradientDrawable.RECTANGLE
            gradientDrawable.cornerRadius = cornerRadius.toFloat()
            gradientDrawable.setColor(color)
            gradientDrawable.setStroke(strokeWidth, strokeColor)
            val rippleDrawable = RippleDrawable(ColorStateList.valueOf(rippleColor), gradientDrawable, null)
            background = rippleDrawable

            binding.textView.setTextColor(textColor)

            if (imageTint != 1) binding.imageView.imageTintList = ColorStateList.valueOf(imageTint)

        } else {

            val gradientDrawable = GradientDrawable()
            gradientDrawable.shape = GradientDrawable.RECTANGLE
            gradientDrawable.cornerRadius = cornerRadius.toFloat()
            gradientDrawable.setColor(colorDisabled)
            gradientDrawable.setStroke(strokeWidth, strokeColorDisabled)
            val rippleDrawable = RippleDrawable(ColorStateList.valueOf(rippleColor), gradientDrawable, null)
            background = rippleDrawable

            binding.textView.setTextColor(textColorDisabled)

            if (imageTintDisabled != 1) binding.imageView.imageTintList = ColorStateList.valueOf(imageTintDisabled)
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun setOnClickListener(l: OnClickListener?) {
        super.setOnClickListener(l)

        if (l != null) {

            setOnTouchListener { _, event ->

                if (event.action == MotionEvent.ACTION_DOWN) {
                    animate().cancel()
                    animate().scaleY(0.90f).scaleX(0.90f).setDuration(100).start()
                }

                if (event.action == MotionEvent.ACTION_UP) {
                    animate().cancel()
                    animate().scaleY(1.0f).scaleX(1.0f).setDuration(100).start()
                }

                return@setOnTouchListener false
            }

        } else {

            setOnTouchListener(null)
        }
    }
}




































