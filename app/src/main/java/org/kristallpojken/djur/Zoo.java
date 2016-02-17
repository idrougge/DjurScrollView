package org.kristallpojken.djur;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by iggy on 16-02-03.
 */
public class Zoo {
    // Klassvariabler
    static final String[] animalNames={"älg","säl","varg","zebra","kobra","örn","björn","vildsvin",
                                       "gris","hund","svala","tiger","mollusk","silverfisk","ödla"};
    static final String[] animalDescriptions={"Skogens konung","Havets lilla hund",
                                              "Ensam är stark","En randing häst"};
    // Instansvariabler
    private ArrayList<Animal> animals;
    private Iterator<Animal> animalIterator;

    // Konstruktorer
    Zoo()
    {
        animals=new ArrayList<Animal>();
        for (String name:animalNames)
        {
            animals.add(new Animal(name,"test"));
        }
        animalIterator=animals.iterator();
    }

    // Klassmetoder

    // Instansmetoder
    public Animal getFirstAnimal()
    {
        return animals.get(0);
    }
    public Animal getNextAnimal()
    {
        if (animalIterator.hasNext())
            return animalIterator.next();
        else
        {
            resetIterator();
            return null;
        }
    }
    public void resetIterator()
    {
        animalIterator=animals.iterator();
    }
}
