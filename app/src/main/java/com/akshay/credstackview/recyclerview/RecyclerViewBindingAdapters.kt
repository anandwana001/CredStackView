package com.akshay.credstackview.recyclerview

import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.akshay.credstackview.R

@BindingAdapter("list")
fun <T : Any> bindDataList(recyclerView: RecyclerView, dataList: List<T>) {
  val adapter = recyclerView.adapter as BindableAdapter<T>
  adapter.setData(dataList)
}

@BindingAdapter("onClick")
fun onClick(view: View, onClick: () -> Unit) {
  view.setOnClickListener {
    onClick()
  }
}

@BindingAdapter("animate")
fun animate(view: View, toggle: Boolean) {
  if (toggle) {
    val slideIn: Animation = AnimationUtils.loadAnimation(
      view.context,
      R.anim.slide_in_bottom
    )
    view.startAnimation(slideIn)
    view.visibility = View.VISIBLE
  } else {
    val slideOut: Animation = AnimationUtils.loadAnimation(
      view.context,
      R.anim.slide_out_bottom
    )
    view.startAnimation(slideOut)
    view.visibility = View.GONE
  }
}
