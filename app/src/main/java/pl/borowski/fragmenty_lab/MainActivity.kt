package pl.borowski.fragmenty_lab

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pl.borowski.fragmenty_lab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView4, FragmentA())
            .commit()
    }

    fun navigateToFragmentB(numbers: IntArray, algorithm: String) {
        val fragmentB = FragmentB.newInstance(numbers, algorithm)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView4, fragmentB)
            .addToBackStack(null)
            .commit()
    }
    fun navigateToFragmentA() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView4, FragmentA())
            .commit()
    }
}
