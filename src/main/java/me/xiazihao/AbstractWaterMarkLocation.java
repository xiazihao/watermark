package me.xiazihao;

abstract class AbstractWaterMarkLocation implements WaterMarkLocation {
    public static WaterMarkLocation LEFT_TOP = new WaterMarkLocation() {

        public Coordinate getStartCoordinate(Size sourceImageSize, Size waterMarkImageSize) {
            return new Coordinate(0, 0);
        }
    };

    public static WaterMarkLocation CENTER_TOP = new WaterMarkLocation() {
        public Coordinate getStartCoordinate(Size sourceImageSize, Size waterMarkImageSize) {
            double x = sourceImageSize.getX() / 2 - waterMarkImageSize.getX() / 2;
            double y = 0;
            return new Coordinate(x, y);
        }
    };

    public static WaterMarkLocation RIGHT_TOP = new WaterMarkLocation() {
        public Coordinate getStartCoordinate(Size sourceImageSize, Size waterMarkImageSize) {
            double x = sourceImageSize.getX() - waterMarkImageSize.getX();
            double y = 0;
            return new Coordinate(x, y);
        }
    };
}
