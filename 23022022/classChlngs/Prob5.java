// Interface Challenge: 
// Create an interface called “Playable” with methods like “play” and “stop”. 
// Implement the interface in classes like “Guitar”, “Drums”, and “Piano”. 
// Create an array of “Playable” objects containing instances of each class
//  and loop through the array, calling the “play” and “stop” methods for each instrument.

package classChlngs;

public class Prob5 {
    public static void main(String[] args) {
        Playable[] insts = new Playable[3];
        insts[0] = new Guitar();
        insts[1] = new Drum();
        insts[2] = new Piano();

        for (Playable i: insts){
            i.play();
            i.stop();
        }
        
    }
}

interface Playable {
    void play();
    void stop();
}

class Guitar implements Playable {
    public void play(){
        System.out.println("Guitar is playing");
    }
    public void stop(){
        System.out.println("Guitar is stopped");
    }
}

class Drum implements Playable {
    public void play(){
        System.out.println("Drum is playing");
    }
    public void stop(){
        System.out.println("Drum is stopped");
    }
}

class Piano implements Playable {
    public void play(){
        System.out.println("Piano is playing");
    }
    public void stop(){
        System.out.println("Piano is stopped");
    }
}