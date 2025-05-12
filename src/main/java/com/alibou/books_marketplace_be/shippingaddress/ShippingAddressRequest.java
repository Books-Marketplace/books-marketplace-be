package com.alibou.books_marketplace_be.shippingaddress;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShippingAddressRequest {
    private String postalCode;
    private String city;
    private String country;
    private String street;
    private String houseNumber;
    private String userId;
}
