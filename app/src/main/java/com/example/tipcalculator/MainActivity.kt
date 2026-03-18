package com.example.tipcalculator

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 1. 載入我們剛剛寫好的 XML 介面
        setContentView(R.layout.activity_main)

        // 2. 透過 ID 找到介面上的元件 (綁定)
        val editBillAmount = findViewById<EditText>(R.id.edit_bill_amount)
        val textTipAmount = findViewById<TextView>(R.id.text_tip_amount)

        // 3. 設定「文字監聽器」，每當使用者輸入，就立刻計算
        editBillAmount.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // 讀取輸入的內容，如果不是數字就當作 0.0
                val inputString = s.toString()
                val amount = inputString.toDoubleOrNull() ?: 0.0

                // 計算 15% 小費
                val tip = amount * 0.15

                // 格式化數字（加上 $ 符號與小數點）並顯示在畫面上
                val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
                textTipAmount.text = "Tip Amount: $formattedTip"
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }
}