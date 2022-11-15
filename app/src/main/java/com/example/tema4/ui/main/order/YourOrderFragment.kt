package com.example.tema4.ui.main.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tema4.FrisApplication
import com.example.tema4.R
import com.example.tema4.database.AppDatabase
import com.example.tema4.database.OrderObject
import com.example.tema4.database.dao.OrderDAO
import kotlinx.android.synthetic.main.fragment_burger.*
import kotlinx.android.synthetic.main.fragment_your_order.*
import kotlinx.android.synthetic.main.your_order_card.*
import java.util.concurrent.Executor


class YourOrderFragment : Fragment() {

    var fragmentOrderList = listOf<OrderObject>()

    private lateinit var recyclerView: RecyclerView
    private lateinit var orderAdapter: OrderAdapter
    private lateinit var orderViewModel: OrderViewModel
    private lateinit var orderLayoutManager: LinearLayoutManager

    private lateinit var orderButton: Button
    private lateinit var backButton: ImageView

    private lateinit var executor: Executor
    private lateinit var biometricPrompt: BiometricPrompt
    private lateinit var promptInfo: BiometricPrompt.PromptInfo


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_your_order, container, false)

        orderViewModel = ViewModelProvider(this).get(OrderViewModel::class.java)
        recyclerView = view.findViewById(R.id.yourOrders_recyclerview)

        orderButton = view.findViewById(R.id.bestille_button)
        backButton = view.findViewById(R.id.backArrowYourOrder_imageView)

        executor = ContextCompat.getMainExecutor(FrisApplication.application.applicationContext)
        biometricPrompt = BiometricPrompt(this, executor, object: BiometricPrompt.AuthenticationCallback(){
                override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                    super.onAuthenticationError(errorCode, errString)
                    Toast.makeText(FrisApplication.application.applicationContext, "Autentiseringserror: $errString", Toast.LENGTH_SHORT)
                        .show()
                }

                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                    Toast.makeText(FrisApplication.application.applicationContext, "Autentsering godkjent", Toast.LENGTH_SHORT)
                        .show()
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    Toast.makeText(FrisApplication.application.applicationContext, "Autentisering feilet", Toast.LENGTH_SHORT)
                        .show()
                }
        })

        promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Biometrisk innlogging for å bestille")
            .setSubtitle("Verifisering behøves for å bestille")
            .setNegativeButtonText("Bruk en annen metode for biometrisk innlogging")
            .build()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecView()
        bindObservers()
        onSetClickListeners(view)
    }

    override fun onResume() {
        super.onResume()
        bindObservers()
    }

     fun bindObservers(){
         orderViewModel.ordersLiveData.observe(viewLifecycleOwner, { list ->
            orderAdapter.updateData(list)
        })
    }

    private fun initRecView(){
        orderAdapter = OrderAdapter(fragmentOrderList)
        recyclerView.adapter = orderAdapter
        orderLayoutManager = LinearLayoutManager(FrisApplication.application.applicationContext)
        recyclerView.layoutManager = LinearLayoutManager(FrisApplication.application.applicationContext)
        orderViewModel.getOrders()
    }

    private fun onSetClickListeners(view: View){

        backButton.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_yourOrderFragment_to_orderFragment)
        }

        orderButton.setOnClickListener {
            biometricPrompt.authenticate(promptInfo)
        }
    }
}