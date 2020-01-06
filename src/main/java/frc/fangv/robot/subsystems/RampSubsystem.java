package frc.fangv.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.fangv.robot.Constants;

public class RampSubsystem implements Subsystem
{
    CANSparkMax rampMotor;
    Solenoid    gate;

    /**
     * The Singleton instance of this RampSubsystem. External classes should
     * use the {@link #getInstance()} method to get the instance.
     */
    private final static RampSubsystem INSTANCE = new RampSubsystem();

    /**
     * Creates a new instance of this RampSubsystem.
     * This constructor is private since this class is a Singleton. External classes
     * should use the {@link #getInstance()} method to get the instance.
     */
    private RampSubsystem() {
        // TODO: Set the default command, if any, for this subsystem by calling setDefaultCommand(command)
        //       in the constructor or in the robot coordination class, such as RobotContainer.
        //       Also, you can call addChild(name, sendableChild) to associate sendables with the subsystem
        //       such as SpeedControllers, Encoders, DigitalInputs, etc.

        rampMotor = new CANSparkMax(Constants.RAMP_MOTOR_ID, CANSparkMaxLowLevel.MotorType.kBrushless);
        gate = new Solenoid(Constants.RAMP_FORWARD_CHANNEL);

    }

    /**
     * Returns the Singleton instance of this RampSubsystem. This static method
     * should be used -- {@code RampSubsystem.getInstance();} -- by external
     * classes, rather than the constructor to get the instance of this class.
     */
    public static RampSubsystem getInstance() {
        return INSTANCE;
    }

    public void forward(){ rampMotor.set(Constants.RAMP_MOTOR_SPEED); }

    public void stop() { rampMotor.set(Constants.RAMP_MOTOR_STOP); }

    public void open() { gate.set(true); }

    public void close() { gate.set(false); }

    public boolean isOpen(){
        if(gate.get())
            return true;
        else
            return false;
    }

}

