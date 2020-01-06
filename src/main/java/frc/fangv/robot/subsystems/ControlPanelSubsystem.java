package frc.fangv.robot.subsystems;

import frc.fangv.robot.Constants;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.Subsystem;

public class ControlPanelSubsystem implements Subsystem {
// Any variables/fields used in the constructor must appear before the "INSTANCE" variable
// so that they are initialized before the constructor is called.

    CANSparkMax controlPanelMotor;
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

    /** FORWARD */
    public void Forward(){ controlPanelMotor.set(Constants.FORWARDSPEED);}

    /** BACKWARD */
    public void Backward(){ controlPanelMotor.set(Constants.BACKWARDSPEED);}

    /** STOP */
    public void Stop(){ controlPanelMotor.set(Constants.STOPSPEED);}

    /** Set */
    public void Set(double passVal){ controlPanelMotor.set(passVal);}

    /** Get */
    public double getPos(){ return controlPanelMotor.getEncoder().getPosition();}
}

