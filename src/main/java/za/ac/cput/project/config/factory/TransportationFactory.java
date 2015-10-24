package za.ac.cput.project.config.factory;

import za.ac.cput.project.domain.Rental;
import za.ac.cput.project.domain.Transportation;

import java.util.List;

/**
 * Created by student on 2015/10/24.
 */
public class TransportationFactory {

    public static Transportation createTransportation(String tansportationSerialNumber, String tansportationMake
                                                      ,String tansportationModel,String tansportationType,List<Rental> rentals)
    {
        Transportation transportation = new Transportation
                .Builder(tansportationSerialNumber)
                .tansportationMake(tansportationMake)
                .tansportationModel(tansportationModel)
                .tansportationType(tansportationType)
                .rentals(rentals)
                .build();

        return transportation;
    }
}
