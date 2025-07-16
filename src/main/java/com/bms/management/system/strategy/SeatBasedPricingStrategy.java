package com.bms.management.system.strategy;

import com.bms.management.system.enums.SeatType;
import com.bms.management.system.model.Booking;
import com.bms.management.system.model.ShowSeat;
import org.springframework.stereotype.Component;

@Component
public class SeatBasedPricingStrategy implements PricingStrategy {

    private static final double VIP_PRICE = 250.0;
    private static final double PLATINUM_PRICE = 200.0;
    private static final double GOLD_PRICE = 150.0;
    private static final double SILVER_PRICE = 100.0;



    @Override
    public Double calculatePrice(ShowSeat seat) {
        return getPrice(seat.getSeat().getSeatType());
    }

    //ocp violation
    //Move to the db
    //Based(theatre_id, seat_type,movie) =>price
    public double getPrice(SeatType seatType) {
         switch (seatType) {
            case VIP -> {return VIP_PRICE;}
            case PLATINUM -> {return PLATINUM_PRICE;}
            case GOLD->{return GOLD_PRICE;}
            case SILVER->{return SILVER_PRICE;}
        }
        throw new IllegalArgumentException("Unknown seat type: " + seatType);
    }
}
