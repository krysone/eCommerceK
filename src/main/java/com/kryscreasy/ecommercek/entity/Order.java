package com.kryscreasy.ecommercek.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Basic(optional = false)
    @CreationTimestamp
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date placedAt = new Date();
//
////    @Column(name = "orderList_id")
////    @OneToOne(cascade = CascadeType.ALL)
//////    @JoinTable(
//////            joinColumns = @JoinColumn(name = "")
//////    )
////    @JoinColumn(
////            name = "order_list_id",
////            referencedColumnName = "id",
////            nullable = false)
////    private OrderList orderList;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(
//            name = "order_list_id",
//            referencedColumnName = "id"
//    )

//    private OrderLine orderLine;

//    @ElementCollection
//    @CollectionTable(name = "order_shopingCart",
//    joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")})
//    @MapKey("")
//    private Map<Long, Integer> shopingCart;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String street;

    @Column
    private String city;

    @Column
    private String zip;

    @Column
    private String ccNumber;

    @Column
    private String ccExpiration;

    @Column
    private String ccCVV;

}
