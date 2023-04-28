package com.example.scorer.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

private const val level = 19
private const val chapters = 20

class OrderViewModel:ViewModel() {
    private val _b = MutableLiveData<Int>()
    val bVar : LiveData<Int> = _b

    private val _r = MutableLiveData<Int>()
    val rVar : LiveData<Int> = _r

    private val _s = MutableLiveData<Int>()
    val sVar : LiveData<Int> = _s

    private val _t = MutableLiveData<Int>()
    val tVal : LiveData<Int> = _t

    private val _z = MutableLiveData<Int>()
    val zVal : LiveData<Int> = _z

    private val _e = MutableLiveData<Int>()
    val eVal : LiveData<Int> = _e

    private val _back = MutableLiveData<Int>()
    val backVal : LiveData<Int> = _back

    private val _totalPoint = MutableLiveData<String>()
    val totalPoint : LiveData<String> = _totalPoint


    private val _price = MutableLiveData<Double>()
    val price: LiveData<String> = Transformations.map(_price) {
        NumberFormat.getCurrencyInstance().format(it)
    }

    val dateOptions = getPickupOptions()

    init {
        resetOrder()
    }

    /*fun setQuantity(numberCupCake : Int){
        _quantity.value = numberCupCake
        //updatePrice()
    }*/
    /*fun setFlavor(desireFlavor: String){
        _flavor.value = desireFlavor
    }

    fun setDate(pickupDate : String){
        _date.value = pickupDate
        //updatePrice()
    }

    fun hasNoFlavorSet(): Boolean {
        return _flavor.value.isNullOrEmpty()
    }*/

    private fun getPickupOptions():List<String>{
        val options = mutableListOf<String>()
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        val calender = Calendar.getInstance()
        repeat(4){
            options.add(formatter.format(calender.time))
            calender.add(Calendar.DATE,1)
        }
        return options
    }

    /*private fun updatePrice(){
        var calculatedPrice = (quantity.value ?: 0) * PRICE_PER_CUPCAKE
        // If the user selected the first option (today) for pickup, add the surcharge
        if (dateOptions[0] == _date.value) {
            calculatedPrice += PRICE_FOR_SAME_DAY_PICKUP
        }
        _price.value = calculatedPrice
    }
*/
    fun resetOrder() {/*
        _quantity.value = 0
        _flavor.value = ""
        _date.value = dateOptions[0]
        _price.value = 0.0*/
    }
}