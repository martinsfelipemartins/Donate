package br.com.martins.donate.sendmessage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.martins.donate.R

class SendMessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container,
                        SendMessageFragment.newInstance()
                    )
                    .commitNow()
        }
    }
}