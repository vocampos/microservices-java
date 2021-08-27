package com.example.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrpayroll.entities.Payment;
import com.example.hrpayroll.entities.Worker;
import com.example.hrpayroll.feignclients.WorkerFeingClient;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeingClient workerFeingClient;

	public Payment getPayment(Long workerId, Integer days) {
		
		Worker worker = workerFeingClient.findById(workerId).getBody();

		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}

}
