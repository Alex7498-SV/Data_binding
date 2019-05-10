package com.aldana.ejemplo14

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.aldana.ejemplo14.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var scoreViewModel: ScoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        scoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)

        // TODO: El ViewModel es restaurado si ya existía, si no, se crea uno nuevo.
        // TODO: Recuerde que el ViewModel solo sobrevive a cambios de configuración y no a la destrucción de la aplicación
    }

    // TODO: Accediendo y modificando datos almacenados en el ViewModel según el método utilizado

    fun addOneTeamA(v:View) {
        binding.scoreT = Score(++scoreViewModel.scoreTeamA, scoreViewModel.scoreTeamB
        )
    }

    fun addOneTeamB(v: View) {
        binding.scoreT = Score(scoreViewModel.scoreTeamA, ++scoreViewModel.scoreTeamB)
    }


    //TODO(1) NO SE SI FUNCIONARA
    fun addTwoTeamA(v:View) {
        var scoreA : Int = scoreViewModel.scoreTeamA
        binding.scoreT = Score(scoreA + 2, scoreViewModel.scoreTeamB )
    }

    fun addTwoTeamB(v:View) {
        var scoreB : Int = scoreViewModel.scoreTeamB
        binding.scoreT = Score(scoreViewModel.scoreTeamA,scoreB + 2 )
    }

    fun addThreeTeamA(v:View) {
        var scoreA : Int = scoreViewModel.scoreTeamA
        binding.scoreT = Score(scoreA + 3, scoreViewModel.scoreTeamB )
    }

    fun addThreeTeamB(v:View) {
        var scoreB : Int = scoreViewModel.scoreTeamA
        binding.scoreT = Score(scoreViewModel.scoreTeamA, scoreB + 3)
    }
}
