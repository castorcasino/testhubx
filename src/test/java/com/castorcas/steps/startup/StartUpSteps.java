package com.castorcas.steps.startup;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

public class StartUpSteps {

    private int multiplicand;
    private int multiplier;
    private int product;

    @Given("a multiplicand as $multiplicand")
    public void givenAMultiplicandAs(@Named("multiplicand") int multiplicand){
        this.multiplicand = multiplicand;
        //System.out.println("Multiplicand is " + this.multiplicand);
    }

    @Given("a multiplier as $multiplier")
    public void andAMultiplierAs(@Named("multiplier") int multiplier){
        this.multiplier = multiplier;
        //System.out.println("Multiplier is " + this.multiplier);
    }

    @When("I do multiplication")
    public void iDoMultiplication(){
        this.product = this.multiplicand * this.multiplier;
        //System.out.println("Multiplication done.");
    }

    @Then("the product is $product")
    public void theTheProductIs(@Named("product") int product){
        Assert.assertEquals(product, this.product);
    }

}
