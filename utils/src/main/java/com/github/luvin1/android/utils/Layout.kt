package com.github.luvin1.android.utils

import android.content.Context
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout

object Layout {

    const val MATCH_PARENT: Int = -1
    const val WRAP_CONTENT: Int = -2

    private var density: Float = 0f
    fun initialize(context: Context) {
        density = context.resources.displayMetrics.density
    }

    private fun size(size: Int): Int {
        if (density == 0f) throw RuntimeException("You must call Layout.initialize(Context) before using Dp methods.")
        return if (size > 0) (size * density).toInt() else size
    }

    /*
        ViewGroup
     */

    fun any(
        width: Int, height: Int,
        leftMargin: Int, topMargin: Int, rightMargin: Int, bottomMargin: Int
    ): ViewGroup.MarginLayoutParams {
        return ViewGroup.MarginLayoutParams(size(width), size(height)).apply {
            setMargins(size(leftMargin), size(topMargin), size(rightMargin), size(bottomMargin))
        }
    }

    fun any(width: Int, height: Int): ViewGroup.LayoutParams {
        return ViewGroup.LayoutParams(size(width), size(height))
    }

    /*
        FrameLayout
     */

    fun frame(
        width: Int, height: Int,
        gravity: Int,
        leftMargin: Int, topMargin: Int, rightMargin: Int, bottomMargin: Int
    ): FrameLayout.LayoutParams {
        return frame(width, height, leftMargin, topMargin, rightMargin, bottomMargin).apply {
            this.gravity = gravity
        }
    }

    fun frame(
        width: Int, height: Int,
        leftMargin: Int, topMargin: Int, rightMargin: Int, bottomMargin: Int
    ): FrameLayout.LayoutParams {
        return frame(width, height).apply {
            setMargins(size(leftMargin), size(topMargin), size(rightMargin), size(bottomMargin))
        }
    }

    fun frame(width: Int, height: Int, gravity: Int): FrameLayout.LayoutParams {
        return frame(width, height).apply {
            this.gravity = gravity
        }
    }

    fun frame(width: Int, height: Int): FrameLayout.LayoutParams {
        return FrameLayout.LayoutParams(size(width), size(height))
    }

    /*
        LinearLayout
     */

    fun linear(
        width: Int, height: Int,
        weight: Float,
        gravity: Int,
        leftMargin: Int, topMargin: Int, rightMargin: Int, bottomMargin: Int
    ): LinearLayout.LayoutParams {
        return linear(width, height, weight, leftMargin, topMargin, rightMargin, bottomMargin).apply {
            this.gravity = gravity
        }
    }

    fun linear(
        width: Int, height: Int,
        weight: Float,
        leftMargin: Int, topMargin: Int, rightMargin: Int, bottomMargin: Int
    ): LinearLayout.LayoutParams {
        return linear(width, height, leftMargin, topMargin, rightMargin, bottomMargin).apply {
            this.weight = weight
        }
    }

    fun linear(
        width: Int, height: Int,
        gravity: Int,
        leftMargin: Int, topMargin: Int, rightMargin: Int, bottomMargin: Int
    ): LinearLayout.LayoutParams {
        return linear(width, height, leftMargin, topMargin, rightMargin, bottomMargin).apply {
            this.gravity = gravity
        }
    }

    fun linear(
        width: Int, height: Int,
        leftMargin: Int, topMargin: Int, rightMargin: Int, bottomMargin: Int
    ): LinearLayout.LayoutParams {
        return linear(width, height).apply {
            setMargins(size(leftMargin), size(topMargin), size(rightMargin), size(bottomMargin))
        }
    }

    fun linear(
        width: Int, height: Int,
        weight: Float,
        gravity: Int
    ): LinearLayout.LayoutParams {
        return linear(width, height, weight).apply {
            this.gravity = gravity
        }
    }

    fun linear(width: Int, height: Int, weight: Float): LinearLayout.LayoutParams {
        return linear(width, height).apply {
            this.weight = weight
        }
    }

    fun linear(width: Int, height: Int, gravity: Int): LinearLayout.LayoutParams {
        return linear(width, height).apply {
            this.gravity = gravity
        }
    }

    fun linear(width: Int, height: Int): LinearLayout.LayoutParams {
        return LinearLayout.LayoutParams(size(width), size(height))
    }

    /*
        RelativeLayout
     */

    fun relative(
        width: Int, height: Int,
        rule: Rule,
        leftMargin: Int, topMargin: Int, rightMargin: Int, bottomMargin: Int
    ): RelativeLayout.LayoutParams {
        return relative(width, height, arrayOf(rule), leftMargin, topMargin, rightMargin, bottomMargin)
    }

    fun relative(
        width: Int, height: Int,
        rules: Array<Rule>,
        leftMargin: Int, topMargin: Int, rightMargin: Int, bottomMargin: Int
    ): RelativeLayout.LayoutParams {
        return relative(width, height, rules).apply {
            setMargins(size(leftMargin), size(topMargin), size(rightMargin), size(bottomMargin))
        }
    }

    fun relative(width: Int, height: Int, leftMargin: Int, topMargin: Int, rightMargin: Int, bottomMargin: Int): RelativeLayout.LayoutParams {
        return relative(width, height).apply {
            setMargins(leftMargin, topMargin, rightMargin, bottomMargin)
        }
    }

    fun relative(width: Int, height: Int, rule: Rule): RelativeLayout.LayoutParams {
        return relative(width, height, arrayOf(rule))
    }

    fun relative(width: Int, height: Int, rules: Array<Rule>): RelativeLayout.LayoutParams {
        return relative(width, height).apply {
            rules.forEach { rule ->
                addRule(rule.verb, rule.subject ?: RelativeLayout.TRUE)
            }
        }
    }

    fun relative(width: Int, height: Int): RelativeLayout.LayoutParams {
        return RelativeLayout.LayoutParams(size(width), size(height))
    }

    class Rule(val verb: Int, val subject: Int? = null)
}