package me.xiazihao;

abstract class AbstractWaterMarkLocation implements WaterMarkLocation {
    public static final WaterMarkLocation LEFT_TOP = new WaterMarkLocation() {

        public Coordinate getStartCoordinate(Size sourceImageSize, Size waterMarkImageSize) {
            return new Coordinate(0, 0);
        }
    };

    public static final WaterMarkLocation CENTER_TOP = new WaterMarkLocation() {
        public Coordinate getStartCoordinate(Size sourceImageSize, Size waterMarkImageSize) {
            double x = sourceImageSize.getX() / 2 - waterMarkImageSize.getX() / 2;
            double y = 0;
            return new Coordinate(x, y);
        }
    };

    public static final WaterMarkLocation RIGHT_TOP = new WaterMarkLocation() {
        public Coordinate getStartCoordinate(Size sourceImageSize, Size waterMarkImageSize) {
            double x = sourceImageSize.getX() - waterMarkImageSize.getX();
            double y = 0;
            return new Coordinate(x, y);
        }
    };

    public static final WaterMarkLocation LEFT_CENTER = new WaterMarkLocation() {
        public Coordinate getStartCoordinate(Size sourceImageSize, Size waterMarkImageSize) {
            double x = 0;
            double y = sourceImageSize.getY() / 2 - waterMarkImageSize.getY() / 2;

            return new Coordinate(x,y);
        }
    };

    public static final WaterMarkLocation CENTER_CENTER = new WaterMarkLocation() {
        public Coordinate getStartCoordinate(Size sourceImageSize, Size waterMarkImageSize) {
            double x = sourceImageSize.getX() / 2 - waterMarkImageSize.getX() / 2;
            double y = sourceImageSize.getY() / 2 - waterMarkImageSize.getY() / 2;
            return new Coordinate(x,y);
        }
    };

    public static final WaterMarkLocation RIGHT_CNETER = new WaterMarkLocation() {
        public Coordinate getStartCoordinate(Size sourceImageSize, Size waterMarkImageSize) {
            double x = sourceImageSize.getX() - waterMarkImageSize.getX();
            double y = sourceImageSize.getY() / 2 - waterMarkImageSize.getY() / 2;
            return new Coordinate(x,y);
        }
    };

    public static final WaterMarkLocation LEFT_BUTTON = new WaterMarkLocation() {
        public Coordinate getStartCoordinate(Size sourceImageSize, Size waterMarkImageSize) {
            double x = 0;
            double y = sourceImageSize.getY() - waterMarkImageSize.getY();
            return new Coordinate(x,y);
        }
    };

    public static final WaterMarkLocation CENTER_BUTTON = new WaterMarkLocation() {
        public Coordinate getStartCoordinate(Size sourceImageSize, Size waterMarkImageSize) {
            double x = sourceImageSize.getX() / 2 - waterMarkImageSize.getX() / 2;
            double y = sourceImageSize.getY() - waterMarkImageSize.getY();
            return new Coordinate(x,y);
        }
    };

    public static final WaterMarkLocation RIGHT_BUTTON = new WaterMarkLocation() {
        public Coordinate getStartCoordinate(Size sourceImageSize, Size waterMarkImageSize) {
            double x = sourceImageSize.getX() - waterMarkImageSize.getX();
            double y = sourceImageSize.getY() - waterMarkImageSize.getY();
            return new Coordinate(x,y);
        }
    };
}
