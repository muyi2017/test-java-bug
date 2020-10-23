package com.company.project.scan;

public class FiPublicShouldBeProtected {

    public void tezxt() throws InterruptedException {
        Thread myThread = new Thread(new RunnableJob());
        myThread.wait(2000);
    }
}
