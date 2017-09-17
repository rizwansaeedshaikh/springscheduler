package com.rizwan.test.springscheduler.components;

import org.springframework.stereotype.Component;

@Component("synch")
public class SynchWorker implements Work {

	public void work() {

		System.out.println("Doing some work");
	}
}
