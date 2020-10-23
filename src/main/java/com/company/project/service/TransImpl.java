package com.company.project.service;

import javax.transaction.Transactional;

public class TransImpl implements Trans {
    @Override
    public void doTheThing() {
        actuallyDoTheThing();  // Noncompliant
    }

    @Override
    @Transactional
    public void actuallyDoTheThing() {
        // ...
    }
}
