package com.rizwan.test.springscheduler.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.rizwan.test.springscheduler.components.SynchWorker;
import com.rizwan.test.springscheduler.service.RefreshTokenService;

@Service
public class RefreshTokenServiceImpl implements RefreshTokenService {

	@Autowired
	@Qualifier("synch")
	private SynchWorker worker;

	public SynchWorker getWorker() {
		return worker;
	}

	public void setWorker(SynchWorker worker) {
		this.worker = worker;
	}

	/*
	 * fixedDelay - Execute the annotated method with a fixed period in
	 * milliseconds between the end of the last invocation and the start of the
	 * next. 
	 * 
	 * fixedRate - Execute the annotated method with a fixed period in
	 * milliseconds between invocations. 
	 * 
	 * initialDelay - Number of milliseconds
	 * to delay before the first execution of a fixedRate() or fixedDelay()
	 * task.
	 */

	@Scheduled(fixedDelay = 1000, initialDelay = 1000)
	public void refreshToken() {
		
		worker.work();
	}
}
