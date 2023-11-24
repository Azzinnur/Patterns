package creative_patterns.builder.builders;

import creative_patterns.builder.entities.CarType;
import creative_patterns.builder.entities.Engine;
import creative_patterns.builder.entities.GPSNavigator;
import creative_patterns.builder.entities.Transmission;
import creative_patterns.builder.entities.TripComputer;

public interface AbstractBuilder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}
