public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
//Java's event handling mechanism
    /**
     * Managing the event handling code
     * event kisteners and the way they are implemented
     * as inner methods
     * as seperate classes
     * as inner classes
     * as anonymous classes
     *
     * Explore the foll0wing on the Java-Oracle webpage
     * ActionListener Interface
     * ActionEvent class
     * WindowListener class
     *
     * class work
     * define a seperate ActionListener for the sbt button
     * add buttons
     *
     * For the user to intereact with a GUI, the underlying operating system
     * must support event handling
     *
     * 1) operating systems constantly monitor events such as keystrokes, mouse clicks, ink input, voice command, etc
     * 2) operating systems sort out these events and report them to the appropriate application programs
     * 3) The application makes the decisions for these events
     *
     * Many programming languages have their ways of implementing events
     * Visual Basic
     * each component responds to a fixed set of events
     * C
     * a giant loop with a massive switch statement
     * Java
     * -event delegation model- events are transmitted from event sources to event listeners
     * -you can designate any object to be an event listener
     *
     * Three components
     * Listener objects - is an instance of a class that implements a special interface called a listener interface
     * Event source - is an object that can register listener objects and send them event objects
     * Event object- event source sends out event objects to all registered listeners when that even occurs
     * The listener objects reacts based on the information in the event.
     *
     * register listener objects with the event source object
     * eventSourceObject.addEventListener(eventListenerObject);
     * example:
     * ActionListener listener = ...;
     * JButton button = new JButton("OK");
     * button.addActionListener(listener);
     *
     * The listener object is notified whenever an action event occurs in the button (i.e., a button click);
     *
     * public class GUIClass extends JFrame implements ActionListener{
     *     JButton add;
     *     JButton abt;
     *
     *     GUIClass(){
     *         //some other code
     *         add = new JButton("Add");
     *         add.addActionListener(this);
     *         abt = new JButton("Sub");
     *         abt.addActionListener(this);
     *
     *
     *     }
     *     This is the overriden method for ActionEvents
     *     public void actionPerformed(ActionEvent e){
     *         double x;
     *         if(e.getSource()==add){
     *             //event with variables (x)
     *
     *         }
     *     }
     *
     *
     * }
     *
     * The eventListener is either part of the GUIClass or
     * implemented seperately
     *
     * JFrame opens a window
     *
     * There are many different events
     * a) ActionEvent = sent by JButtonclick and other components
     * b) WindowEvent - sent by JFrame
     *
     * 1) ActionListener
     * 2) WindowListener - activated, closed, closing, deactivated, deconified, iconified, opened
     * The WindowListener has 5 or 6 methods that can be overriden
     *
     * The EventObjectclass has a subclass AWTEvent, which is the parent of all AWT event classes
     * Some of the Swing components generate event objects that directly extend EventObject, not AWTEvent
     * You can add your own custome events by subclassing EventObject or any of the subclasses
     *
     * These are the different events
     * -ActionEvent
     * -AdjustmentEvent
     * -ComponentEvent
     * -ItemEvent
     * -FocusEvent
     * -InputEvent
     * -PaintEvent
     * -WindowEvent
     * -KeyEvent
     * -MouseEvent
     * -MouseWheelEvent
     *
     * The Listeners are very close, but there are some differences
     *
     * Commonly used adapater classes
     * -FocusAdapter
     * -KeyAdapter
     * -MouseAdapter
     * -MouseMotionAdapter
     * -WindowAdapter
     *
     * Explore the following
     * -the ActionListener Interface
     * -the ActionEvent Class
     * -the WindowListener class
     *
     * class work
     * -define a seperate ActionListener for the sbt button
     * -add buttons for multiplications and subtractions and implement the ActionListeners for them
     * -add WindowListener to the GUI*/

}