package pl.borowski.fragmenty_lab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import pl.borowski.fragmenty_lab.databinding.FragmentBBinding

class FragmentB : Fragment() {

    private lateinit var binding: FragmentBBinding
    private lateinit var unsortedArray: IntArray
    private lateinit var algorithm: String

    companion object {
        private const val ARG_UNSORTED_ARRAY = "arg_unsorted_array"
        private const val ARG_ALGORITHM = "arg_algorithm"

        fun newInstance(unsortedArray: IntArray, algorithm: String): FragmentB {
            val fragment = FragmentB()
            val args = Bundle()
            args.putIntArray(ARG_UNSORTED_ARRAY, unsortedArray)
            args.putString(ARG_ALGORITHM, algorithm)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            unsortedArray = it.getIntArray(ARG_UNSORTED_ARRAY) ?: intArrayOf()
            algorithm = it.getString(ARG_ALGORITHM) ?: ""
        }

        val sortedArray = when (algorithm) {
            "1" -> {
                binding.algorithmDescription.text = getString(R.string.opis_wstawianie)
                Algorithms.insertionSort(unsortedArray.copyOf())
            }
            "2" -> {
                binding.algorithmDescription.text = getString(R.string.opis_babelkowe)
                Algorithms.bubbleSort(unsortedArray.copyOf())
            }
            else -> intArrayOf()
        }

        val beforeSorted = view.findViewById<TextView>(R.id.unsortedArray)
        beforeSorted.text = unsortedArray.toString()
        val afterSorted = view.findViewById<TextView>(R.id.sortedArray)
        afterSorted.text = sortedArray.toString()


        binding.button.setOnClickListener {
            (requireActivity() as MainActivity).navigateToFragmentA()
        }
    }
}