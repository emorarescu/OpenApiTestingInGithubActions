package org.example.stubs;


public class PaymentStub {

    public static void setupPaymentStubs() {


        // Success response - paid = true
//        stubFor(get(urlEqualTo("/payment/123e4567-e89b-12d3-a456-426614174000"))
//                .willReturn(aResponse()
//                        .withStatus(200)
//                        .withHeader("Content-Type", "application/json")
//                        .withBody("""
//                                {
//                                  "paid": true,
//                                  "requestedAt": "2026-05-14T10:15:30Z"
//                                }
//                                """)));
//
//        // Success response - paid = false
//        stubFor(get(urlEqualTo("/payment/987f6543-e21b-34d3-b654-123456789abc"))
//                .willReturn(aResponse()
//                        .withStatus(200)
//                        .withHeader("Content-Type", "application/json")
//                        .withBody("""
//                                {
//                                  "paid": false,
//                                  "requestedAt": "2026-05-14T11:45:00Z"
//                                }
//                                """)));
//
//        // Error response - payment not found
//        stubFor(get(urlEqualTo("/payment/11111111-2222-3333-4444-555555555555"))
//                .willReturn(aResponse()
//                        .withStatus(400)
//                        .withHeader("Content-Type", "application/json")
//                        .withBody("""
//                                {
//                                  "errorCode": "NOT_FOUND",
//                                  "errorMessage": "Payment not found"
//                                }
//                                """)));
    }
}
