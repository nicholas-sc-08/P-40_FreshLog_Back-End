package com.fl.freshlog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Table(name = "tb_batch")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Batch {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "batch_id")
    private Integer batchId;
    
    @ManyToOne
    @JoinColumn(name = "product_id", unique = true)
    private Integer productId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;
}
