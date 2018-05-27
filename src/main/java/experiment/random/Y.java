package experiment.random;

import java.text.MessageFormat;

/**
 * Created 7/24/2017 15:19
 *
 * @author Deepankar Sharma
 */
public class Y {

  private Integer x;
  private Integer y;

  protected Y() {
  }

  public Y(Integer x, Integer y) {
    this.x = x;
    this.y = y;
  }

  public Integer getX() {
    return x;
  }

  public void setX(Integer x) {
    this.x = x;
  }

  public Integer getY() {
    return y;
  }

  public void setY(Integer y) {
    this.y = y;
  }

  @Override public String toString() {
    return MessageFormat.format("[X={0}, Y={1}]", x,y);
  }
}
