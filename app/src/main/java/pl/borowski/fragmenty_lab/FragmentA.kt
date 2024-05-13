package pl.borowski.fragmenty_lab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import pl.borowski.fragmenty_lab.databinding.FragmentABinding

class FragmentA : Fragment() {

    private lateinit var binding: FragmentABinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonInsertion.setOnClickListener {
            val input = binding.input.text.toString()
            val numbers = input.split(" ").mapNotNull { it.toIntOrNull() }.toIntArray()
            (requireActivity() as MainActivity).navigateToFragmentB(numbers, "1")
        }

        binding.buttonBubble.setOnClickListener {
            val input = binding.input.text.toString()
            val numbers = input.split(" ").mapNotNull { it.toIntOrNull() }.toIntArray()
            (requireActivity() as MainActivity).navigateToFragmentB(numbers,  "2")
        }
    }
}
