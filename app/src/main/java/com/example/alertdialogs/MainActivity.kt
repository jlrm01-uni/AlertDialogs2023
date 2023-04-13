package com.example.alertdialogs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment
import com.example.alertdialogs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), AlertDialogWithNotifyInterface.MyDialogListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.simpleDialogButton.setOnClickListener {
            showSimpleDialog()
        }

        binding.customDialogButton.setOnClickListener {
            showCustomDialog()
        }

        binding.thirdDialogButton.setOnClickListener {
            showThirdDialog()
        }
    }

    private fun showThirdDialog() {
        val dialog = AlertDialogWithNotifyInterface()
        dialog.show(supportFragmentManager, "my alert dialog")
    }

    private fun showCustomDialog() {
        val dialog = MyCustomDialog()
        dialog.show(supportFragmentManager, "my custom dialog")
    }

    private fun showSimpleDialog() {
        val dialog = SimpleAlertDialog()
        dialog.show(supportFragmentManager, "my simple dialog")

    }

    override fun onDialogPositiveClick(dialog: DialogFragment) {
        Log.i("main", "Positive click!")
    }

    override fun onDialogNegativeClick(dialog: DialogFragment) {
        Log.i("main", "Negative click!")
    }
}