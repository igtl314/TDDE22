public class PointSlope {

    private Point p;
    private Double angle;

    public void PointSlope(Point p, double angle ){
      this.p = p;
      this.angle = angle;
    }
    public void setP(Point in){
        p = in;
    }
    public void setAngle(Double in){
        angle = in;
    }

    public Point getP(){
        return p;
    }

    public Double getAngle() {
        return angle;
    }
}
