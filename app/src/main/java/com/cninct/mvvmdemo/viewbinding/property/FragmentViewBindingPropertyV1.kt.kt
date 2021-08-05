package com.cninct.mvvmdemo.viewbinding.property

import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

private const val TAG = "ViewBindingProperty"

inline fun <reified V : ViewBinding> viewBindingV1() = viewBindingV1(V::class.java)

inline fun <reified T : ViewBinding> viewBindingV1(clazz: Class<T>): FragmentViewBindingPropertyV1<Fragment, T> {
    //通过反射拿到自动生成的ViewBinding类里面的bind方法，bind方法是生成对应ViewBinding对象
    val bindMethod = clazz.getMethod("bind", View::class.java)
    return FragmentViewBindingPropertyV1 {
        bindMethod(null, it.requireView()) as T
    }
}

class FragmentViewBindingPropertyV1<in F : Fragment, out V : ViewBinding>(private val viewBinder: (F) -> V) :
    ReadOnlyProperty<F, V> {

    private var viewBinding: V? = null

    override fun getValue(thisRef: F, property: KProperty<*>): V {
        viewBinding?.let { return it }
        val lifecycle = thisRef.viewLifecycleOwner.lifecycle
        val viewBinding = viewBinder(thisRef)
        if (lifecycle.currentState == Lifecycle.State.DESTROYED) {
            Log.w(
                TAG,
                "Access to viewBinding after Lifecycle is destroyed or hasn't created yet. The instance of viewBinding will be not cached."
            )
        } else {
            lifecycle.addObserver(BindingLifecycleObserver())
            this.viewBinding = viewBinding
        }
        return viewBinding
    }

    private inner class BindingLifecycleObserver : LifecycleObserver {
        private val mainHandler = Handler(Looper.getMainLooper())

        @MainThread
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun onDestroy(owner: LifecycleOwner) {
            owner.lifecycle.removeObserver(this)

            /**
             * Fragment的ViewLifecycleOwner通知更新lifecycle的ON_DESTROY事件时机发生在Fragment.onDestroyView()之前
             * 所以在主线程上的所有操作完成后才需要清除viewBinding
             */
            mainHandler.post {
                viewBinding = null
            }
        }
    }
}