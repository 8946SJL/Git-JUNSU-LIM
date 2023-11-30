package com.example.fragmenttest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
//import com.example.fragmenttest.databinding.FragmentTest1Binding //
import android.content.Intent
import android.graphics.Color
//import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
//import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import java.text.DecimalFormat


//class Test1 : Fragment() {
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_test1, container, false)
//    }
//}


//fragmet_test1를 MainActivity와 연결
//findViewById 코드
class Test1 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_test1, container, false)

        val editText: EditText = view.findViewById(R.id.editText)
        val tvNum1: TextView = view.findViewById(R.id.tv_num1)
        val tvNum2: TextView = view.findViewById(R.id.tv_num2)
        val tvNum3: TextView = view.findViewById(R.id.tv_num3)
        val tvNum4: TextView = view.findViewById(R.id.tv_num4)
        val tvNum5: TextView = view.findViewById(R.id.tv_num5)
        val tvNum6: TextView = view.findViewById(R.id.tv_num6)
        val tvNum7: TextView = view.findViewById(R.id.tv_num7)
        val tvNum8: TextView = view.findViewById(R.id.tv_num8)
        val tvNum9: TextView = view.findViewById(R.id.tv_num9)
        val tvNum10: TextView = view.findViewById(R.id.tv_num10)
        val tvNum11: TextView = view.findViewById(R.id.tv_num11)
        val tvNum12: TextView = view.findViewById(R.id.tv_num12)

        // tvNum12의 기능 - EditText에 입력된 텍스트에서 마지막 값 삭제 기능
        tvNum12.setOnClickListener {
            val currentText = editText.text.toString()
            if (currentText.isNotEmpty()) {
                val modifiedText = currentText.substring(0, currentText.length - 1)
                editText.setText(modifiedText)
                editText.setSelection(modifiedText.length)
            }
        }
        //00버튼을 클릭하면 금액 마지막 값에 '00'이 추가되며, 콤마(,)위치가 달라집니다.
        val doubleZeroTextView: TextView = view.findViewById(R.id.tv_num10)
        doubleZeroTextView.setOnClickListener {
            val currentText = editText.text.toString()
            val textViewText = doubleZeroTextView.text.toString()
            val updatedText = if (currentText.isNotEmpty()) {
                val lastChar = currentText[currentText.length - 1]
                val textToAdd = if (lastChar == ',') {
                    "$textViewText,"
                } else {
                    ",$textViewText"
                }
                "$currentText$textToAdd"
            } else {
                textViewText
            }
            editText.setText(updatedText)
            editText.setSelection(updatedText.length)
        }



        //EditText의 세 자리 수마다 쉼표 추가
        fun addCommasToNumber(number: String): String {
            val decimalFormat = DecimalFormat("#,###")
            return try {
                val parsed = number.toDouble()
                decimalFormat.format(parsed)
            } catch (e: NumberFormatException) {
                number // 숫자가 아닌 경우 그대로 반환
            }
        }


        //TextWatcher을 사용하여 EditText의 텍스트가 변경될때마다 쉼표 추가
        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val currentText = editText.text.toString().replace(",", "") // 쉼표 제거
                val formattedText = addCommasToNumber(currentText) // 쉼표 추가
                editText.removeTextChangedListener(this)
                editText.setText(formattedText)
                editText.setSelection(formattedText.length)
                editText.addTextChangedListener(this)
            }


            //Snackbar로 "모바일에서는 10억 미만의 금액만 송금할 수 있습니다" 메시지 출력(동작 x)
            private fun showSnackbar(message: String) {
                view?.let {
                    val snackbar = Snackbar.make(it, message, Snackbar.LENGTH_LONG)
                    snackbar.show()
                }
            }


            // EditText 값 변경 감지를 위한 TextWatcher 설정
            val EdittextWatcher = object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable?) {
                    val currentText = editText.text.toString().replace(",", "") // 쉼표 제거
                    val formattedText = addCommasToNumber(currentText) // 쉼표 추가
                    editText.removeTextChangedListener(this)
                    editText.setText(formattedText)
                    editText.setSelection(formattedText.length)
                    editText.addTextChangedListener(this)

                    // 입력된 금액을 확인하여 10억 이상일 경우 Snackbar를 통해 메시지 표시
                    val amount = currentText.toDoubleOrNull() ?: 0.0
                    if (amount >= 1e9) {
                        showSnackbar("모바일에서는\n10억 미만의\n금액만\n송금할\n수\n있습니다")
                    }
                }
            }

        }

// EditText에 TextWatcher 추가
        editText.addTextChangedListener(textWatcher)



        editText.addTextChangedListener(textWatcher)

        // 다른 숫자들에 대한 TextView 연결

        // 각 숫자 TextView에 대한 클릭 리스너
        val numberClickListener = View.OnClickListener { view ->
            val number = (view as TextView).text.toString()
            val newText = editText.text.toString() + number
            editText.setText(newText)
            editText.setSelection(newText.length) // 커서를 마지막으로 이동
        }

        tvNum1.setOnClickListener(numberClickListener)
        tvNum2.setOnClickListener(numberClickListener)
        tvNum3.setOnClickListener(numberClickListener)
        tvNum4.setOnClickListener(numberClickListener)
        tvNum5.setOnClickListener(numberClickListener)
        tvNum6.setOnClickListener(numberClickListener)
        tvNum7.setOnClickListener(numberClickListener)
        tvNum8.setOnClickListener(numberClickListener)
        tvNum9.setOnClickListener(numberClickListener)
        tvNum10.setOnClickListener(numberClickListener)
        tvNum11.setOnClickListener(numberClickListener)
        //tvNum12.setOnClickListener(numberClickListener)


        // 나머지 숫자들에 대한 클릭 리스너 추가

        return view
    }
}

//viewBinding 사용 시 오류
//class YourFragment : Fragment() {
//    private var _binding: FragmentTest1Binding? = null // 바인딩 선언
//
//    // _binding을 통해 바인딩 객체에 접근
//    private val binding get() = _binding!!
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // 프래그먼트를 위한 뷰 바인딩 초기화
//        _binding = FragmentTest1Binding.inflate(inflater, container, false)
//        val view = binding.root
//
//        // 여기서 binding 객체를 사용하여 뷰에 접근할 수 있음
//        binding.tvNum1.setOnClickListener {
//            val newText = binding.editText.text.toString() + "1"
//            binding.editText.setText(newText)
//            binding.editText.setSelection(newText.length)
//        }
//
//        binding.tvNum2.setOnClickListener {
//            val newText = binding.editText.text.toString() + "2"
//            binding.editText.setText(newText)
//            binding.editText.setSelection(newText.length)
//        }
//
//        // 나머지 숫자들에 대한 클릭 리스너 추가
//
//        return view
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null // 바인딩을 해제하여 메모리 누수 방지
//    }
//}


