package com.akshay.credstackview.recyclerview

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("list")
fun <T : Any> bindDataList(recyclerView: RecyclerView, dataList: List<T>) {
  val adapter = recyclerView.adapter as BindableAdapter<T>
  adapter.setData(dataList)
}
