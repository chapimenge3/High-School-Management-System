/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package h1;

/**
 *
 * @author SPY
 */
class BelowAgeLimit extends Exception 
{ 
    public BelowAgeLimit(String s) 
    { 
        // Call constructor of parent Exception 
        super(s); 
    } 
} 
class InvalidSalary extends Exception 
{ 
    public InvalidSalary(String s) 
    { 
        // Call constructor of parent Exception 
        super(s); 
    } 
}