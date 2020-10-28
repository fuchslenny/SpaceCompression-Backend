/**
 * @author fuchslenny
 */

package space.backend.main;

import space.backend.helper.Threads;

public class Main {

    public static void main(String[] args){
        Threads newThread = new Threads("Main Thread");
        newThread.start();
    }
}
