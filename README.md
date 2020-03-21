# Backend
API for help now eat later


![build](https://github.com/Kode-Collektiv/backend/workflows/build/badge.svg?branch=master)

### Build production Docker container with OpenJDK 11
```
docker build . backend:latest
```
=======
all public, no registration necessary or OpenId provider (e.g. google, facebook)?

- [x] public API
- [ ] with User (OpenID)

## what's avaiable

- GET /api/1/stores                                   
- GET /api/1/stores/{storeID}/products                
- GET /api/1/stores/{storeID}/products/{productID}    

## see bought vouchers

- GET /api/1/voucher/{voucherID}

## paypal/payment stuff

- POSt /api/1/payment/donate                              amount, e.g. msg?
- POST /api/1/payment/voucher/create                      map<product, qty>   
- POST /api/1/payment/voucher/complete                    paymentId, payerID

## Objects/Data model

Stores
 - id
 - contact
 - paypal-stuff

Product
- id
- name
- description
- price
- storeID 

Voucher
- amount
- validUntil
- creationDate
- storeID
- ?digital (yes/no)




  



