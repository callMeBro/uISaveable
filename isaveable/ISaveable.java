/*
This interface  allows the object to be saved to some sort of storage medium
Abstraction:
Defines the functionality for something without implementoing the details. The
detales are implemented when a class implements the interface.
 */
package isaveable;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adder
 */
public interface ISaveable {

    public List<String> write();

    public void read(List<String> li);

}
