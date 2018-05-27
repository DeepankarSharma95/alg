package experiment.generics;

/**
 * Created 5/11/2017 15:44
 *
 * @author Deepankar Sharma
 */
public class GenericContainer<T> {
  private T obj;

  public GenericContainer() {
  }

  public GenericContainer(T t) {
    obj = t;
  }

  public T getObj() {
    return obj;
  }

  public void setObj(T obj) {
    this.obj = obj;
  }
}
