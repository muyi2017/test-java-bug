package com.company.project.scan;

import javax.persistence.Entity;

@Entity
public class Wish {
    Long productId;
    Long quantity;
    Client client;
}
