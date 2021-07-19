package com.lfelipe.numbergame.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.*
import androidx.core.widget.doOnTextChanged
import com.github.dhaval2404.colorpicker.MaterialColorPickerDialog
import com.github.dhaval2404.colorpicker.model.ColorShape
import com.github.dhaval2404.colorpicker.model.ColorSwatch
import com.lfelipe.numbergame.R
import com.lfelipe.numbergame.databinding.ActivityMainBinding
import com.lfelipe.numbergame.databinding.NumberLayoutBinding
import com.lfelipe.numbergame.util.Api.IS_VISIBLE
import com.lfelipe.numbergame.util.Api.NOT_VISIBLE
import com.lfelipe.numbergame.util.setColor
import com.lfelipe.numbergame.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        resetDisplay()
        viewModel.getRandomNumber()
        setupObserves()
        inputTextObserver()
        setupMenu()

        binding.btnSend.setOnClickListener {
            val userNumber = binding.etNumber.text.toString()
            if (userNumber.isBlank()) {
                binding.tilNumber.error = getString(R.string.empty_text_input)
            } else {
                resetDisplay()
                compareNumbers(userNumber.toInt())
                defineNumberDisplay(userNumber.toInt())

            }
        }
    }

    private fun setupMenu() {
        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.displaySize-> {
                    // Handle favorite icon press
                    true
                }
                R.id.colorPicker -> {
                    MaterialColorPickerDialog
                        .Builder(this@MainActivity)
                        .setTitle(R.string.color_picker_dialog_text)
                        .setColors(resources.getStringArray(R.array.themeColorHex))
                        .setColorShape(ColorShape.SQAURE)
                        .setColorSwatch(ColorSwatch._300)
                        .setDefaultColor(R.color.main_color)
                        .setColorListener { color, _ ->
                            binding.One.setColor(color)
                            binding.Two.setColor(color)
                            binding.Three.setColor(color)
                        }
                        .show()
                    true
                }
                else -> false
            }
        }
    }

    private fun inputTextObserver() {
        binding.etNumber.doOnTextChanged { _, _, _, _ ->
            binding.tilNumber.isErrorEnabled = false
        }
    }

    private fun compareNumbers(userNumber: Int) {
        binding.tvResult.visibility = VISIBLE
        val randomNumber = viewModel.randomNumberLiveData.value?.value
        Log.i("teste", "$randomNumber")
        when {
            userNumber > (randomNumber ?: 0) -> {
                binding.tvResult.text = resources.getText(R.string.is_bigger)
            }
            userNumber < (randomNumber ?: 0) -> {
                binding.tvResult.text = resources.getText(R.string.is_smaller)
            }
            else -> {
                binding.tvResult.text = resources.getText(R.string.matches)
                binding.btnNewMatch.visibility = VISIBLE
                binding.btnSend.isEnabled = false
                newMatch()
            }
        }
    }


    private fun resetDisplay() {
        binding.tvResult.visibility = INVISIBLE
        binding.btnNewMatch.visibility = INVISIBLE
        binding.container.visibility = INVISIBLE
        binding.One.apply {
            ivBottomStart.alpha = IS_VISIBLE
            ivBottom.alpha = IS_VISIBLE
            ivBottomEnd.alpha = IS_VISIBLE
            ivCenter.alpha = IS_VISIBLE
            ivTopStart.alpha = IS_VISIBLE
            ivTopEnd.alpha = IS_VISIBLE
            ivTop.alpha = IS_VISIBLE
        }
        binding.Two.apply {
            ivBottomStart.alpha = IS_VISIBLE
            ivBottom.alpha = IS_VISIBLE
            ivBottomEnd.alpha = IS_VISIBLE
            ivCenter.alpha = IS_VISIBLE
            ivTopStart.alpha = IS_VISIBLE
            ivTopEnd.alpha = IS_VISIBLE
            ivTop.alpha = IS_VISIBLE
        }
        binding.Three.apply {
            ivBottomStart.alpha = IS_VISIBLE
            ivBottom.alpha = IS_VISIBLE
            ivBottomEnd.alpha = IS_VISIBLE
            ivCenter.alpha = IS_VISIBLE
            ivTopStart.alpha = IS_VISIBLE
            ivTopEnd.alpha = IS_VISIBLE
            ivTop.alpha = IS_VISIBLE
        }
    }

    private fun setupObserves() {

        viewModel.errorMsgLiveData.observe(this, {
            it?.let {

                binding.btnSend.isEnabled = false
                binding.tilNumber.isEnabled = false
                binding.etNumber.text = null

                resetDisplay()
                defineNumberDisplay(it.toInt())
                Log.i("teste", it)
                binding.tvResult.apply {
                    text = resources.getText(R.string.error)
                    visibility = VISIBLE
                }

                newMatch()
            }
        })

    }

    private fun newMatch() {
        binding.btnNewMatch.apply {
            visibility = VISIBLE
            setOnClickListener {
                resetDisplay()
                binding.tilNumber.isEnabled = true
                binding.btnSend.isEnabled = true
                binding.etNumber.text = null
                viewModel.getRandomNumber()
            }
        }

    }

    private fun defineNumberDisplay(number: Int) {

        when (number.toString().length) {
            1 -> {
                binding.Three.numberContainer.visibility = GONE
                binding.One.numberContainer.visibility = GONE
                binding.Two.numberContainer.visibility = VISIBLE
                setNumberOnDisplay(number, binding.Two)
            }
            2 -> {
                binding.Two.numberContainer.visibility = GONE
                binding.One.numberContainer.visibility = VISIBLE
                binding.Three.numberContainer.visibility = VISIBLE
                val first = number.toString().toCharArray()[0]
                val second = number.toString().toCharArray()[1]
                setNumberOnDisplay(first.toString().toInt(), binding.Three)
                setNumberOnDisplay(second.toString().toInt(), binding.One)
            }
            3 -> {
                binding.Two.numberContainer.visibility = VISIBLE
                binding.One.numberContainer.visibility = VISIBLE
                binding.Three.numberContainer.visibility = VISIBLE
                val first = number.toString().toCharArray()[0]
                val second = number.toString().toCharArray()[1]
                val third = number.toString().toCharArray()[2]
                setNumberOnDisplay(first.toString().toInt(), binding.Three)
                setNumberOnDisplay(second.toString().toInt(), binding.Two)
                setNumberOnDisplay(third.toString().toInt(), binding.One)

            }
        }
        binding.container.visibility = VISIBLE
    }

    private fun setNumberOnDisplay(number: Int, view: NumberLayoutBinding) {

        when (number) {

            0 -> view.ivCenter.alpha = NOT_VISIBLE
            1 -> view.apply {
                ivBottom.alpha = NOT_VISIBLE
                ivCenter.alpha = NOT_VISIBLE
                ivTop.alpha = NOT_VISIBLE
                ivTopStart.alpha = NOT_VISIBLE
                ivBottomStart.alpha = NOT_VISIBLE
            }
            2 -> view.apply {
                ivTopStart.alpha = NOT_VISIBLE
                ivBottomEnd.alpha = NOT_VISIBLE
            }
            3 -> view.apply {
                ivBottomStart.alpha = NOT_VISIBLE
                ivTopStart.alpha = NOT_VISIBLE
            }
            4 -> view.apply {
                ivTop.alpha = NOT_VISIBLE
                ivBottom.alpha = NOT_VISIBLE
                ivBottomStart.alpha = NOT_VISIBLE
            }
            5 -> view.apply {
                ivTopEnd.alpha = NOT_VISIBLE
                ivBottomStart.alpha = NOT_VISIBLE
            }
            6 -> view.apply {
                ivTop.alpha = NOT_VISIBLE
                ivTopEnd.alpha = NOT_VISIBLE
            }
            7 -> view.apply {
                ivTopStart.alpha = NOT_VISIBLE
                ivCenter.alpha = NOT_VISIBLE
                ivBottom.alpha = NOT_VISIBLE
                ivBottomStart.alpha = NOT_VISIBLE
            }
            8 -> view.ivTop.alpha = IS_VISIBLE
            9 -> view.apply {
                ivBottom.alpha = NOT_VISIBLE
                ivBottomStart.alpha = NOT_VISIBLE
            }

        }
    }


}
