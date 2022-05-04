/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usingjcapi;

import java.util.*;
/**
 *
 * @author kamaj
 */
public class UsingJCAPI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<TrafficCard> cardUsers = new ArrayList<TrafficCard>();
        RandomString rString = new RandomString(10);
        float genBalance;
        TrafficCard myCard;
        Random r = new Random();
        int i;
        for (i = 0; i < 10; i++) {
            genBalance = ((float) r.nextInt(1000) / 10);
            myCard = new TrafficCard(r.nextInt(100), rString.nextString(), genBalance);
            cardUsers.add(myCard);
        }
        
        //Sort implementation
        
        //Sort by number
        System.out.println("======== Lajittelu numeron mukaan ======== ");
        Collections.sort(cardUsers, new sortByNumber());
        
        Iterator itr = cardUsers.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        
        //Sort by balance
        System.out.println("======== Lajittelu saldon mukaan ======== ");
        Collections.sort(cardUsers, new sortByBalance());

        Iterator saldoItr = cardUsers.iterator();
        while (saldoItr .hasNext()) {
            System.out.println(saldoItr.next());
        }

        //Sort by name
        System.out.println("======== Lajittelu nimen mukaan ======== ");
        Collections.sort(cardUsers, new sortByName());

        Iterator nameItr = cardUsers.iterator();
        while (nameItr.hasNext()) {
            System.out.println(nameItr.next());
        }

        //Sort by number (Lambda expression)
        System.out.println("======== Lajittelu numeron mukaan (Lambda-lauseke) ======== ");
        Collections.sort(cardUsers, new sortByNumber());
        
        cardUsers.forEach( (n) -> System.out.println(n) );

        //Balance more then 0 and less then 25
        System.out.println("======== Saldo > 0 ja < 25 (Yhdistelmä operaatio) ======== ");
        
        cardUsers
            .stream()
            .filter( card -> card.mBalance > 0 && card.mBalance < 25 )
            .forEach( (n) -> System.out.println(n) );
    }
    
}
