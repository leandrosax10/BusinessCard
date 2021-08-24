package br.com.leandro.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import br.com.leandro.App
import br.com.leandro.businesscard.R
import br.com.leandro.businesscard.databinding.ActivityAddBusinessCardBinding
import br.com.leandro.data.Businesscard

class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }

    private val mainViewModel:MainViewModel by viewModels{
        MainsViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners(){
        binding.btnClose.setOnClickListener{
            finish()
        }
        binding.btnConfirm.setOnClickListener{
            val businessCard = Businesscard(
                nome = binding.tilNome.editText?.text.toString(),
                empresa = binding.tilEmpresa.editText?.text.toString(),
                telefone = binding.tilTelefone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                fundoPersonalizado = binding.tilCor.editText?.text.toString()
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_success, Toast.LENGTH_SHORT ).show()
            finish()
        }

    }
}