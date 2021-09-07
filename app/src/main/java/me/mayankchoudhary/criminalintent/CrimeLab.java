package me.mayankchoudhary.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// single-ton class
public class CrimeLab {
    private static CrimeLab sCrimeLab;
    private List<Crime> mCrimes;

    private CrimeLab(Context context) {
        mCrimes = new ArrayList<>();
        for(int i = 0; i < 100 ; i++) {
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i % 2 ==0);
            mCrimes.add(crime);
        }
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }


    public Crime getCrime(UUID uuid) {
        for(Crime crime: mCrimes) {
            if(crime.getID().equals(uuid)) {
                return crime;
            }
        }
        return null;
    }

    public static CrimeLab get(Context context) {
        if(sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }


}


//Singletons and
//centralized data storage
//You are going to store the List of
//crimes in a singleton. A singleton is a
//class that allows only one instance of
//itself to be created.
//A singleton exists as long as the
//application stays in memory, so storing
//the list in a singleton will keep the crime
//data available throughout any lifecycle
//changes in your activities and fragments.
//Be careful with singleton classes, as
//they will be destroyed when Android
//removes your application from memory.