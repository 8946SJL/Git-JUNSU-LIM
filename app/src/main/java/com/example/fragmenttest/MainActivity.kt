package com.example.fragmenttest

//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import com.example.fragmenttest.R
//import com.example.fragmenttest.Test1
//import com.example.fragmenttest.Test2
//
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        // FragmentManager를 사용하여 Fragment를 관리합니다.
//        val fragmentManager = supportFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//
//        // Test1 Fragment를 추가하는 방법입니다.
//        val test1Fragment = Test1() // Test1 Fragment의 인스턴스를 만듭니다.
//        val test2Fragment = Test2()
//        fragmentTransaction.replace(R.id.fragment_container_1, test1Fragment)
//        fragmentTransaction.replace(R.id.fragment_container_2, test2Fragment)
//        fragmentTransaction.addToBackStack(null) // Fragment를 백 스택에 추가합니다.
//        fragmentTransaction.commit()
//    }
//}
//
