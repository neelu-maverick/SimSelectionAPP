package com.example.simselection.builder_pattern

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.fragment.app.DialogFragment
import com.example.simselection.R
import com.example.simselection.databinding.FragmentBuilderDesignBinding

class BuilderDesignFragment constructor(builder: Builder) : DialogFragment() {


    private lateinit var builderDesignBinding: FragmentBuilderDesignBinding

    private var title: String? = null
    private var icon: Int? = null
    private var description: String? = null
    private var background: Int? = null


    init {
        this.title = builder.title
        this.icon = builder.icon
        this.description = builder.description
        this.background = builder.background
    }

    class Builder {
        var title: String? = null
        var icon: Int? = null
        var description: String? = null
        var background: Int? = null


        fun setTitle(title: String) = apply { this.title = title }
        fun setIcon(@DrawableRes icon: Int) = apply { this.icon = icon }
        fun setBackground(@ColorInt color: Int) = apply { this.background = color }
        fun setDescription(description: String) = apply { this.description = description }
        fun build() = BuilderDesignFragment(this)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.Theme_App_Dialog_FullScreen)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        // Inflate the layout for this fragment
        builderDesignBinding = FragmentBuilderDesignBinding.inflate(layoutInflater)
        title.let {
            builderDesignBinding.titleTv.text = it
        }
        icon.let {
            builderDesignBinding.imageView.setImageResource(R.drawable.ic_check)

        }
        description.let {
            builderDesignBinding.descTv.text = it
        }
        background.let {
            builderDesignBinding.statusDialogColor.setBackgroundResource(R.drawable.status_dialog_success)
        }
        return builderDesignBinding.root
    }

}

