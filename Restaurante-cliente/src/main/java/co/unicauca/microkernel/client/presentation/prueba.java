/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.client.presentation;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Date;
import static javax.management.Query.value;
import static javax.management.Query.value;

/**
 *
 * @author EdynsonMJ
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        YearMonth yearMonthObject = YearMonth.of(2020, 11);
        int daysOfCurrentMonth = yearMonthObject.lengthOfMonth();

        ArrayList<LocalDate> dayes = new ArrayList<LocalDate>();
        for(int i = 1; i <= daysOfCurrentMonth; i++){
            dayes.add(yearMonthObject.atDay(i));
        }

        dayes.forEach(value -> System.out.println(value.getDayOfMonth() + " " + value.getDayOfWeek()));
    }
    
}
