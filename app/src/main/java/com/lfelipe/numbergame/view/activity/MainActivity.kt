package com.lfelipe.numbergame.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.*
import com.lfelipe.numbergame.R
import com.lfelipe.numbergame.databinding.ActivityMainBinding
import com.lfelipe.numbergame.databinding.NumberLayoutBinding
import com.lfelipe.numbergame.util.Api.IS_VISIBLE
import com.lfelipe.numbergame.util.Api.NOT_VISIBLE
import com.lfelipe.numbergame.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()
    private var userNumber: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        reset()
        setupObserves()
        binding.btnSend.setOnClickListener {
            reset()
            userNumber = binding.etNumber.text.toString().toInt()
            defineNumberDisplay(userNumber)

        }
    }


    private fun reset() {
        binding.tvResult.visibility = INVISIBLE
        binding.btnNewMatch.visibility = INVISIBLE
        binding.container.visibility = INVISIBLE
        binding.One.apply{
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
        viewModel.randomNumberLiveData.observe(this, {
            it?.let { randomNumber ->
                binding.tvResult.visibility = VISIBLE
                if(userNumber > randomNumber.value ){
                    binding.tvResult.text = resources.getText(R.string.is_bigger)
                }else if(userNumber < randomNumber.value){
                    binding.tvResult.text = resources.getText(R.string.is_smaller)
                }else{
                    binding.tvResult.text = resources.getText(R.string.matches)
                    binding.btnNewMatch.visibility = VISIBLE
                    binding.btnSend.isEnabled = false
                    newMatch()
                }
            }
        })

        viewModel.errorMsgLiveData.observe(this, {
            it?.let {

                binding.btnSend.isEnabled = false
                binding.tilNumber.isEnabled = false
                binding.etNumber.text = null

                reset()
                defineNumberDisplay(it.toInt(), true)
                Log.i("teste", it)
                binding.tvResult.apply{
                    text = resources.getText(R.string.error)
                    visibility = VISIBLE
                }

                newMatch()
            }
        })

    }

    private fun newMatch() {
        binding.btnNewMatch.apply{
            visibility = VISIBLE
            setOnClickListener {
                reset()
                binding.tilNumber.isEnabled = true
                binding.btnSend.isEnabled = true
                binding.etNumber.text = null
            }
        }

    }

    private fun defineNumberDisplay(number: Int, error: Boolean = false) {

        if(!error){
            viewModel.getRandomNumber()
        }

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
            4 -> view.apply{
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
            7 -> view.apply{
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
