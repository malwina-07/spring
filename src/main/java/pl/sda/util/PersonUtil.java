package pl.sda.util;

public class PersonUtil {
    // klasa narzędziowa
    //parsowanie id Integer do id String

    public int parseIdToInd(String id){

        if(id == null | id.trim().isEmpty()){
            throw new IllegalArgumentException("Id is empty");
        }
         return Integer.parseInt(id);

    }
}
