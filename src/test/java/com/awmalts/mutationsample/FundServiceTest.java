package com.awmalts.mutationsample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FundServiceTest {


    @Test
    public void testPurchaseFundUnits() {

        FundService fs1 = new FundService(1000);
        assertEquals(1050, fs1.purchaseFundUnits(500.00, 1));
    }

    @Test
    public  void testRedeemFundUnits() {
        FundService fs1 = new FundService(1000);
        fs1.redeemFundUnits(10000.00, 3);
    }

    @Test
    public void isValidAmount() {
        FundService fs1 = new FundService(1000);
        assertTrue(fs1.isValidAmount(500,1));
    }
}
