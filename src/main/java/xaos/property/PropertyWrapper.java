package xaos.property;

/**
 * @author Florian Frankenberger
 */
public interface PropertyWrapper<T> {

  String unwrap(T value);

  T wrap(String raw);
}
