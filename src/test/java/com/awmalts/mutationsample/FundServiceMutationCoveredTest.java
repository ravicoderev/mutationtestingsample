package com.awmalts.mutationsample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FundServiceMutationCoveredTest {


    @Test
    public void purchaseFundUnits() {

        FundServiceMutationCovered fs1 = new FundServiceMutationCovered(1000);
        assertEquals(1050, fs1.purchaseFundUnits(500.00, 1));

    }

    @Test
    public void incorrectFundToPurchaseUnits() {

        FundServiceMutationCovered fs1 = new FundServiceMutationCovered(1000);
        assertEquals(0, fs1.purchaseFundUnits(500.00, 4));
    }

    @Test
    public  void enoughUnitsToRedeemFund() {
        FundServiceMutationCovered fs1 = new FundServiceMutationCovered(1000);
//        fs1.redeemFundUnits(10000.00, 3);
        // *** add this for mutation coverage  ***
        assertEquals(900, fs1.redeemFundUnits(1000.00, 1));
    }

    @Test
    public void incorrectFundToRedeemUnits() {

        FundServiceMutationCovered fs1 = new FundServiceMutationCovered(1000);
        assertEquals(0, fs1.purchaseFundUnits(500.00, 4));
    }

    @Test
    public  void notEnoughUnitsToRedeemFundWhenEqualToZero() {
        FundServiceMutationCovered fs1 = new FundServiceMutationCovered(1000);
        assertEquals(0, fs1.redeemFundUnits(10000.00, 1));
    }

    @Test
    public  void notEnoughUnitsToRedeemFundWhenLessThanZero() {
        FundServiceMutationCovered fs1 = new FundServiceMutationCovered(1000);
        assertEquals(-100, fs1.redeemFundUnits(11000.00, 1));
    }

    @Test
    public void isValidAmount() {
        FundServiceMutationCovered fs1 = new FundServiceMutationCovered(1000);
        assertTrue(fs1.isValidAmount(500,1));
        assertTrue(fs1.isValidAmount(1000,3));

    }

    @Test
    public void isNotValidAmount() {
        FundServiceMutationCovered fs1 = new FundServiceMutationCovered(1000);
        assertFalse(fs1.isValidAmount(400,1));
        assertFalse(fs1.isValidAmount(900,3));

    }



}


