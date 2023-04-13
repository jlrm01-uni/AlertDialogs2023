package com.example.alertdialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment

class AlertDialogWithNotifyInterface: DialogFragment() {
    internal lateinit var listener: MyDialogListener

    interface MyDialogListener {
        fun onDialogPositiveClick(dialog: DialogFragment)
        fun onDialogNegativeClick(dialog: DialogFragment)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        listener = context as MyDialogListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)

        builder.setTitle("This is the title, again")
        builder.setMessage("This is the message, again")

        builder.setView(R.layout.custom_layout)

        builder.setPositiveButton("Yes, sir", DialogInterface.OnClickListener { dialogInterface, i ->
            listener.onDialogPositiveClick(this)
        })

        builder.setNegativeButton("No, sir", DialogInterface.OnClickListener { dialogInterface, i ->
            listener.onDialogNegativeClick(this)
        })

        return builder.create()
    }
}