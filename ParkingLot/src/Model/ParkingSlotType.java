package Model;

public enum ParkingSlotType {

    TwoWheeler{
        @Override
        public double getPriceForParking(long duration) {
            return duration* .05;
        }
    },
    Compact{
        @Override
        public double getPriceForParking(long duration) {
            return 0.075 * duration;
        }
    },
    Medium{
        @Override
        public double getPriceForParking(long duration) {
            return .09 * duration;
        }
    },
    Large{
        @Override
        public double getPriceForParking(long duration) {
            return .1 * duration;
        }
    };

    public abstract double getPriceForParking(long duration);
}
