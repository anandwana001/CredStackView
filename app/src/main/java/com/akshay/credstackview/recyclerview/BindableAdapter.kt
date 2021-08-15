package com.akshay.credstackview.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

private typealias ViewHolderFactory<T> = (ViewGroup) -> BindableAdapter.BindableViewHolder<T>

/** Generic way to create adapter for RecyclerView. */
class BindableAdapter<T : Any>(
  private val viewHolderFactory: ViewHolderFactory<T>
) : RecyclerView.Adapter<BindableAdapter.BindableViewHolder<T>>() {

  private val dataList: MutableList<T> = ArrayList()

  fun <T2 : Any> setData(newDataList: List<T2>) {
    // Class type check can be implemented to support this type cast.
    newDataList as List<T>
    dataList.clear()
    dataList += newDataList
    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindableViewHolder<T> {
    return viewHolderFactory(parent)
  }

  override fun onBindViewHolder(holder: BindableViewHolder<T>, position: Int) {
    holder.bind(dataList[position])
  }

  override fun getItemCount(): Int = dataList.size

  abstract class BindableViewHolder<T> internal constructor(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    internal abstract fun bind(data: T)
  }

  class AdapterBuilder<T : Any>() {

    private lateinit var viewHolderFactory: ViewHolderFactory<T>

    companion object {
      inline fun <reified T : Any> newBuilder(): AdapterBuilder<T> {
        return AdapterBuilder()
      }
    }

    fun <DB : ViewDataBinding> registerView(
      inflateDataBinding: (LayoutInflater, ViewGroup, Boolean) -> DB,
      setViewModel: (DB, T) -> Unit
    ): AdapterBuilder<T> {
      viewHolderFactory = { viewGroup ->
        val binding = inflateDataBinding(
          LayoutInflater.from(viewGroup.context),
          viewGroup,
          /* attachToRoot= */ false
        )
        object : BindableViewHolder<T>(binding.root) {
          override fun bind(data: T) {
            setViewModel(binding, data)
          }
        }
      }
      return this
    }

    fun build(): BindableAdapter<T> {
      return BindableAdapter(
        viewHolderFactory
      )
    }
  }
}
