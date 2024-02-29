public final class Hometown implements Serializable {
  // ... All methods the same except the following:
 
  // writeObject() correctly enforces checks during serialization
  private void writeObject(ObjectOutputStream out) throws IOException {
    performSecurityManagerCheck();
    out.writeObject(town);
  }
 
  // readObject() correctly enforces checks during deserialization
  private void readObject(ObjectInputStream in) throws IOException {
    in.defaultReadObject();
    // If the deserialized name does not match the default value normally
    // created at construction time, duplicate the checks
    if (!UNKNOWN.equals(town)) {
      performSecurityManagerCheck();
      validateInput(town);
    }
  }
}
