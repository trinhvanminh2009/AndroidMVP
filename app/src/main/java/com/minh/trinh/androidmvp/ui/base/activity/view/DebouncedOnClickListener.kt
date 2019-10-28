package com.minh.trinh.androidmvp.ui.base.activity.view


import android.os.SystemClock
import android.view.View
import java.util.WeakHashMap

/**
 * A Debounced OnClickListener
 * Rejects clicks that are too close together in time.
 * This class is safe to use as an OnClickListener for multiple views, and will debounce each one separately.
 */
abstract class DebouncedOnClickListener
/**
 * The one and only constructor
 * @param minimumIntervalMsec The minimum allowed time between clicks - any click sooner than this after a previous click will be rejected
 */
    (private val minimumInterval: Long) : View.OnClickListener {
    private val lastClickMap: MutableMap<View, Long>

    /**
     * Implement this in your subclass instead of onClick
     * @param v The view that was clicked
     */
    abstract fun onDebouncedClick(v: View)

    init {
        this.lastClickMap = WeakHashMap()
    }

    override fun onClick(clickedView: View) {
        val previousClickTimestamp = lastClickMap[clickedView]
        val currentTimestamp = SystemClock.uptimeMillis()

        lastClickMap[clickedView] = currentTimestamp
        if (previousClickTimestamp == null || Math.abs(currentTimestamp - previousClickTimestamp.toLong()) > minimumInterval) {
            onDebouncedClick(clickedView)
        }
    }
}