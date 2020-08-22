package br.com.martins.donate.sendmessage

import android.content.Intent
import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.martins.donate.R
import br.com.martins.donate.openmessage.OpenMessageActivity
import kotlinx.android.synthetic.main.main_fragment.*
import java.util.*

class SendMessageFragment : Fragment() {

    companion object {
        fun newInstance() =
            SendMessageFragment()
    }

    private lateinit var viewModel: SendMessageViewModel

    private lateinit var messageSent: TextToSpeech

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
        messageSent = TextToSpeech(context, TextToSpeech.OnInitListener { status ->
            messageSent.language = Locale.getDefault()
            })


        btnOuvirMsg.setOnClickListener {
            val toSpeak = editText_message.text.toString()
            messageSent.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null)
            Toast.makeText(context, toSpeak, Toast.LENGTH_LONG).show()

        }
        btnchamartela.setOnClickListener {
            startActivity(Intent(context, OpenMessageActivity::class.java))
        }
    }

}