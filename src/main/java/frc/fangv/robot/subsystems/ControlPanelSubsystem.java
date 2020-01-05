import edu.wpi.first.wpilibj.command.Subsystem;

public class ControlPanelSubsystem extends Subsystem {

// Any variables/fields used in the constructor must appear before the "INSTANCE" variable
// so that they are initialized before the constructor is called.

    /**
     * The Singleton instance of this ControlPanelSubsystem. External classes should
     * use the {@link #getInstance()} method to get the instance.
     */
    private final static ControlPanelSubsystem INSTANCE = new ControlPanelSubsystem();

    /**
     * Creates a new instance of this ControlPanelSubsystem.
     * This constructor is private since this class is a Singleton. External classes
     * should use the {@link #getInstance()} method to get the instance.
     */
    private ControlPanelSubsystem() {

    }

    /**
     * Returns the Singleton instance of this ControlPanelSubsystem. This static method
     * should be used -- {@code ControlPanelSubsystem.getInstance();} -- by external
     * classes, rather than the constructor to get the instance of this class.
     */
    public static ControlPanelSubsystem getInstance() {
        return INSTANCE;
    }

    @Override
    protected void initDefaultCommand() {
        // TODO: Set the default command, if any, for this subsystem by calling setDefaultCommand(command)
        //       e.g. setDefaultCommand(new MyCommand());
    }
}

